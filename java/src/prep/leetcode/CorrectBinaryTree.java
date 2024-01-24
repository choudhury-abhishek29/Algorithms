package prep.leetcode;

import java.util.HashSet;
import java.util.Set;

import prep.tree.TreeNode;

public class CorrectBinaryTree {
	private Set<TreeNode> visited = new HashSet<>();
    public TreeNode correctBinaryTree(TreeNode root) {
        if (root == null || (root.right != null && visited.contains(root.right))) {
            return null;
        }

        visited.add(root);

        root.right = correctBinaryTree(root.right);
        root.left = correctBinaryTree(root.left);

        return root;
    }
}
