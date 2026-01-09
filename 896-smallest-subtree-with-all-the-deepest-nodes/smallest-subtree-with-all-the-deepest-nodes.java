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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    public Result dfs(TreeNode node)
    {
        if(node==null) return new Result(node,0);
        Result L=dfs(node.left);
        Result R=dfs(node.right);
        
        if(L.dist>R.dist) return new Result(L.node, L.dist+1);
        if(R.dist>L.dist) return new Result(R.node, R.dist+1);
        return new Result(node, L.dist+1);
    }

    class Result
    {
        TreeNode node;
        int dist;
        Result(TreeNode n , int d)
        {
            node =n;
            dist=d;
        }
    }
}