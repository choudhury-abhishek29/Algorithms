package prep.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import prep.tree.TreeNode;

public class LevelOrderTraversal {
	
	public List<List<Integer>> levelOrder(TreeNode root){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		
        if(root==null) return res;
		
        Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			int size = q.size();
			List<Integer> temp = new ArrayList<Integer>();
			for(int i=0;i<size;i++) {
				TreeNode curr = q.poll();
				temp.add(curr.val);
				
				if(curr.left!=null) q.offer(curr.left);
				if(curr.right!=null) q.offer(curr.right);
			}
			res.add(temp);
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
