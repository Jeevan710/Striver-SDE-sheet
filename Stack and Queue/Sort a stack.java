import java.util.* ;
import java.io.*; 
public class Solution {

	public static void sorting(Stack<Integer> stack,int num)
	{
		if(stack.isEmpty() || stack.peek()<num)
		{
			stack.push(num);
			return;
		}
		int n=stack.peek();
		stack.pop();
		sorting(stack,num);
		stack.push(n);

	}
	public static void sortStack(Stack<Integer> stack) {
		if(stack.isEmpty())
		{
			return;
		}
		int num=stack.peek();
		stack.pop();
		sortStack(stack);
		sorting(stack,num);
	}

}