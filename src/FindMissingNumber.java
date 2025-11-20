public class FindMissingNumber {
        public int missingNumber(int[] nums) {
            if( nums.length==0)
                return 0;
            // cyclic pattern
            int i=0;
            while(i<nums.length) {
                if(nums[i]<nums.length && nums[i] != nums[nums[i]]) {
                    swap(nums,i,nums[i]);
                }else {
                    i++;
                }
            }
            for(i=0;i<nums.length;i++){
                if(nums[i] != i)
                    return i;
            }

            return nums.length;
        }
        public void swap(int[]nums,int i,int j){
            int temp = nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
    }
