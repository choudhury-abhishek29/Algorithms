package prep.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import prep.tree.TreeNode;

public class InvertBinaryTree {
	// public TreeNode invertTree(TreeNode root) {
    //     if(root==null) return root;
        
    //     TreeNode left = invertTree(root.left);
    //     TreeNode right = invertTree(root.right);
    //     root.left = right;
    //     root.right = left;
    //     return root;
    // }

    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if(curr.left!=null)q.add(curr.left);
            if(curr.right!=null)q.add(curr.right);
        }
        return root;
    }

}
