package revise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BacktrackSeatingArrangement {
	public List<List<String>> findArrangements(List<String> ppl)
	{
		List<List<String>> ans = new ArrayList<List<String>>();
		combinations(new ArrayList<String>(), ans, ppl);
		return ans;
	}
	
	public void combinations(List<String> curr, List<List<String>> ans, List<String> ppl)
	{
		if(curr.size() == ppl.size())
			ans.add(new ArrayList<String>(curr));
		
//		for(String p : ppl)
		for(int i=0;i<ppl.size();i++)
		{
			String p = ppl.get(i);
			if(!(curr.size()==1 && p=="G1"))	// condition to restrict G1 in the middle
			{
				if(!curr.contains(p))
				{
					curr.add(p);
					combinations(curr, ans, ppl);
					curr.remove(curr.size()-1);
				}
			}
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BacktrackSeatingArrangement bsa = new BacktrackSeatingArrangement();
		System.out.println(bsa.findArrangements((List<String>) Arrays.asList("B1","B2","G1")));

	}

}
