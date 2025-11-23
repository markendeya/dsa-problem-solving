public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int left =0;
        int right = nums.length-1;
        if(nums[0]>nums[1]) return 0;
        if(nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }
        int low =1;
        int high = nums.length-2;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]>nums[mid+1] && nums[mid] >nums[mid-1]){
                return mid;
            }else if( nums[mid]>nums[mid+1]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

    public int findPeakElementOptimised(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;      // peak is on the right
            } else {
                right = mid;         // peak is on the left or mid itself
            }
        }

        return left;  // or right (same)
    }
}
