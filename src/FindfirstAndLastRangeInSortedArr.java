import java.util.Arrays;

public class FindfirstAndLastRangeInSortedArr {
        public int[] searchRange(int[] nums, int target) {
            int[] result = new int[] { -1, -1 };
            result[0] = find(nums,target,true);
            if(result[0] == -1)
                return result;
            result[1] = find(nums, target,false);
            return result;
        }

        private int find(int[] nums, int target,boolean leftSide){
            int idx = -1;
            int start = 0;
            int end = nums.length - 1;
            while( start<= end ){
                int mid=start+(end-start)/2;
                if(nums[mid]> target){
                    end = mid-1;
                }else if(nums[mid]<target){
                    start = mid+1;
                }else{
                    idx=mid;
                    if(leftSide)
                        end=mid-1;
                    else
                        start=mid+1;
                }

            }
            return idx;
        }
    }
