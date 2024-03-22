package prep.interview;


public class SmithRx_FrogJump {
	public int solution(int[] blocks) {
		if(blocks==null)
			return 0;
		
        int size = blocks.length;
        int[] maxRight = new int[size];
        int rightVal = size-1;
        
        for(int i=size-1; i>=0; i--) {
        	if (i + 1 < size && blocks[i] > blocks[i + 1])
        		rightVal = i;
        		maxRight[i] = rightVal;
        }
        
        int leftVal = 0;
        int dist = 0;
        for (int i = 0; i < size; i++)
        {
	        if (i - 1 >= 0 && blocks[i - 1] < blocks[i])
	        leftVal = i;
	        dist = Math.max(dist, maxRight[i] - leftVal + 1);
        }
        return dist;
		
		
    }
	

	public static void main(String[] args) {
		SmithRx_FrogJump fj = new SmithRx_FrogJump();
		System.out.println(fj.solution(new int[] {2,6,8,5}));

	}

}
