package prep.leetcode;

import java.util.HashMap;
import java.util.Map.Entry;

public class XofaKind {

	public boolean hasGroupsSizeX(int[] deck) {
		HashMap<Integer, Integer> count = new HashMap<>();
		for(int n : deck)
			count.put(n, count.getOrDefault(n, 0)+1);
		
		int res=0;
		for(int n : count.values())
			res = gcd(res, n);
		
		return res>1;
		
    }
	
	public int gcd(int a, int b)
	{
		if(a%b==0)
			return b;
		
		return gcd(b,a%b);
	}
	
	
	public static void main(String[] args) 
	{
		XofaKind xk = new XofaKind();
		int[] deck = new int[] {1,2,3,4,4,3,2,1};
		System.out.println(xk.hasGroupsSizeX(deck));

	}

}
