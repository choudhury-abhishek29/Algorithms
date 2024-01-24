package prep.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class RankTeamsByVotes {
	public String rankTeams(String[] votes) {
		int n = votes[0].length();
        int[][] rt = new int[26][];
        
        for(int i=0;i<rt.length;i++)
        	for(int j=0;j<rt[0].length;j++)
        		rt[i][j]=0;
        
        for(int i=0;i<votes.length;i++)
        {
        	for(int j=0;j<n;j++)
        	{
        		char c = votes[i].charAt(j);
        		rt[c-'A'][j]++;
        	}
        }
        
        Character[] tmp = new Character[n];
        for(int i=0;i<n;i++)
        	tmp[i] = votes[0].charAt(i);
        
        Arrays.sort(tmp, (a,b)->{
        	for(int i=0;i<n;i++)
        		if(rt[a-'A'][i] != rt[b-'A'][i])
        			return rt[b-'A'][i]-rt[a-'A'][i];
        		return a-b;
        });
        
        char[] res = new char[n];
        for(int i=0;i<n;i++)
        	res[i]=tmp[i];
        
        return new String(res);
    }
	
	public static void main(String[] args)
	{
		RankTeamsByVotes rt = new RankTeamsByVotes();
		String[] votes = new String[] {"ABC","ACB","ABC","ACB","ACB"};
		System.out.println(rt.rankTeams(votes));
	}

}
