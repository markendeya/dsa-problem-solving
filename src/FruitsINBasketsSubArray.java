import java.util.HashMap;
import java.util.Map;

public class FruitsINBasketsSubArray {
/*
    Input: arr=['A', 'B', 'C', 'A', 'C']
    Output: 3
    Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
*/
    public int findLength(char[] arr) {
        int left = 0, maxLength = 0;
        Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
        for (int right = 0; right < arr.length; right++) {
            fruitFrequencyMap.put(arr[right],
                    fruitFrequencyMap.getOrDefault(arr[right], 0) + 1);
            while (fruitFrequencyMap.size() > 2) {
                fruitFrequencyMap.put(arr[left],fruitFrequencyMap.get(arr[left]) - 1);
                if (fruitFrequencyMap.get(arr[left]) == 0) {
                    fruitFrequencyMap.remove(arr[left]);
                }
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
