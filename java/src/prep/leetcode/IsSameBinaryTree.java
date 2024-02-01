package prep.leetcode;

import prep.tree.TreeNode;

public class IsSameBinaryTree {
	 public boolean isSameTree(TreeNode p, TreeNode q) {
	        return dfs(p,q);
	    }

	    public boolean dfs(TreeNode p, TreeNode q){
	        if(p==null && q==null)
	            return true;
	        
	        if(p==null || q==null)
	            return false;

	        if(p.val != q.val)
	            return false;
	        
	        boolean left = dfs(p.left, q.left);
	        boolean right = dfs(p.right, q.right);

	        return (left && right);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
