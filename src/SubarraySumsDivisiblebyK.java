import java.util.HashMap;

public class SubarraySumsDivisiblebyK {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int prefix = 0, count = 0;

        for (int num : nums) {
            prefix += num;
            int mod = prefix % k;

            if (mod < 0) mod += k; // handle negative values

            if (map.containsKey(mod)) {
                count += map.get(mod);
            }

            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        return count;
    }
}
