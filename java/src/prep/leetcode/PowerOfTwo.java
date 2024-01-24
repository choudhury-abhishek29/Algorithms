package prep.leetcode;

public class PowerOfTwo {
	public boolean isPowerOfTwo(int n) {
        int res=1;
        while(res<n)
        {
            res*=2;
        }
         
        return res==n;
    }

	public static void main(String[] args) {
		PowerOfTwo pt = new PowerOfTwo();
		System.out.println(pt.isPowerOfTwo(2147483646));
	}

}
