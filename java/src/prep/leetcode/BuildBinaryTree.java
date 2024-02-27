package prep.leetcode;

import java.util.Arrays;
import java.util.List;

import prep.tree.TreeNode;

public class BuildBinaryTree {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length==0 || inorder.length==0)
			return null;
		
		TreeNode root = new TreeNode(preorder[0]);
		int x = Arrays.asList(inorder).indexOf(preorder[0]);
		
		int mid=0;
		for (int i = 0; i < inorder.length; i++) {
            if (preorder[0] == inorder[i]) 
            	mid = i;
        }
		
		System.out.println("mid:"+mid+" x:"+x);
		
		int[] pre_left = Arrays.copyOfRange(preorder, 1, mid+1);
		int[] in_left = Arrays.copyOfRange(inorder, 0, mid);
		
		int[] pre_right = Arrays.copyOfRange(preorder, mid+1, preorder.length); 
		int[] in_right = Arrays.copyOfRange(inorder, mid+1, inorder.length);
		
		root.left = buildTree(pre_left, in_left);
        root.right = buildTree(pre_right, in_right);
		
		return root;
    }

	public static void main(String[] args) {
//		BuildBinaryTree bbt = new BuildBinaryTree();
//		TreeNode res = bbt.buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
//		System.out.println(res);
		
		int[] pre = new int[] {9,3,15,20,7};
		List<int[]>x = Arrays.asList(pre);
		System.out.println(x);
	}

}
