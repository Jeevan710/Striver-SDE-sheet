import java.util.* ;
import java.io.*; 
/********************************************************************

    Following is the class structure of the Node class:

    class BinaryTreeNode {
	    int data;
	    BinaryTreeNode left;
	    BinaryTreeNode right;

    	BinaryTreeNode(int data) {
	    	this.data = data;
		    this.left = null;
		    this.right = null;
	    }
    };

********************************************************************/

public class Solution {
	public static void print(BinaryTreeNode root,ArrayList<String> res,String s)
	{
		if(root==null)
		{
			return;
		}
		s+=root.data+" ";
		if(root.left==null && root.right==null)
		{
			res.add(s);
		}

		print(root.left,res,s);
		print(root.right,res,s);
	}
	public static ArrayList<String> allRootToLeaf(BinaryTreeNode root) {
		ArrayList<String> res=new ArrayList<>();
		print(root,res,"");
		return res;
	}
}