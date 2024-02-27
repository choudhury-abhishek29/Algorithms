package prep.leetcode;

import prep.tree.TreeNode;

public class MaxPathSum {
	public int maxPathSum(TreeNode root) {
		int[] maxSum = new int[] {Integer.MIN_VALUE};
		int sum = Integer.MIN_VALUE;
		dfs(root, maxSum, sum);
		System.out.println("sum:"+sum+" | maxSum:"+maxSum[0]);
		return maxSum[0];
    }
	
	public int dfs(TreeNode node, int[] maxSum, int sum) {
		if(node == null)
			return 0;
		
		int left = Math.max(0, dfs(node.left, maxSum, sum));
		int right = Math.max(0,  dfs(node.right, maxSum, sum));
		
		maxSum[0] = Math.max(maxSum[0], node.val+left+right);
		sum = Math.max(sum, node.val+left+right);
		
		return node.val + Math.max(left, right);
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(-10);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(20);
		TreeNode node4 = new TreeNode(15);
		TreeNode node5 = new TreeNode(7);
		
		node1.left = node2;
		node1.right = node3;
		
		node3.left = node4;
		node3.right = node5;
		
		MaxPathSum mps = new MaxPathSum();
		System.out.println(mps.maxPathSum(node1));

	}

}
