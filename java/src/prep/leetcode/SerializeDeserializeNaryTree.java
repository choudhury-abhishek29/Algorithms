package prep.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeDeserializeNaryTree {
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	
	public String serialize(Node root) {
        StringBuffer sb = new StringBuffer();
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty())
        {
            int size = q.size();
            for(int i=0;i<size;i++)
            {
                Node curr = q.poll();
                if(curr==null)
                {
                	sb.append("X");
                	sb.append(",");
                	break;
                }
                
                if(curr.children!=null)
                	for(Node n : curr.children)
                    	q.add(n);
                q.add(null);
                
                sb.append(curr.val);
                sb.append(",");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
	
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
    	String[] data_arr = data.split(",");
    	if(data_arr[0].equals("X")) return null;
    	
    	Node root = new Node(Integer.parseInt(data_arr[0]));
    	Queue<Node> q = new LinkedList<Node>();
    	q.add(root);
    	int i=2;
    	while(i<data_arr.length)
    	{
    		Node first = q.poll();
    		List<Node> children = new LinkedList<Node>();
    		while(!data_arr[i].equals("X"))
    		{
    			Node child = new Node(Integer.parseInt(data_arr[i++]));
    			children.add(child);
    			q.add(child);
    		}
    		i++;
    		first.children = children;
    	}
    	
    	return root;
    }

	public static void main(String[] args) 
	{
		SerializeDeserializeNaryTree sdt = new SerializeDeserializeNaryTree();
		Node n1 = sdt.new Node(1);
		Node n2 = sdt.new Node(2);
		Node n3 = sdt.new Node(3);
		Node n4 = sdt.new Node(4);
		Node n5 = sdt.new Node(5);
		
		List<Node> n1Children = new ArrayList<Node>();
		n1Children.add(n2);
		n1Children.add(n3);
		n1.children=n1Children;
		
		List<Node> n3Children = new ArrayList<Node>();
		n3Children.add(n4);
		n3Children.add(n5);
		n3.children = n3Children;
		
//		String ser = sdt.serialize(n1);
//		System.out.println(ser);
		
		Node n = sdt.deserialize("XX");
		
		String ser1 = sdt.serialize(n);
		System.out.println(ser1);
	}

}
