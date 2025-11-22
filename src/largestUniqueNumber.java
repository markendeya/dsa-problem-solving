import java.util.HashMap;

public class largestUniqueNumber {
    public int largestUniqueNumber(int[] A) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Populate the hashmap with number frequencies
        for (int num : A) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        int maxUnique = -1;
        // Traverse the hashmap to find the largest unique number
        for (int key : freq.keySet()) {
            if (freq.get(key) == 1) {
                maxUnique = Math.max(maxUnique, key);
            }
        }

        return maxUnique;
    }
}
