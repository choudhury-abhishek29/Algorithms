package prep.leetcode;

class Node
{
	int data;
	Node left;
	Node right;
	
	public Node(int data)
	{
		this.data=data;
		this.left=null;
		this.right=null;
	}
}

public class BinarySearchTree 
{
	Node root;
	
	public Node findLCA(int m, int n, Node curNode) //Lowest Common Ancestor
	{
		if(m<curNode.data && n<curNode.data)
			return findLCA(m,n,curNode.left);
		
		if(m>curNode.data && n>curNode.data)
			return findLCA(m,n,curNode.right);
		
		return curNode;
	}
	
	public static void main(String args[])
	{
		BinarySearchTree tree = new BinarySearchTree();
		tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        
        int n1 = 10, n2 = 14;
        Node t = tree.findLCA(n1, n2, tree.root);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

//        n1 = 14;
//        n2 = 8;
//        t = tree.findLCA(n1, n2, tree.root);
//        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
//  
//        n1 = 10;
//        n2 = 22;
//        t = tree.findLCA(n1, n2, tree.root);
//        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
        
        n1 = 8;
        n2 = 10;
        t = tree.findLCA(n1, n2, tree.root);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
  
		
	}

}
