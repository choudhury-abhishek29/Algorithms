package prep.leetcode;

import java.util.Stack;

public class DailyTemperatures {
	public int[] dailyTemperatures(int[] temperatures) {
		int[] res = new int[temperatures.length];
		Stack<Integer> stk = new Stack<>(); //store the index
		for(int i=0;i<temperatures.length;i++) {
			int curr_temp = temperatures[i];
			while(!stk.isEmpty() && curr_temp>temperatures[stk.peek()]) {
				int index = stk.pop();
				res[index] = i-index;
			}
			stk.push(i);
		}
		return res;
    }

	public static void main(String[] args) {
		for(int n : new DailyTemperatures().dailyTemperatures(new int[] {73,74,75,71,69,72,76,73}))
			System.out.println(n);

	}

}
