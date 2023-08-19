/****************************************************************

 Following is the class structure of the Node class:

 class Node {
     public int data;
     public Node left;
     public Node right;

     Node()
     {
         this.data = 0;
         this.left = null;
         this.right = null;
     }

     Node(int data)
     {
         this.data = data;
         this.left = null;
         this.right = null;
     }

     Node(int data, Node left, Node right)
     {
         this.data = data;
         this.left = left;
         this.right = right;
     }
 }

 *****************************************************************/
public class Solution {
    public static boolean check(Node root)
    {
        if(root==null)
        {
            return true;
        }
        if(root.left==null && root.right==null)
        {
            return true;
        }
        int a=root.left!=null?root.left.data:0;
        int b=root.right!=null?root.right.data:0;
        return (check(root.left) && check(root.right) && a+b==root.data);
    }
    public static boolean isParentSum(Node root) {
        return check(root);
    }
}