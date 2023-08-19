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
    public int hei(TreeNode root)
    {
        if(root==null)
        {
            return 0;
        }
        int l=hei(root.left);
        if(l==-1)
        {
            return -1;
        }
        int r=hei(root.right);
        if(r==-1)
        {
            return -1;
        }
        if(Math.abs(l-r)>1)
        {
            return -1;
        }
        return Math.max(l,r)+1;
    }
    public boolean isBalanced(TreeNode root) {
        int a=hei(root);
        return a==-1?false:true;
    }
}