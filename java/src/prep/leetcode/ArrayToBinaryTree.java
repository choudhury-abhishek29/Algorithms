package prep.leetcode;

import prep.tree.TreeNode;

public class ArrayToBinaryTree {
	public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;

        TreeNode root = buildTree(nums, 0, nums.length-1);
        return root;
    }

    public TreeNode buildTree(int[] nums, int left, int right)
    {
        if(left>right) return null;
        int mid = left+(right-left)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left=buildTree(nums, left, mid-1);
        node.right=buildTree(nums, mid+1, right);
        return node;
    }
}
