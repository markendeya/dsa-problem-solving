public class MaxSumSubArrayOfk {
    /*maximum sum of any contiguous subarray of size 'k'.
Input: arr = [2, 1, 5, 1, 3, 2], k=3
Output: 9
     */
    public int findMaxSumSubArray(int k, int[] arr) {
        int windowSum = 0, maxSum = 0;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            windowSum += arr[right];
            if (right >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[left];
                left++;
            }
        }

        return maxSum;
    }
}
