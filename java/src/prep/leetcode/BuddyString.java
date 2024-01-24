package prep.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BuddyString 
{
	public boolean buddyStrings(String s, String goal) 
	{
        if(s.length()!=goal.length())
        	return false;
        
        if(s.equals(goal))
        {
        	HashSet<Character> equate = new HashSet<Character>();
        	for(char c : s.toCharArray())
        		equate.add(c);
        	
        	if(equate.size()<s.length())
        		return true;
        	else
        		return false;
        }
        
        List<Integer> diffList = new ArrayList<Integer>();
        for(int i=0;i<s.length();i++)
        {
        	if(s.charAt(i)!=goal.charAt(i))
        		diffList.add(i);
        }
        
        if(diffList.size()==2 && 
        		s.charAt(diffList.get(0))==goal.charAt(diffList.get(1)) &&
        		s.charAt(diffList.get(1))==goal.charAt(diffList.get(0)))
    		return true;
    		else
    			return false;
    }
	
	public static void main(String[] args)
	{
		BuddyString bs = new BuddyString();
		System.out.println(bs.buddyStrings("ab", "ca"));
	}

}
