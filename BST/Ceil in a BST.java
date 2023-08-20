import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

public class Solution {

    public  static int findCeil(TreeNode<Integer> node, int x) {
       int p[]=new int[1];
       p[0]=Integer.MAX_VALUE;
       BST(node,x,p);
       if(p[0]==Integer.MAX_VALUE)
       {
           return -1;
       }
       return p[0];

    }
    public static void BST(TreeNode<Integer> root,int X,int[] p)
    {
        if(root==null)
        {
            return;
        }
        if(root.data==X)
        {
            p[0]=root.data;
            return;
        }
        if(root.data>X)
        {   
            p[0]=root.data;
            BST(root.left,X,p);
        }
        else
        {
            BST(root.right,X,p);
        }
    }
}
