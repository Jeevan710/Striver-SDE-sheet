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
    public int dia(TreeNode root,int[] dp)
    {
        if(root==null)
        {
            return 0;
        }
        int l=dia(root.left,dp);
        int r=dia(root.right,dp);
        dp[0]=Math.max(l+r,dp[0]);
        return Math.max(l,r)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int dp[]=new int[1];
        dp[0]=0;
        dia(root,dp);
        return dp[0];
    }
}