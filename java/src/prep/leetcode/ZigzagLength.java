package prep.leetcode;

import prep.tree.TreeNode;

public class ZigzagLength {
	public int longestZigZag(TreeNode root) {
        if(root == null)
            return 0;

        int left = helper(root.left, 1, true);
        int right = helper(root.right, 1, false);

        return Math.max(left, right);
        
    }

    private int helper(TreeNode node, int currCount, boolean isLeft){
        if(node == null)
            return currCount-1;

        int leftPath=0;
        int rightPath=0;
        
        if(isLeft){
            leftPath = helper(node.left, 1, true);
            rightPath = helper(node.right, currCount+1, false);
        }
        else{
            leftPath = helper(node.left, currCount+1, true);
            rightPath = helper(node.right, 1, false);
        }

        return Math.max(leftPath, rightPath);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		
		root.right = node1;
		
		node1.left = node2;
		node1.right = node3;
		
		node3.left = node4;
		node3.right = node5;
		
		node4.right = node6;
		
		node6.right = node7;
		
		/*					root
		 * 						\
		 * 						node1
		 * 						/	\
		 * 					node2	node3
		 * 							/	\
		 * 						node4	node5
		 * 							\
		 * 							node6
		 * 								\
		 * 								node7
		 * */
		
		System.out.println(new ZigzagLength().longestZigZag(root));
		

	}

}
