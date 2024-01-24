package prep.interview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Event{
	private String event_type,event_id,session_id,device_ts,first_name,last_name,restaurant_id,platform;
	
	public Event(String event_type, String restaurant_id)
	{
		this.event_type = event_type;
		this.restaurant_id = restaurant_id;
	}

	public String getEvent_type() {
		return event_type;
	}

	public void setEvent_type(String event_type) {
		this.event_type = event_type;
	}

	public String getEvent_id() {
		return event_id;
	}

	public void setEvent_id(String event_id) {
		this.event_id = event_id;
	}

	public String getSession_id() {
		return session_id;
	}

	public void setSession_id(String session_id) {
		this.session_id = session_id;
	}

	public String getDevice_ts() {
		return device_ts;
	}

	public void setDevice_ts(String device_ts) {
		this.device_ts = device_ts;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(String restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
}

public class Grubhub {
	
	public static ArrayList<String> getTopMenuClick(ArrayList<Event> events, int n)
	{
		ArrayList<String> rest_ids=new ArrayList<String>();
		Map<Object, Long> count = new HashMap<Object, Long>();
		
//		for(Event e : events)
//		{
//			if(e.getEvent_type()=="MenuClick")
//			{
//				if(count.containsKey(e.getRestaurant_id()))
//				{
//					int curr_count = count.get(e.getRestaurant_id());
//					count.put(e.getRestaurant_id(), curr_count+1);
//					
//				}
//				else
//					count.put(e.getRestaurant_id(), 1);
//			}
//		}
		
		count = events.stream()
				.collect(Collectors.groupingBy(t->t.getRestaurant_id(), Collectors.counting()));
		
		LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
		 
//		count.entrySet()
//			    .stream()
//			    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
//			    .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));
//		
//		sortedMap.entrySet()
//		.stream()
//		.limit(n)
//		.forEach(x->rest_ids.add(x.getKey()));
       
		
		return rest_ids;
	}
	
	
	public static void main(String args[])
	{
		ArrayList<Event> events = new ArrayList<Event>();
		events.add(new Event("MenuClick","R1"));
		events.add(new Event("MenuClick","R2"));
		events.add(new Event("MenuClick","R3"));
		events.add(new Event("MenuClick","R4"));
		events.add(new Event("PageView","R1"));
		events.add(new Event("PageView","R2"));
		events.add(new Event("OrderEvent","R3"));
		events.add(new Event("OrderEvent","R4"));
		events.add(new Event("MenuClick","R1"));
		events.add(new Event("MenuClick","R1"));
		events.add(new Event("MenuClick","R1"));
		events.add(new Event("MenuClick","R2"));
		events.add(new Event("MenuClick","R2"));
		events.add(new Event("MenuClick","R3"));
		System.out.println(getTopMenuClick(events, 2));
//		event_type,event_id,session_id,device_ts,first_name,last_name,restaurant_id,platform
//		PageView,4762243214994907954,4167894919920561836,2021-02-10 15:05:22 -0000,Jane,Seymour,1,
//		OrderEvent,,2659416225956115,2021-02-10 01:26:58 -0000,Ethan,Hawke,2,
//		PageView,3013780591994836451,5455133802569676324,2021-02-10 01:13:58 -0000,Jean,Seberg,4,mobile
//		OrderEvent,64091085690819118,3787216387976908177,2021-02-10 15:21:40 -0000,Jane,Seymour,1,mobile
//		PageView,2866390262346551154,7954650497337060870,2021-02-10 02:49:58 -0000,Romain,Gary,2,
//		MenuClick,799085319065518426,2870702886386786884,2021-02-10 15:06:08 -0000,Jane,Seymour,1,web
//		PageView,7842635407215373593,,2021-02-10 05:37:58 -0000,Lesley,Blanch,2,web
//		PageView,9131356231485805562,4583788593816512108,2021-02-10 15:08:13 -0000,Jane,Seymour,2,mobile
//		MenuClick,636424576781057141,3046767928724234086,2021-02-10 15:05:36 -0000,Jane,Seymour,1,web

	}

}
