package prep.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import prep.tree.TreeNode;

public class KthSmallestElementBST {
	public int kthSmallest(TreeNode root, int k) {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> sortedList = dfs(root, list);
		return sortedList.get(k-1);
	}
	
	public List<Integer> dfs(TreeNode node, List<Integer> list){
		if(node!=null) {
			dfs(node.left, list);
			list.add(node.val);
			dfs(node.right, list);
		}
		return list;
	}

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		
		node3.left = node1;
		node3.right = node4;
		
		node1.right = node2;
		
		KthSmallestElementBST ks = new KthSmallestElementBST();
		System.out.println(ks.kthSmallest(node3, 1));

	}

}
