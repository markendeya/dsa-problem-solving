import java.util.Map;

public class MaxPathSum {

    private static int globalMaximumSum;

    public int findMaximumPathSum(TreeNode root) {
        globalMaximumSum = Integer.MIN_VALUE;
        findMaximumPathSumRecursive(root);
        return globalMaximumSum;
    }
    private static int findMaximumPathSumRecursive(TreeNode currentNode) {
     if(currentNode == null){
         return 0;
     }
     int maxLeft = findMaximumPathSumRecursive(currentNode.left);
     int maxRight = findMaximumPathSumRecursive(currentNode.right);
     maxLeft = Math.max(maxLeft,0);
     maxRight = Math.max(maxRight,0);
     int currentLocalMax = maxLeft+maxRight+currentNode.val;
     globalMaximumSum = Math.max(globalMaximumSum,currentLocalMax);

     return Math.max(maxLeft,maxRight)+currentNode.val;
    }

    public static void main(String[] args) {
        MaxPathSum sol = new MaxPathSum();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + sol.findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + sol.findMaximumPathSum(root));

        root = new TreeNode(-1);
        root.left = new TreeNode(-3);
        System.out.println("Maximum Path Sum: " + sol.findMaximumPathSum(root));
    }
};

