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
 class Pair
 {
     int val;
     TreeNode root;
     Pair(int val,TreeNode root)
     {
         this.val=val;
         this.root=root;
     }
 }
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)
        {
            return 0;
        }
        int res=0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,root));

        while(!q.isEmpty())
        {
            int n=q.size();
            int l=q.peek().val;
            int left=0,right=0;
            for(int i=0;i<n;i++)
            {
                Pair p=q.peek();
                q.remove();
                int c=p.val-l;
                if(i==0)
                {
                    left=c;
                }
                if(i==n-1)
                {
                    right=c;
                }
                if(p.root.left!=null)
                {
                    q.add(new Pair(c*2+1,root.left));
                }
                if(p.root.right!=null)
                {
                    q.add(new Pair(c*2+2,root.right));
                }
            }
            res=Math.max(res,right-left+1);
        }
        return res;
    }
    
}