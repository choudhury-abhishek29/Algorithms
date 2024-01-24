package prep.leetcode;

public class SubTreeofAnotherTree {
	
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;
        if(isIdentical(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isIdentical(TreeNode root1, TreeNode root2)
    {
        if(root1==null || root2==null)
            return root1==null && root2==null;

        return root1.val==root2.val && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right); 
    }

}
