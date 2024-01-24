package revise;

import java.util.HashMap;

import revise.LRUCache.Node;


public class LRUCache {
class Node
	{
		Node prev;
		int key;
		int value;
		Node next;
	}
	
	final Node head = new Node();
	final Node tail = new Node();
	int capacity;
	HashMap<Integer, Node> lru_map;
	
	public LRUCache(int capacity)
	{
		this.capacity=capacity;
		lru_map = new HashMap<Integer, Node>(capacity);
		head.next=tail;
		tail.prev=head;
	}
	
	public int get(int key)
	{
		int result = -1;
		Node n = lru_map.get(key);
		if(n!=null)
		{
			result = n.value;
			remove(n);
			add(n);
		}
		return result;
	}
	
	public void put(int key, int value)
	{
		Node n = lru_map.get(key);
		if(n!=null)
		{
			remove(n);
			n.value=value;
			lru_map.put(key, n);
			add(n);
		}
		else
		{
			if(lru_map.size()==capacity)
			{
				lru_map.remove(tail.prev.key);
				remove(tail.prev);
			}
			Node new_node = new Node();
			new_node.key=key;
			new_node.value=value;
			lru_map.put(key, new_node);
			add(new_node);
		}
		
	}
	
	private void add(Node n)
	{
		Node temp = head.next;
		head.next = n;
		n.prev = head;
		n.next = temp;
		temp.prev = n;
		
	}
	
	private void remove(Node n)
	{
		Node next_node = n.next;
		Node prev_node = n.prev;
		
		next_node.prev = prev_node;
		prev_node.next = next_node;
	}

	
	
	public static void main(String[] a)
	{
		//["LRUCache","get","put",	"get","put",  "put",  "get","get"]
		//[[2],		  [2],   [2,6],  [1], [1,5],  [1,2],  [1],   [2]]
		LRUCache c = new LRUCache(2);
		System.out.println(c.get(2));
		c.put(2, 6);
		System.out.println(c.get(1));
		c.put(1, 5);
		c.put(1, 2);
		System.out.println(c.get(1));
		System.out.println(c.get(2));
		
	}
	

}
