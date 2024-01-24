package prep.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, nums);
        return ans;
    }
    
    public void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for (int num: nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                backtrack(curr, ans, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations perm = new Permutations();
		List<List<Integer>> res = perm.permute(new int[] {1,2,3});
		res.stream()
			.forEach(x->System.out.println(x));

	}

}
