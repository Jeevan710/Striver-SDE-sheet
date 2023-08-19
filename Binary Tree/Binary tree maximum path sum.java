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
    public int maxPath(TreeNode root,int[] dp)
    {
        if(root==null)
        {
            return 0;
        }
        int l=Math.max(0,maxPath(root.left,dp));
        int r=maxPath(root.right,dp));

        dp[0]=Math.max(dp[0],l+r+root.val);
        return (Math.max(l,r)+root.val);
    }
    public int maxPathSum(TreeNode root) {
        int dp[]=new int[1];
        dp[0]=Integer.MIN_VALUE;
        int a=maxPath(root,dp);
        return dp[0];
    }
}