package prep.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import prep.tree.ReviseTree;
import prep.tree.TreeNode;

public class DeepestNodeSum 
{
	public static int deepestLeavesSum(TreeNode root) 
	{
		int sum=0;
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		que.offer(root);
		
		while(!que.isEmpty())
		{
			sum=0;
			int size=que.size();
			for(int i=0;i<size;i++)
			{
				TreeNode curr = que.poll();
				sum+=curr.val;
				if(curr.left!=null)
					que.offer(curr.left);
				if(curr.right!=null)
					que.offer(curr.right);	
			}
		}
		
		return sum;
        
    }
	
	public static void main(String[] args)
	{
		ReviseTree tree = new ReviseTree();
		tree.insertNode(new TreeNode(7));
		tree.insertNode(new TreeNode(4));
		tree.insertNode(new TreeNode(9));
		tree.insertNode(new TreeNode(2));
		tree.insertNode(new TreeNode(5));
		tree.insertNode(new TreeNode(8));
		tree.insertNode(new TreeNode(10));
		tree.insertNode(new TreeNode(1));
		tree.insertNode(new TreeNode(11));
		
		tree.printInorder(tree.root);
		
		System.out.println(deepestLeavesSum(tree.root));
		
	}

}
