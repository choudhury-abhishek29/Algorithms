package prep.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import prep.tree.TreeNode;

public class GreaterSumTree {
	int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        traverse(root);
        return root;
    }

    public void traverse(TreeNode node){
        if(node == null)
            return;
        
        traverse(node.right);
        sum+=node.val;
        node.val = sum;
        traverse(node.left);
    }
    
    public void printLevelOrder(TreeNode node) {
	    Queue<TreeNode> q = new LinkedList<TreeNode>();
	    q.offer(node);
	    
	    while(!q.isEmpty()) {
	    	for(int i=0; i<q.size();i++) {
	    		TreeNode curr = q.poll();
	    		if(curr!=null) {
	    			q.offer(curr.left);
			    	q.offer(curr.right);
			    }
	    		System.out.print((curr==null)?null+" ":curr.val+" ");
	    	}
	    	
	    	
	    	
	    }
    }

	public static void main(String[] args) {
		TreeNode node0 = new TreeNode(0);
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		
		node4.left = node1;
		node4.right = node6;
		
		node1.left = node0;
		node1.right = node2;
		
		node2.right = node3;
		
		node6.left = node5;
		node6.right = node7;
		node7.right = node8;
		
		GreaterSumTree gst =  new GreaterSumTree();
		gst.printLevelOrder(gst.bstToGst(node4));

	}

}
