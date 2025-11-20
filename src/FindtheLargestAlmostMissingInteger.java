import java.util.HashMap;

public class FindtheLargestAlmostMissingInteger {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> windowCount = new HashMap<>();

        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

            if (right - left + 1 == k) {
                for (int key : freq.keySet()) {
                    windowCount.put(key, windowCount.getOrDefault(key, 0) + 1);
                }
                freq.put(nums[left], freq.get(nums[left]) - 1);
                if (freq.get(nums[left]) == 0) freq.remove(nums[left]);
                left++;
            }
        }

        int ans = -1;

        for (int key : windowCount.keySet()) {
            if (windowCount.get(key) == 1) {
                ans = Math.max(ans, key);
            }
        }

        return ans;
    }
}