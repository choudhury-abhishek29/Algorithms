package prep.leetcode;

import java.util.Arrays;

public class MinTapsWaterGarden {
	public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n+1];
        final int INF = (int) 1e9;
        Arrays.fill(dp, INF);
        dp[0]=0;

        for(int i=0;i<=n;i++){
            int tap_start = Math.max(0, i-ranges[i]);
            int tap_end = Math.min(n, i+ranges[i]);

            for(int j=tap_start;j<=tap_end;j++)
                dp[tap_end] = Math.min(dp[tap_end],dp[j]+1);
        }

        if(dp[n]==INF)
            return -1;
        
        return dp[n];
    }

	public static void main(String[] args) {
		MinTapsWaterGarden mtwg = new MinTapsWaterGarden();
		System.out.println(mtwg.minTaps(5, new int[] {3,4,1,1,0,0}));

	}

}
