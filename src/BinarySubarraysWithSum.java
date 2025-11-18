import java.util.HashMap;

public class BinarySubarraysWithSum {
// Input: nums = [1,0,1,0,1], goal = 2
//Output: 4
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        hm.put(0,1);
        int prefixSum=0;
        int count=0;
        for(int num:nums){
            prefixSum+=num;
            if(hm.containsKey(prefixSum-goal)){
                count+=hm.get(prefixSum-goal);
            }
            hm.put(prefixSum,hm.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }
}
