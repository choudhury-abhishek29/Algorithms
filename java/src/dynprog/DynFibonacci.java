package dynprog;


public class DynFibonacci 
{
	
	
	public static int fib_memo(int n, int[] m)
	{
		int result;
		if(m[n] != 0)
			result = m[n];
		else if(n==1 || n==2)
			result = 1;
		else
			result = fib_memo(n-1,m)+fib_memo(n-2,m);
		
		m[n]=result;
		return result;
	}
	
	public static int fib_bottomUp(int n)
	{
		if(n==1 || n==2)
			return 1;
		int[] bottom_up = new int[n+1];
		bottom_up[1]=1;
		bottom_up[2]=1;
		for(int x=3;x<=n;x++)
			bottom_up[x]=bottom_up[x-1]+bottom_up[x-2];
		
		return bottom_up[n];
	}
	
	public static void main(String args[])
	{
		int n=10000;
//		int memo[] = new int[n+1];
//		System.out.println(fib_memo(n,memo));
		System.out.println(fib_bottomUp(n));
//		1,1,2,3,5,8,13,21,34,55
	}

}
