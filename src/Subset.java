import java.util.*;

public class Subset {
    static List<List<Integer>> result = new LinkedList<>();

    public static List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private static void backtrack(int[] nums, int start, List<Integer> path) {
        result.add(new LinkedList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums, i + 1, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(subsets(nums));
    }
}

