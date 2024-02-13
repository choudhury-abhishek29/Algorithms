package prep.leetcode;

import java.util.ArrayList;
import java.util.List;

import prep.tree.TreeNode;

public class ValidBinaryTree {
	public boolean isValidBST(TreeNode root) {
		if(root==null)
			return true;
		
		return dfs(root, null, null);
	}
	
	public boolean dfs(TreeNode node, Integer min, Integer max) {
		if(node==null)
			return true;
		
		if((min!=null && node.val<=min) || (max!=null && max<=node.val))
			return false;
		
		return dfs(node.left, min, node.val) && dfs(node.right, node.val, max);
	}
	

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		
		node5.left = node1;
		node5.right = node4;
		
		node4.left = node3;
		node4.right = node6;
		
		ValidBinaryTree vbt = new ValidBinaryTree();
		System.out.println(vbt.isValidBST(node5));

	}

}
