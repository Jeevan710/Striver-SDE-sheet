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
    public TreeNode sorted(int[]nums,int i,int j)
    {
        if(i>j)
        {
            return null;
        }
        int mid=(i+j)/2;
        TreeNode t=new TreeNode(nums[mid]);
        t.left=sorted(nums,i,mid-1);
        t.right=sorted(nums,mid+1,j);
        return t;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return sorted(nums,0,nums.length-1);
    }
}