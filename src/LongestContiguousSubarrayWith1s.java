public class LongestContiguousSubarrayWith1s {

//    Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
//    Output: 6
//    Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.

    public int findLength(int[] arr, int k) {
        int left = 0, maxLength = 0, maxOnesCount = 0;
        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 1)
                maxOnesCount++;
            if (right - left + 1 - maxOnesCount > k) {
                if (arr[left] == 1)
                    maxOnesCount--;
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
