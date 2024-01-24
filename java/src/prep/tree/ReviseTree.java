package prep.tree;

import java.util.ArrayList;
import java.util.List;

public class ReviseTree 
{	
	public TreeNode root;
	TreeNode flatRoot;
	
	
	public void insertNode(TreeNode n)
	{
		if(root==null)
			root=n;
		else
		{
			TreeNode curr = root;
			TreeNode parent;
			
			while(true)
			{
				parent=curr;
				if(n.val<curr.val)
				{
					curr=curr.left;
					if(curr==null)
					{
						parent.left=n;
						return;
					}
				}
				else
				{
					curr=curr.right;
					if(curr==null)
					{
						parent.right=n;
						return;
					}
				}
			}
		}
	}
	
	public void printPreorder(TreeNode root)
	{
		if(root!=null)
		{
			System.out.print(" "+root.val+" ");
			printPreorder(root.left);
			printPreorder(root.right);
		}
	}
	
	public List<Integer> printInorder(TreeNode root, List<Integer> list)
	{
		if(root!=null)
		{
			printInorder(root.left, list);
//			System.out.print(" "+root.data+" ");
			list.add(root.val);
			printInorder(root.right, list);
		}
		return list;
	}
	
	public void printInorder(TreeNode root)
	{
		if(root!=null)
		{
			printInorder(root.left);
			System.out.print(" "+root.val+" ");
			printInorder(root.right);
		}
	}
	
	public void printPostorder(TreeNode root)
	{
		if(root!=null)
		{
			printPostorder(root.left);
			printPostorder(root.right);
			System.out.print(" "+root.val+" ");
		}
	}
	
	public TreeNode findNode(int data)
	{
		TreeNode curr = root;
		
		if(curr.val == data)
			return curr;
		
		while(curr.val!=data)
		{
			if(data<curr.val)
				curr=curr.left;
			else
				curr=curr.right;
			
			if(curr == null)
				return null;
		}
		
		return curr;
	}
	
	public void createFlattenedTree(TreeNode n)
	{
		if(flatRoot==null)
			flatRoot=n;
		
		TreeNode curr = flatRoot;
		while(curr.right!=null)
			curr=curr.right;
		
		curr.right = null;	
	}
	
//	public Boolean removeNode(int data)
//	{
//		TreeNode curr = root;
//		TreeNode parent = root;
//		
//		Boolean isLeftChild = true;
//		
//		
//	}
//	
//	public TreeNode getReplacement(TreeNode replaceNode)
//	{
//		
//	}
	
	public static void main(String args[])
	{
		ReviseTree tree = new ReviseTree();
//		1,2,5,3,4,null,6
		tree.insertNode(new TreeNode(1));
		tree.insertNode(new TreeNode(2));
		tree.insertNode(new TreeNode(5));
		tree.insertNode(new TreeNode(3));
		tree.insertNode(new TreeNode(4));
		tree.insertNode(new TreeNode(6));
		
		
		List<Integer> inOrder = new ArrayList<Integer>();
		inOrder = tree.printInorder(tree.root, inOrder);
		System.out.println(inOrder);
		
		tree.createFlattenedTree(tree.root);
		tree.printInorder(tree.flatRoot, inOrder);
//		tree.removeNode(75);
//		tree.printInorder(tree.root);
//		System.out.println();
		
	}

}
