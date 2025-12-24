public class GasStation {

    public int canCompleteCircuitBruteForce(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < gas.length; i++) {
            int fuel = 0;
            boolean canComplete = true;
            for (int j = 0; j < n; j++) {
                int idx = (i + j) % n;
                fuel += gas[idx % n] - cost[idx];
                if (fuel < 0) {
                    canComplete = false;
                    break;
                }
            }
            if(canComplete){
                return i;
            }
        }
        return -1;
    }
    public int canCompleteCircuitOptimised(int[] gas, int[] cost) {
        int n = gas.length;
        int start=0;
        int fuel =0;
        int totalGas =0;
        int totalCost=0;
        for (int i = 0; i < gas.length; i++) {
            totalGas+=gas[i];
            totalCost+=cost[i];
            fuel+=gas[i]-cost[i];
            if(fuel<0){
                fuel=0;
                start=i+1;
            }

        }
        return totalGas>=totalCost ? start:-1;
    }
}
