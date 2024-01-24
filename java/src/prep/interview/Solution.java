package prep.interview;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import prep.interview.compass.Solution;

import static java.util.Arrays.asList;

// boolean hasNext()
//     return true if there is another element in the whole structure

// int next()
//     return the value of the next element in the structure

// void remove()
//     remove (from the underlying collection) the last element returned by the iterator.
//     That is, remove the element that the previous next() returned
//     This method can be called only once per call to next(), 
//     otherwise an exception will be thrown.

//     The behavior of an iterator is unspecified if the underlying
//     collection is modified while the iteration
//     is in progress in any way other than by calling this method.

// Given:  [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[]]
// Print:  1 2 3 4 5 6 7 8 9 10

//   private static void test1(){
//     Solution it = new Solution(getInput());
//     while (it.hasNext())
//       System.out.println(it.next());
//     // 1 2 3 4 5 6 7 8 9 10
//   }

// Given:  [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[]]
//   private static void testRemoveEven(){
//     ArrayList<ArrayList<Integer>> input = getInput();
//     Solution it = new Solution(input);
//     while (it.hasNext()){
//       if (it.next() % 2 == 0)
//         it.remove();
//     }
//     it = new Iterator(input);
//     while (it.hasNext())
//       System.out.println(it.next());
//     // 1 3 5 7 9
//   }

//   public static ArrayList<ArrayList<Integer>> getInput() {
//     ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
//     list.add(new ArrayList<Integer>());
//     list.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
//     list.add(new ArrayList<Integer>(Arrays.asList(4,5)));
//     list.add(new ArrayList<Integer>());
//     list.add(new ArrayList<Integer>());
//     list.add(new ArrayList<Integer>(Arrays.asList(6)));
//     list.add(new ArrayList<Integer>(Arrays.asList(7,8)));
//     list.add(new ArrayList<Integer>());
//     list.add(new ArrayList<Integer>(Arrays.asList(9)));
//     list.add(new ArrayList<Integer>(Arrays.asList(10)));
//     list.add(new ArrayList<Integer>());
//     return list;
//   }


// Given:  [[],[1,2,3],[4,5],[],[],[6],[7,8],[],[9],[10],[]]

public class Solution{
    public ArrayList<ArrayList<Integer>> input;
    private int size;
    private int pointer;
    
//    public Solution(ArrayList<Integer> internal)
//    {
//        this.internal=internal;
//        this.size=internal.size();;        
//        this.pointer=0;
//    }
    
    public Solution(ArrayList<ArrayList<Integer>> input)
    {
        this.input=input;
        this.size=input.size();;        
        this.pointer=0;
    }
    
    public boolean hasNext()
    {
    	return pointer<size;
    	
    } 
    
    public void next()
    {
    	ArrayList<Integer> il = input.get(pointer);
    	if(il.size()>0)
    	{
    		Iterator<Integer> i = il.iterator();
        	while(i.hasNext())
        		System.out.println(i.next());
    	}
    	remove();
    }
    
    public void remove()
    {
        pointer++;
    }
    
    public static ArrayList<ArrayList<Integer>> getInput() {
    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    list.add(new ArrayList<Integer>());
    list.add(new ArrayList<Integer>(Arrays.asList(1,2,3)));
    list.add(new ArrayList<Integer>(Arrays.asList(4,5)));
    list.add(new ArrayList<Integer>());
    list.add(new ArrayList<Integer>());
    list.add(new ArrayList<Integer>(Arrays.asList(6)));
    list.add(new ArrayList<Integer>(Arrays.asList(7,8)));
    list.add(new ArrayList<Integer>());
    list.add(new ArrayList<Integer>(Arrays.asList(9)));
    list.add(new ArrayList<Integer>(Arrays.asList(10)));
    list.add(new ArrayList<Integer>());
    	
    return list;
  }
  
  public static void main(String args[])
    {
        Solution s = new Solution(getInput()); 
        while(s.hasNext())
        	s.next();
    }
}