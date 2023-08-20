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
    public static void BST(TreeNode<Integer> root,int X,int[] p)
    {
        if(root==null)
        {
            return;
        }
        if(root.data==X)
        {
            if(root.right!=null)
            {
                TreeNode<Integer> r=root.right;
                while(r.left!=null)
                {
                    r=r.left;
                }
                p[0]=r.data;
            }
        }
        if(root.data>X)
        {
            BST(root.left,X,p);
        }
        else
        {
            p[0]=root.data;
            BST(root.right,X,p);
        }
    }
    public static int floorInBST(TreeNode<Integer> root, int X) {
       int p[]=new int[1];
       BST(root,X,p);
       return p[0];
    }
}