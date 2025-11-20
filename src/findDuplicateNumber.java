public class findDuplicateNumber {
    public int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {  // Check if the current element is in its correct position
                if (nums[i] != nums[nums[i] - 1])  // Check if there is a duplicate at the current position
                    swap(nums, i, nums[i] - 1);  // Swap elements to their correct positions
                else // We have found the duplicate
                    return nums[i]; // Return the duplicate number
            } else {
                i++; // Move to the next element
            }
        }

        return -1; // No duplicate found
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
