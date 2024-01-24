package prep.leetcode;

import java.util.HashMap;
import java.util.Map;

import prep.leetcode.LRUCache.Node;

public class LRUCache 
{
	class Node
	{
		int key;
		int value;
		Node prev;
		Node next;
	}
	
	final Node head = new Node();
	final Node tail = new Node();
	Map<Integer, Node> node_map;
	int cache_capacity;
	
	public LRUCache(int capacity) 
	{
        node_map = new HashMap<Integer, Node>(capacity);
        this.cache_capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) 
    {
    	int result = -1;
    	
    	Node node = node_map.get(key);
    	if(node!=null)
    	{
    		result = node.value;
        	remove(node);
        	add(node);
    	}
    	
    	return result;
    }
    
    public void put(int key, int value) 
    {
        Node node = node_map.get(key);
        if(node!=null)
        {
        	remove(node);
        	node.value = value;
        	add(node);
        }
        else
        {
        	if(node_map.size() == cache_capacity)
        	{
        		node_map.remove(tail.prev.key);
        		remove(tail.prev);
        	}
        	Node new_node = new Node();
        	new_node.key = key;
        	new_node.value = value;
        	node_map.put(key, new_node);
        	add(new_node);
        }
    }
    
    public void add(Node node)
    {
    	Node head_next = head.next;
    	head.next = node;
    	node.prev = head;
    	node.next = head_next;
    	head_next.prev = node;
    	
    }
    
    public void remove(Node node)
    {
    	Node next_node = node.next;
    	Node prev_node = node.prev;
    	
    	next_node.prev = prev_node;
    	prev_node.next = next_node;
    }

}

//Input
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//Output
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//Explanation
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // cache is {1=1}
//lRUCache.put(2, 2); // cache is {1=1, 2=2}
//lRUCache.get(1);    // return 1
//lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//lRUCache.get(2);    // returns -1 (not found)
//lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//lRUCache.get(1);    // return -1 (not found)
//lRUCache.get(3);    // return 3
//lRUCache.get(4);    // return 4
