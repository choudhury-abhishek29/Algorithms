package prep.interview;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Amazon {
    public static List<Integer> getTrucksForItems(List<Integer> trucks, List<Integer> items) {
        List<Integer> load = new ArrayList<>();
        HashMap<Integer, PriorityQueue<Integer>> weight_map = new HashMap<Integer, PriorityQueue<Integer>>();
        int maxWeight = Collections.max(trucks);
        
        for(int i=0; i<trucks.size();i++) {
            if(weight_map.containsKey(trucks.get(i)))
            {
                PriorityQueue<Integer> pq = weight_map.get(trucks.get(i));
                pq.offer(i);
                weight_map.put(trucks.get(i), pq);
            }
            else {
                PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
                pq.offer(i);
                weight_map.put(trucks.get(i), pq);
            }
                
        }
        
        for(int item : items) {
            if(item<maxWeight) {
                int next_weight = item+1;
                while(next_weight<=maxWeight)
                {
                    if(weight_map.containsKey(next_weight)){
                        PriorityQueue<Integer> pq = weight_map.get(next_weight);
                        if(pq!=null && pq.size()>0){
                            load.add(pq.poll());
                            weight_map.put(next_weight, pq);
                            break;
                        }
                        else
                        	weight_map.remove(next_weight);
                    }
                    else
                        next_weight++;
                }
            }
            else
                load.add(-1);
        }
        return load;
    }
    
    public static void main(String[] args) {
    	System.out.println(Amazon.getTrucksForItems(Arrays.asList(2,4,2,5,1,5,23,5,2,54,6,6), 
    			Arrays.asList(1,1,2,4,2,5,3,3,10,33)));
    }

}
