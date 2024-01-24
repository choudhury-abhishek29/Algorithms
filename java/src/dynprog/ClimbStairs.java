package dynprog;

public class ClimbStairs {
	public int climbStairs(int n) 
	{
		int one=1, two=1;
		
		for(int i=0;i<n-2;i++)
		{
			int temp=one;
			one+=two;
			two=temp;
		}
		return one;
    }

	public static void main(String[] args) 
	{
		ClimbStairs cs = new ClimbStairs();
		System.out.println(cs.climbStairs(3));

	}

}
