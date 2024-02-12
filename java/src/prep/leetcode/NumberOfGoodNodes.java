package prep.leetcode;

import prep.tree.TreeNode;

public class NumberOfGoodNodes {
	
	public int goodNodes(TreeNode root) {
		return dfs(root, Integer.MIN_VALUE);
		
    }
	
	public int dfs(TreeNode curr, int max) {
		if(curr == null)
			return 0;
		
		int res = (curr.val >= max)? 1 : 0;
		
		res += dfs(curr.left, Math.max(max, curr.val));
		res += dfs(curr.right, Math.max(max, curr.val));
		
		return res;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(3);
		TreeNode node2 = new TreeNode(1);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(1);
		TreeNode node6 = new TreeNode(5);
		
		node1.left = node2;
		node1.right = node3;
		
		node2.left = node4;
		
		node3.left = node5;
		node3.right = node6;
		
		NumberOfGoodNodes gn = new NumberOfGoodNodes();
		System.out.println(gn.goodNodes(node1));

	}

}
