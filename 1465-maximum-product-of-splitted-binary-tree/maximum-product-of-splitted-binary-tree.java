/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    long totalSum = 0;
    long maxProd = 0;
    List<Long> subtreeSums = new ArrayList<>();
    long dfs(TreeNode root) {
        if (root == null) return 0;
        long sum = root.val + dfs(root.left) + dfs(root.right);
        subtreeSums.add(sum);
        return sum;
    }

    public int maxProduct(TreeNode root) {
        totalSum = dfs(root);

        for (long s : subtreeSums) {
            maxProd = Math.max(maxProd, s * (totalSum - s));
        }
        return (int)(maxProd % 1000000007);
    }
}