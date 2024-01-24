package prep.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SquareConnections {
  public List<String> findConnected(String[][] connected)
  {
    
    List<String> pairList = new ArrayList<String>();
    
    
//    Step 1 : unidirection connections : //--A----B---C
//    StringBuilder pair = new StringBuilder();
//    int left=0;
//    int right=1;
//    
//    while(right<connected.length())
//    {
//    	if(connected.charAt(right)!='-')
//    	{
//    		pair.append(connected.charAt(right));
//    		
//    		 if(pair.length()==2)
//	          {
//	            pairList.add(pair.toString());
//	            left=right;	 
//	            pair=new StringBuilder();
//	            if(connected.charAt(left)!='-')
//	            	pair.append(connected.charAt(left));
//	          }
//    	}
//		right++;
//    	
//    }

//    for(int i=0;i<connected.length();i++)
//    {
//      if(connected.charAt(i)!='-')
//        {
//          pair.append(connected.charAt(i));
//          left=i;
//          if(pair.length()==2)
//          {
//            pairList.add(pair.toString());
//            pair=new StringBuilder();
//            pair.append(connected.charAt(left));
//          }
//        }
//    }
    
//    Step 2 : Multidirection connections
 // A---B----C
 // |        |
 // |        E
 // D--F
 // output:
 // AB
 // BC
 // CE
 // AD
 // DF
      return pairList;
  }

  public static void main(String[] args) 
  {
    String[][] ip =new String[][] {
    								{"00A----B---C"},
    								{"00-00000000-"},
    								{"00-00000000E"},
    								{"00D----F0000"}
								   };
    SquareConnections s = new SquareConnections();
    List<String> pairs = s.findConnected(ip);
    System.out.println(pairs);
  }
}