public class MinSizeSubArraySum {
//    Input: arr = [2, 1, 5, 2, 3, 2], S=7
//    Output: 2
//    Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].

    public int findMinSubArray(int S, int[] arr) {
        int windowSum = 0, minLength = Integer.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            windowSum += arr[right];
            while (windowSum >= S) {
                minLength = Math.min(minLength, right - left + 1);
                windowSum -= arr[left];
                left++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
