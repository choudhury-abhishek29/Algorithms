package prep.leetcode;

public class BinaryGap {
	public int binaryGap(int N) {
        String binary = Integer.toBinaryString(N);
        char[] bin = binary.toCharArray();
        int left=0;
        int right=0;
        int maxLength=Integer.MIN_VALUE;
        while(right<bin.length)
        {
        	if(Character.getNumericValue(bin[right])==1)
        	{
        		maxLength = Math.max(maxLength, right-left);
        		left=right;
        	}
        	right++;
        }
        System.out.println(binary);
        return maxLength;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryGap bg = new BinaryGap();
		System.out.println(bg.binaryGap(529));
	}

}
