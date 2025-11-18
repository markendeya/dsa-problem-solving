import java.util.HashMap;

public class MinimumSizeSubarraySum {
 //  return the minimal length of a subarray whose sum is greater than or equal to target
    public int minSubArrayLen(int target, int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int currSum =0;
        int minLen =Integer.MAX_VALUE;
        int left=0;
        int right=0;
        for(right=0;right<nums.length;right++){
            currSum+=nums[right];
            while(currSum>=target){
                minLen = Math.min(minLen,right-left+1);
                currSum-=nums[left++];
            }
        }
        return minLen!=Integer.MAX_VALUE?minLen:0 ;
    }
}
