import java.util.* ;
import java.io.*; 
/************************************************************

	Following is the Binary Tree node structure:

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}

************************************************************/
class Pair
{
	int num;
	BinaryTreeNode<Integer> root;
	Pair(int num,BinaryTreeNode<Integer> root)
	{
		this.num=num;
		this.root=root;
	}
}
public class Solution {
    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
		List<List<Integer>> res=new ArrayList<>();
		if(root==null)
		{
			return res;
		}
  		List<Integer> pre=new ArrayList<>();
		List<Integer> in=new ArrayList<>();
		List<Integer> post=new ArrayList<>();
		Stack<Pair> s=new Stack<>();
		s.push(new Pair(1, root));
		while(s.isEmpty()==false)
		{
			Pair t=s.peek();
			s.pop();
			int n=t.num;
			
			if(n==1)
			{
				pre.add(t.root.data);
				t.num++;
				s.push(t);
				if(t.root.left!=null)
				{
					s.push(new Pair(1,t.root.left));
				}
			}
			else if(n==2)
			{
				in.add(t.root.data);
				t.num++;
				s.push(t);
				if(t.root.right!=null)
				{
					s.push(new Pair(1,t.root.right));
				}
			}
			else
			{
				post.add(t.root.data);
			}
		}
		res.add(in);
		res.add(pre);
		res.add(post);
		return res;
    }
}
