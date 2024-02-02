package prep.leetcode;

import prep.tree.TreeNode;

public class SubTreeofAnotherTree {
	
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if(root == null)
			return false;
		
		if(isIdentical(root, subRoot))
			return true;
		
		return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
		
        
    }
	
	public boolean isIdentical(TreeNode root, TreeNode subRoot) {
		if(root == null || subRoot == null)
			return (root == null && subRoot == null);
		
		return root.val == subRoot.val && isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
	}

    

}
