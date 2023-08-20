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

 class Node
 {
     int maxi,mini,sum;
     Node(int mini,int maxi,int sum)
     {
         this.mini=mini;
         this.maxi=maxi;
         this.sum=sum;
     }
 }
class Solution {
    int max=0;
    public Node maxSum(TreeNode root)
    {
        if(root==null)
        {
            return new Node(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        Node l=maxSum(root.left);
        Node r=maxSum(root.right);
        if(l.maxi<root.val && root.val<r.mini)
        {
            max=Math.max(max,root.val+l.sum+r.sum);
            return new Node(Math.min(root.val,l.mini),Math.max(root.val,r.maxi),root.val+r.sum+l.sum);
        }
        return new Node(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(l.sum,r.sum));
    }
    public int maxSumBST(TreeNode root) {
        maxSum(root);
        return max;
    }
}