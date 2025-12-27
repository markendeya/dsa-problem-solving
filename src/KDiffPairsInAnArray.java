import java.util.HashMap;
import java.util.Map;
/*
Input: nums = [3,1,4,1,5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
        */
public class KDiffPairsInAnArray {

    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int count = 0;

        for (int num : map.keySet()) {
            if (k == 0) {
                if (map.get(num) > 1) count++;
            } else {
                if (map.containsKey(num + k)) count++;
            }
        }

        return count;
    }
}
