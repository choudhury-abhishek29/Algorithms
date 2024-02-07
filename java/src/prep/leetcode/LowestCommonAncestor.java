package prep.leetcode;

import prep.tree.TreeNode;

public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        
            return root;
    }

	public static void main(String[] args) {
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		
		node6.left = node2;
		node6.right = node8;
		
		node2.left = node1;
		node2.right = node4;
		
		node4.left = node3;
		node4.right = node5;
		
		node8.left = node7;
		node8.right = node9;
		
		LowestCommonAncestor lca = new LowestCommonAncestor();
		TreeNode res = lca.lowestCommonAncestor(node6, node3, node7);
		System.out.println(res.val);

	}

}
