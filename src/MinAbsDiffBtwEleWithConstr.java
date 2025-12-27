import java.util.TreeSet;

public class MinAbsDiffBtwEleWithConstr {
//    Input: nums = [4,3,2,4], x = 2
//    Output: 0
//    Explanation: We can select nums[0] = 4 and nums[3] = 4.
//    They are at least 2 indices apart, and their absolute difference is the minimum, 0.
//    It can be shown that 0 is the optimal answer.

    public int minAbsoluteDifference(int[] nums, int x) {
        TreeSet<Integer> ts = new TreeSet<>();
        int ans = Integer.MAX_VALUE;

        for (int j = x; j < nums.length; j++) {
            ts.add(nums[j - x]);

            Integer floor = ts.floor(nums[j]);
            if (floor != null)
                ans = Math.min(ans, nums[j] - floor);

            Integer ceil = ts.ceiling(nums[j]);
            if (ceil != null)
                ans = Math.min(ans, ceil - nums[j]);
        }

        return ans;
    }
}
