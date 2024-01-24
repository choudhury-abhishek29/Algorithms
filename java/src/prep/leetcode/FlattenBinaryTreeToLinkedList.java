package prep.leetcode;

import java.util.Stack;

import prep.tree.ReviseTree;
import prep.tree.TreeNode;

public class FlattenBinaryTreeToLinkedList {
	public void flatten(TreeNode root) {
        if(root==null)return;
        Stack<TreeNode> stk = new Stack();
        stk.push(root);

        while(!stk.isEmpty())
        {
            TreeNode curr = stk.pop();
            if(curr.right!=null)stk.push(curr.right);
            if(curr.left!=null)stk.push(curr.left);
            if(!stk.isEmpty())
                curr.right=stk.peek();
            
            curr.left=null;
        }

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReviseTree tree = new ReviseTree();
//		1,2,5,3,4,null,6
		tree.insertNode(new TreeNode(1));
		tree.insertNode(new TreeNode(2));
		tree.insertNode(new TreeNode(5));
		tree.insertNode(new TreeNode(3));
		tree.insertNode(new TreeNode(4));
		tree.insertNode(new TreeNode(6));

	}

}
