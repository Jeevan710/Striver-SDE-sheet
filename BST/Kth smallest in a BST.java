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
    public int small(TreeNode root,int[] k)
    {
        if(root==null)
        {
            return Integer.MIN_VALUE;
        }
        int l=small(root.left,k);
        if(l!=Integer.MIN_VALUE)
        {
            return l;
        }
        k[0]--;
        if(k[0]==0)
        {
            return root.val;
        }
        int r=small(root.right,k);
        return r;
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] p=new int[]{k};
        return small(root,p);
        
    }
}