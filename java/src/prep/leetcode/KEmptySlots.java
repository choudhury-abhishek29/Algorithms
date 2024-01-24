package prep.leetcode;

public class KEmptySlots {
	
	public int kEmptySlots(int[] bulbs, int k) 
	{
        int n=bulbs.length;
        int position[]=new int[n+1];
        
        for(int i=0;i<n;i++) 
        	position[bulbs[i]]=i+1;
        
        int result=Integer.MAX_VALUE;
        int start=1,end=k+2;
        
        for(int i=1; end<=n; i++)
        {
            if(position[i]>position[start] && position[i]>position[end]) 
            	continue;
            
            if(i==end) 
            	result=Math.min(result,Math.max(position[start],position[end]));
            
            start=i;
            end=i+k+1;
        }
        return result==Integer.MAX_VALUE?-1:result;  
    }

	public static void main(String[] args) 
	{
		KEmptySlots kes = new KEmptySlots();
		System.out.println(kes.kEmptySlots(new int[] {1,3,2}, 1));
	

	}

}
