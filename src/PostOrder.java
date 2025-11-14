 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;

     TreeNode(int x) { val = x; }

     TreeNode(int x, TreeNode left, TreeNode right) {
         this.val = x;
         this.left = left;
         this.right = right;
     }
 }

class PostOrder {
    int totalMoves; // Stores the total number of moves required

    public int balanceCoins(TreeNode root) {
        totalMoves = 0; // Initialize total moves to 0
        postOrderTraversal(root); // Begin post-order traversal to balance coins starting from the root
        return totalMoves; // Return the total number of moves calculated
    }

    public int postOrderTraversal(TreeNode node) {
        if (node == null) return 0; // Base case: if node is null, return 0 as no action is needed

        int leftExcess = postOrderTraversal(node.left); // Recursively balance left subtree and get excess coins
        int rightExcess = postOrderTraversal(node.right); // Recursively balance right subtree and get excess coins

        totalMoves += Math.abs(leftExcess) + Math.abs(rightExcess); // Increment total moves by the absolute excess from both subtrees

        return node.val + leftExcess + rightExcess - 1; // Return the net excess (or deficit) of coins for the current node
    }

    public static void main(String[] args) {
        PostOrder solution = new PostOrder();

        // Example 1: [1,0,2]
        TreeNode example1 = new TreeNode(1, new TreeNode(0), new TreeNode(2));
        // Example 2: [2,0,2,2,0,0]
        TreeNode example2 = new TreeNode(2, new TreeNode(0, new TreeNode(2), new TreeNode(0)), new TreeNode(2, new TreeNode(0), null));
        // Example 3: [4,0,0,0]
        TreeNode example3 = new TreeNode(4, new TreeNode(0, new TreeNode(0), null), new TreeNode(0));

        System.out.println("Example 1 Moves: " + solution.balanceCoins(example1)); // Expected Output: 2
        System.out.println("Example 2 Moves: " + solution.balanceCoins(example2)); // Expected Output: 4
        System.out.println("Example 3 Moves: " + solution.balanceCoins(example3)); // Expected Output: 4
    }
}


