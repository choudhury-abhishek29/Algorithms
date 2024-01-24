package prep.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class LargestHistogramRectangle {
	public int largestRectangleArea(int[] heights) {
		int maxArea=0;
		Stack<Integer> stk = new Stack<Integer>();
		HashMap<Integer, Integer> hm  = new HashMap<>(); 
		for(int i=0;i<heights.length;i++) {
			int start = i;
			
			while(!stk.isEmpty() && hm.get(stk.peek())> heights[i]) {
				int prev_index = stk.pop();
				maxArea = Math.max(maxArea, (i-prev_index)*heights[i]);
				start = prev_index;
			}
			stk.push(start);
			hm.put(stk.peek(),heights[i]);
		}
		
		int index=0;
		for(int h : stk) {
			maxArea = Math.max(maxArea, hm.get(h)*(stk.size()-index));
			index++;
		}
			
        return maxArea;
    }

	public static void main(String[] args) {
		LargestHistogramRectangle lhr = new LargestHistogramRectangle();
		System.out.println(lhr.largestRectangleArea(new int[] {2,1,5,6,2,3}));

	}

}
