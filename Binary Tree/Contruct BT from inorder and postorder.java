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
    public TreeNode build(int[] in,int inS,int inE,int[] post,int postS,int postE,HashMap<Integer,Integer> map)
    {
        if(inS>inE ||postS>postE)
        {
            return null;
        }
        TreeNode node=new TreeNode(post[postE]);
        int ind=map.get(node.val);
        int num=ind-inS;
        node.left=build(in,inS,ind-1,post,postS,postS+num-1,map);
        node.right=build(in,ind+1,inE,post,postS+num,postE-1,map);
        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
        TreeNode root=build(inorder,0,inorder.length-1,postorder,0,postorder.length-1,map);
        return root;
    }
}