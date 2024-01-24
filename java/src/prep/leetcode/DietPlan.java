package prep.leetcode;

public class DietPlan {
	public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int points=0;
        int sum=0;
        
        for(int i=0;i<=calories.length-k;i++)
        {
        	for(int j=i;j<k+i;j++)
        		sum+=calories[j];
        		
          if(sum<lower) points--;
          if(sum>upper) points++; 
          sum=0;
        }
        return points;
    }

	public static void main(String[] args) {
		DietPlan dp = new DietPlan();
		System.out.println(dp.dietPlanPerformance(new int[] {6,13,8,7,10,1,12,11}, 6, 5, 37));

	}

}
