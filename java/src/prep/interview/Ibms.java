package prep.interview;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Ibms {
	public List<Integer> getMinTime(int cache_size, int cache_time, int server_time, List<String> urls) {
        List<Integer> sol = new ArrayList<>();
        TreeMap<String, String> cache = new TreeMap<>();
        for(String url : urls){
            if(cache.containsKey(url)){
                sol.add(cache_time);
            }
            else{
                while(cache.size()>cache_size){
                    cache.pollFirstEntry();
                }
                cache.put(url, "IP");
                sol.add(server_time);
            }
        }
        
        return sol;
    }

	public static void main(String[] args) {
		Ibms ques = new Ibms();
		System.out.println(ques.getMinTime(1, 3, 7, List.of("www.gmail.com","www.hackerrank.com","www.youtube.com","www.youtube.com","www.coursera.com")));

	}

}
