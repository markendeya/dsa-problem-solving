import java.util.HashMap;

public class CountNiceSubarrays {
//    Input: nums = [1,1,2,1,1], k = 3
//    Output: 2
//    Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
public int numberOfSubarrays(int[] nums, int k) {

    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    int prefix = 0, count = 0;

    for (int n : nums) {

        prefix += (n % 2); // odd -> 1, even -> 0

        if (map.containsKey(prefix - k)) {
            count += map.get(prefix - k);
        }

        map.put(prefix, map.getOrDefault(prefix, 0) + 1);
    }
    return count;
}
}
