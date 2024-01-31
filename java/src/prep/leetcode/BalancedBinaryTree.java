package prep.leetcode;

import prep.tree.TreeNode;

public class BalancedBinaryTree {
	public boolean isBalanced(TreeNode root) {
		if(root==null)
			return true;
		
		return Math.abs(dfs(root.left)-dfs(root.right))<2 && isBalanced(root.left) && isBalanced(root.right);
        
    }
	
	public int dfs(TreeNode node) {
		if(node == null)
			return 0;
		
		return 1+ Math.max(dfs(node.left), dfs(node.right));
	}
	
	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		
		node1.left = node2;
		node1.right = node3;
		
		node3.left = node4;
		node3.right = node5;
		
		BalancedBinaryTree bbt = new BalancedBinaryTree();
		System.out.println(bbt.isBalanced(node1));
	}

}
