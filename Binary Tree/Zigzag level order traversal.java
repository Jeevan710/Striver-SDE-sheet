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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
        {
            return res;
        }
        Deque<TreeNode> q=new ArrayDeque<>();
        q.add(root);
        boolean flag=true;
        while(!q.isEmpty())
        {
            int n=q.size();
            List<Integer> r=new ArrayList<>();
            if(flag)
            {
                while(n--!=0)
                {
                    TreeNode temp=q.peek();
                    q.removeFirst();
                    r.add(temp.val);
                    if(temp.left!=null)
                    {
                        q.add(temp.left);
                    }
                    if(temp.right!=null)
                    {
                        q.add(temp.right);
                    }
                }
                flag=false;
            }
            else
            {
                while(n--!=0)
                {
                    TreeNode temp=q.peekLast();
                    q.removeLast();
                    r.add(temp.val);
                    if(temp.right!=null)
                    {
                        q.addFirst(temp.right);
                    }
                    if(temp.left!=null)
                    {
                        q.addFirst(temp.left);
                    }
                    
                }
                flag=true;
            }
            res.add(r);
        }
        return res;
    }
}