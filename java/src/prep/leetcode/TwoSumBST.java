package prep.leetcode;

import java.util.ArrayList;
import java.util.List;

public class TwoSumBST 
{
	private static List<Integer> getTreeAsSortedList(Node root)
	{
		List<Integer> treeList = new ArrayList<Integer>();
		return inorderTraverse(root, treeList);
	}
	
	private static List<Integer> inorderTraverse(Node node, List<Integer> lst)
	{
		if(node.left!=null)
			inorderTraverse(node.left, lst);
		
		lst.add(node.data);
		
		if(node.right!=null)
			inorderTraverse(node.right, lst);
		
		return lst;
	}
	
	public static boolean findTarget(Node root, int k) 
	{
		List<Integer> tmp = getTreeAsSortedList(root);
		int[] sorted = tmp.stream().mapToInt(Integer::valueOf).toArray();
		
		int a=0;
		int b=sorted.length-1;
		
		while(a<b)
		{
			int sum = sorted[a]+sorted[b];
			
			if(sum>k)
				b-=1;
			else if(sum<k)
				a+=1;
			else
				return true;
		}
		
		return false;
    }
	
	public static void main (String args[])
	{
		Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
//        tree.root.left.right.left = new Node(null);
        root.right.right = new Node(7);
        
        System.out.println(TwoSumBST.findTarget(root, 14));
        
        
	}

}
