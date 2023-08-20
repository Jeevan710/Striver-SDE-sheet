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
    public TreeNode build(int[] pre,int bound,int[] i)
    {
        if(i[0]>=pre.length || pre[i[0]]>bound)
        {
            return null;
        }
        TreeNode node=new TreeNode(pre[i[0]++],build(pre,pre[i[0]-1],i),build(pre,bound,i));
        return node;
    }

    public TreeNode bstFromPreorder(int[] preorder) {
        int[] i=new int[1];
        i[0]=0;
        return build(preorder,Integer.MAX_VALUE,i);
    }
}