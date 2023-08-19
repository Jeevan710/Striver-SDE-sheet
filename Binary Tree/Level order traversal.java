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
    public List<List<Integer>> levelOrder(TreeNode root) {
       
        List<List<Integer>> res=new ArrayList<>();
         if(root==null)
        {
            return res;
        }
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int n=q.size();
            List<Integer> r=new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                TreeNode t=q.peek();
                r.add(t.val);
                q.remove();
                if(t.left!=null)
                {
                    q.add(t.left);
                }
                if(t.right!=null)
                {
                    q.add(t.right);
                }
            }
            res.add(r);
        }
        return res;
    }
}