package prep.interview;

public class Paxos {
	// Trade:
	// id, type (BUY/SELL), totalGold, totalUSD
	// where:
	// totalGold, totalUSD > 0
	
	class Trade
	{
	  String type;// (BUY/SELL), 
	  int totalGold;
	  int totalUSD;
	  
	  public Trade(String type, int totalGold, int totalUsd)
	  {
		  this.type = type;
		  this.totalGold = totalGold;
		  this.totalUSD = totalUsd;
	  }
	  
	}

	// Net Position:
	// netGold, netUSD
	// where: 
	// -Infinity < netGold, netUSD < Infinity

	// Problem 1:
	// Input: List of `Trade`s
	// Output: Net Position for those trades

	// Example:
	// For the two trades with ids "A" and "B" here
	// * id = "A", type = BUY, totalGold = 1, totalUSD = 1750
	// * id = "B", type = SELL, totalGold = 0.25, totalUSD = 750    -1000
	// * id = "C", type = SELL, totalGold = 0.25, totalUSD = 800     .5 1550
	// * id = "D", type = BUY, totalGold = 0.25, totalUSD = 1000         500

	//-1200

	//
	// The Net Position is:
	//     netGold = .0.75, netUSD = -800

	

	float netGold=0;
	float netUsd=0;

	public void calculateNetPosition(List<Trade> trades)
	{
	  for(Trade t : trades)
	  {
	    switch(t.type)
	    {
	      case "BUY":
	        netGold+=t.totalGold;
	        netUsd-=t.totalUSD;
	      break;

	      case "SELL":
	        netGold-=t.totalGold;
	        netUsd=t.totalUSD+netUsd;
	      break;
	    }
	  }

	}

	// Trade:
	// id, type (BUY/SELL), totalGold, totalUSD, ourTag, theirTag
	// where: 
	// totalGold, totalUSD > 0
	// for all ourTag theirTag, ourTag != theirTag (these are non-intersecting sets)

	// Trades:
	// * A: ourTag = “x”, theirTag = “0”
	// * B: ourTag = “x”, theirTag = “1”
	// * C: ourTag = “y”, theirTag = “1”
	// * D: ourTag = “z”, theirTag = “2”
	// * E: ourTag = “y”, theirTag = “3”
	// * F: ourTag = “w”, theirTag = “3”

	// A,B,C are in the same group.
	// D is in a group by itself.

	// Problem 2:
	// Input: List of Trades, a tag
	// Output: The NetPosition for the group of Trades containing that tag.

	public settle(List<Trade> trades, String tag) // 0
	{
	      Queue<Trade> q = new LinkedList<Trade>();
	      q.offer(trades.get(0));

	      while(!q.isEmpty())
	      {
	        int size = q.size();

	        for(int i=0;i<size;i++)
	        {
	          Trade curr = q.poll();

	          if(curr.ourTag==tag || )
	        }
	      }

	  // Set<String> allTags = new HashSet<String>();  // x, 0, 1, y, 3, w
	  // List<Trades> allTrades = new ArrayList<Trades>(); //A, 
	  // for(Trade t : trades)
	  // {
	  //   if(t.ourTag==tag || t.theirTag==tag)
	  //   {
	  //     allTags.add(t.ourTag);
	  //     allTags.add(t.theirTag);
	  //     allTrades.add(t);
	  //   }

	  //   for(

	  //   )


	  // }

	}


}
