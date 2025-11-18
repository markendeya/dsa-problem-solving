import java.util.HashMap;

public class PathSumIII {
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, 0, targetSum, map);
    }

    private int dfs(TreeNode node, long curr, int target, HashMap<Long, Integer> map) {
        if (node == null) return 0;

        curr += node.val;
        int count = map.getOrDefault(curr - target, 0);

        map.put(curr, map.getOrDefault(curr, 0) + 1);

        count += dfs(node.left, curr, target, map);
        count += dfs(node.right, curr, target, map);

        map.put(curr, map.get(curr) - 1); // backtrack

        return count;
    }
}
