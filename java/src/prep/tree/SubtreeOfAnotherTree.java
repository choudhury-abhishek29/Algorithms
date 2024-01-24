package prep.tree;

public class SubtreeOfAnotherTree {
	TreeNode root;
	
	public void addNode(TreeNode node)
	{
		if(root==null) 
			root=node;
		else
		{
			TreeNode curr=root;
			TreeNode parent;
			while(true)
			{
				parent=curr;
				if(node.val < curr.val)
				{
					curr = curr.left;
					if(curr==null)
					{
						parent.left = node;
						return;
					}
				}
				else
				{
					curr = curr.right;
					if(curr==null)
					{
						parent.right=node;
						return;
					}
				}
			}
		}		
	}
	
	public String printInorder(TreeNode node)
	{
		return getInorder(node, new StringBuffer());
	}
	
	public String getInorder(TreeNode node, StringBuffer sb)
	{
		if(node!=null)
		{
			getInorder(node.left, sb);
			sb.append(" "+node.val+" ");
			getInorder(node.right, sb);
		}
		
		return sb.toString();
	}
	
	public TreeNode containsNode(TreeNode node)
	{
		TreeNode curr = root;
		
		if(curr.val == node.val)
			return curr;
		
		while(node.val!=curr.val)
		{
			if(node.val<curr.val)
				curr = curr.left;
			else
				curr = curr.right;
			
			if(curr==null)
				return null;
		}
		return curr;
	}
	
	public boolean isSubtree(TreeNode root, TreeNode subRoot)
	{
		TreeNode subNode = containsNode(subRoot);
		
		if(subNode!=null)
		{
			String ino1 = printInorder(subNode);
			String ino2 = printInorder(subRoot);
			
			return ino1.equals(ino2);
		}
		
		return false;
	}

	public static void main(String[] args) {
		SubtreeOfAnotherTree stoat1 = new SubtreeOfAnotherTree();
		stoat1.addNode(new TreeNode(4));
		stoat1.addNode(new TreeNode(2));
		stoat1.addNode(new TreeNode(5));
		stoat1.addNode(new TreeNode(1));
		stoat1.addNode(new TreeNode(3));
		
		SubtreeOfAnotherTree stoat2 = new SubtreeOfAnotherTree();
		stoat2.addNode(new TreeNode(2));
		stoat2.addNode(new TreeNode(1));
		stoat2.addNode(new TreeNode(3));
		
		System.out.println(stoat1.isSubtree(stoat1.root, stoat2.root));
		
		

	}

}
