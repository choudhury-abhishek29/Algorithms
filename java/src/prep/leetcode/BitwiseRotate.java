package prep.leetcode;

public class BitwiseRotate {
	static final int INT_BITS = 32; 
	  
	/*Function to left rotate n by d bits*/
	static int leftRotate(int n, int d) { 
		return (n << d) | (n >> (INT_BITS - d));
		
	} 
	  
	/*Function to right rotate n by d bits*/
	static int rightRotate(int n, int d) { 
		return (n >> d) | (n << (INT_BITS - d));
	} 
	  
	// Driver code 
	public static void main(String arg[])  
	{ 
//	    int n = 5; 
//	    int d = 1; 
//	    
//	    System.out.println("Binary string : "+Integer.toString(n, 2));
//	    
//	    int left = Integer.rotateLeft(n, d);
//	    System.out.println("Left : "+Integer.toBinaryString(left));
//	    
//	    int right = Integer.rotateRight(n, d);
//	    System.out.println("Right : "+Integer.toBinaryString(right));
	    
		String alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String test = "testing";
		for(char c : test.toCharArray())
			System.out.println(alphabets.contains(String.valueOf(c)));
	    
	    		
	    
	} 

}
