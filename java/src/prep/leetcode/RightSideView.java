package prep.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView 
{
	class TreeNode 
	{
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode() {}
		 TreeNode(int val) 
		 { 
			 this.val = val; 
		 }
		 
		 TreeNode(int val, TreeNode left, TreeNode right) 
		 {
			 this.val = val;
			 this.left = left;
			 this.right = right;
		 }
	 }
	
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> right_view = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        if(root==null) return right_view;
        q.offer(root);
        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode curr = q.poll();
                if(i==0) right_view.add(curr.val);
                if(curr.right!=null)q.offer(curr.right);
                if(curr.left!=null)q.offer(curr.left);
            }
            
        }
        return right_view;
    }

}
