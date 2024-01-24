package prep.leetcode;

public class BestTimeToBuyAndSellStocks {
	public static int maxProfit(int[] prices) {
//        int maxProfit=0;
//        int buy=0, sell=1;
//        while(sell<prices.length)
//        {	
//        	if(prices[sell]-prices[buy]<0)
//        		buy++;
//        	else {
//        		if(prices[sell]-prices[buy]>=0)
//        		{
//        			if(maxProfit<=prices[sell]-prices[buy])
//        			{
//        				maxProfit=prices[sell]-prices[buy];
//        			}
//        			sell++;
//        		}
//        	} 
        	
//        return maxProfit;
		
		Integer minVal = Integer.MAX_VALUE;
		int maxProfit=0;
		for(int i=1; i<prices.length; i++)
		{
			if(prices[i]<minVal)
				minVal=prices[i];
			else if(maxProfit<prices[i]-minVal)
				maxProfit=prices[i]-minVal;
		}
		return maxProfit;
		
		
		
    }
	
	public static void main(String[] args)
	{
		System.out.println(maxProfit(new int[] {7,6,5,4,3,2,1}));
	}

}
