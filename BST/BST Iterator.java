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
class BSTIterator {
    Stack<TreeNode> s;
    TreeNode cur;

    public BSTIterator(TreeNode root) {
        s=new Stack<>();
        cur=root;
    }
    
    public int next() {
        boolean f=false;
        int res=-1;
        while(f==false)
        {
            if(cur!=null)
            {
                s.push(cur);
                cur=cur.left;
            }
            else
            {
                if(s.isEmpty())
                {
                    f=true;
                }
                else
                {
                    cur=s.peek();
                    s.pop();
                    res=cur.val;
                    cur=cur.right;
                    f=true;
                }
            }
        }
        return res;
    }
    
    public boolean hasNext() {
        if(s.isEmpty()==true && cur==null)
        {
            return false;
        }
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */