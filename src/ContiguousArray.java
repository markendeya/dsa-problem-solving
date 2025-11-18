import java.util.HashMap;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int prefix = 0, maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix += (nums[i] == 0 ? -1 : 1);

            if (map.containsKey(prefix)) {
                maxLen = Math.max(maxLen, i - map.get(prefix));
            } else {
                map.put(prefix, i);
            }
        }

        return maxLen;
    }
}
