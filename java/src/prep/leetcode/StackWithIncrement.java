package prep.leetcode;

import java.util.Collections;
import java.util.Stack;

public class StackWithIncrement {
	int maxSize;
	int[] stack;
	int top=-1;
	public StackWithIncrement(int maxSize) {
		this.stack = new int[maxSize];
		this.maxSize = maxSize;
    }
    
    public void push(int x) {
    	if(top<maxSize-1)
    	{
    		top++;
    		stack[top]=x;
    	}
    }
    
    public int pop() {
    	if(top>-1)
    	{
    		int x=stack[top];
    		stack[top]=0;
    		top--;
    		return x;
    	}
    	else
    		return top;
    }
    
    public void increment(int k, int val) {

    	for(int i=0;i<=Math.min(k-1, top);i++)
    			stack[i]+=val;
    		
    }
    
    public void printStack()
    {
    	for(int i=0;i<stack.length;i++)
    		System.out.print(" "+stack[i]+" ");
    	System.out.print("\n");
    }
    
    public static void main(String[] args)
    {
    	StackWithIncrement stk = new StackWithIncrement(3); // Stack is Empty []
    	stk.printStack();
    	stk.push(1);                          // stack becomes [1]
    	stk.printStack();
    	stk.push(2);                          // stack becomes [1, 2]
    	stk.printStack();
    	stk.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
    	stk.printStack();
    	stk.push(2);                          // stack becomes [1, 2]
    	stk.printStack();
    	stk.push(3);                          // stack becomes [1, 2, 3]
    	stk.printStack();
    	stk.push(4);                          // stack still [1, 2, 3], Do not add another elements as size is 4
    	stk.printStack();
    	stk.increment(5, 100);                // stack becomes [101, 102, 103]
    	stk.printStack();
    	stk.increment(2, 100);                // stack becomes [201, 202, 103]
    	stk.printStack();
    	stk.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
    	stk.printStack();
    	stk.pop();                            // return 202 --> Return top of the stack 202, stack becomes [201]
    	stk.printStack();
    	stk.pop();                            // return 201 --> Return top of the stack 201, stack becomes []
    	stk.printStack();
    	stk.pop();                            // return -1 --> Stack is empty return -1.
    	stk.printStack();
    }

}
