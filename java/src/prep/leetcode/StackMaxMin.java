package prep.leetcode;

import java.util.Stack;

public class StackMaxMin {
	
	public Stack<Integer> stk = new Stack<Integer>();;
	Stack<Integer> maxStk = new Stack<Integer>();
	Stack<Integer> minStk = new Stack<Integer>();
	
//	public StackMaxMin()
//	{
//		stk=new Stack<Integer>();
//	}
	
	public void push(int x)
	{
		if(minStk.isEmpty() || x<minStk.peek())
			minStk.push(x);
		
		if(maxStk.isEmpty() || x>maxStk.peek())
			maxStk.push(x);
		
		stk.push(x);
		
	}
	
	public void pop()
	{
		if(stk.peek()==minStk.peek())
			minStk.pop();
		if(stk.peek()==maxStk.peek())
			maxStk.pop();
		
		System.out.println(stk.pop());
	}
	
	public int top()
	{
		return stk.peek();
	}
	
	public int getMin()
	{
		return minStk.peek();
	}
	
	public int getMax()
	{
		return maxStk.peek();
	}

	public static void main(String[] args) {
		StackMaxMin smn = new StackMaxMin();
		smn.push(-2);
		smn.push(0);
		smn.push(-3);
		System.out.println(smn.getMin());
		smn.pop();
		System.out.println(smn.top());
		System.out.println(smn.getMax());
		System.out.println(smn.getMin());
		

	}

}
