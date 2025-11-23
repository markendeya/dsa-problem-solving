import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStreams {
        // maxHeap → contains the smaller half of the numbers
        // always keeps the LARGEST of the smaller half at the top
        private PriorityQueue<Integer> maxHeap;

        // minHeap → contains the larger half of the numbers
        // always keeps the SMALLEST of the larger half at the top
        private PriorityQueue<Integer> minHeap;

        public FindMedianFromDataStreams() {
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {

            // Step 1: Always add new number to maxHeap (smaller half)
            maxHeap.offer(num);

            // Step 2: Move the largest number from maxHeap → minHeap
            // ensures all numbers in maxHeap <= all numbers in minHeap
            minHeap.offer(maxHeap.poll());

            // Step 3: Rebalance heaps
            // maxHeap is allowed to have ONE extra element
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            // If odd count → median is top of maxHeap
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            }

            // If even count → median is avg of both heap tops
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }
