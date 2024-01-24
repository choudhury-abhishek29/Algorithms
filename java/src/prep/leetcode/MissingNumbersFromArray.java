package prep.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MissingNumbersFromArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer, Boolean>present = new HashMap<Integer, Boolean>();
        for(int n : nums)
            present.put(n, true);
        
        List<Integer> res = new ArrayList<Integer>();
        for(int i=1;i<=nums.length;i++)
        {
            if(!present.containsKey(i))
                res.add(i);
        }
        
        return res;
    }

	public static void main(String[] args) {
		MissingNumbersFromArray mn = new MissingNumbersFromArray();
		System.out.println(mn.findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1}));

	}

}
