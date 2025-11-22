public class findAveragesSubArraySumOfK {
    // Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
    public double[] findAverages(int K, int[] arr) {
        double[] result = new double[arr.length - K + 1];
        double windowSum = 0;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            windowSum += arr[right];
            if (right >= K - 1) {
                result[left] = windowSum / K; // calculate the average
                windowSum -= arr[left];
                left++;
            }
        }
        return result;
    }
}
