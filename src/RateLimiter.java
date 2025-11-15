import java.util.concurrent.locks.Lock;

import java.util.concurrent.locks.ReentrantLock;
class Main {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(5, 1, 1000);
        rateLimiter.rateLimit();
        rateLimiter.rateLimit();
        rateLimiter.rateLimit();
        rateLimiter.rateLimit();
        rateLimiter.rateLimit();
        rateLimiter.rateLimit();
        rateLimiter.rateLimit();

        Thread.sleep(2000);
        rateLimiter.rateLimit();
        rateLimiter.rateLimit();
    }
}

class RateLimiter {

    private final int capacity;
    private final int tokensPerPeriod;
    private final int intervalMs;
    private int available;
    private int lastRefillPeriod;
    private long nextRefillTimeMs;
    private Lock mutex = new ReentrantLock();

    public RateLimiter(int capacity, int tokensPerPeriod, int intervalMs) {

        this.capacity = capacity;
        this.tokensPerPeriod = tokensPerPeriod;
        this.intervalMs = intervalMs;
        this.available = capacity;
    }

    boolean rateLimit() {
        mutex.lock();
        refillLocked();
        if (available > 0) {
            available--;
            System.out.println("Decrement available by 1: " + available);
            return true;
        } else {
            System.out.println("Not tokens available. Rate limiting");
        }
        return false;
    }

    private void refillLocked() {
        int curPeriod = getCurrentPeriod();
        if (available > capacity) {
            System.out.println("Available greater than capacity. Refill not needed");
            return;
        }
        if (curPeriod == lastRefillPeriod || available == capacity) {
            System.out.println("We already refilled for this period");
            return;
        }
        int numTokensMissed = (curPeriod - lastRefillPeriod) * tokensPerPeriod;
        available = Math.min(available + numTokensMissed, capacity);
        System.out.println("Refilling tokens to available: " + available);
        lastRefillPeriod = curPeriod;
        nextRefillTimeMs = (curPeriod + 1L) * intervalMs;
    }

    int getCurrentPeriod() {
        long now = System.currentTimeMillis();
        return (int) (now / intervalMs);
    }
}

