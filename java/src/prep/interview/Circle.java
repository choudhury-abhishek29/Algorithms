package prep.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//The database should support displaying data based on filters. Introduce an operation to support printing some fields of a record.
//
//SCAN <timestamp> <key> — should return a string representing the fields of the record associated with key. The returned string should be in the following format "<field1>(<value1>), <field2>(<value2>), ...", where fields are sorted lexicographically. If the specified record does not exist, returns an empty string.
//
//SCAN_BY_PREFIX <timestamp> <key> <prefix> — should return a string representing some fields of the record associated with key. Specifically, only fields that start with prefix should be included. The returned string should be in the same format as in the SCAN operation with fields sorted in lexicographical order.
//
//Examples
//The example below shows how these operations should work (the section is scrollable to the right):
//
//Queries	Explanations
//queries = [
//  ["SET", "0", "A", "BC", "4"],
//  ["SET", "10", "A", "BD", "5"],
//  ["SET", "20", "A", "C", "6"],
//  ["SCAN_BY_PREFIX", "30", "A", "B"],
//  ["SCAN", "40", "A"],
//  ["SCAN_BY_PREFIX", "50", "B", "B"]
//]
//
//returns ""; database state: {"A": {"BC": 4}}
//returns ""; database state: {"A": {"BC": 4, "BD": 5}}
//returns ""; database state: {"A": {"BC": 4, "BD": 5, "C": 6}}
//returns "BC(4), BD(5)"
//returns "BC(4), BD(5), C(6)"
//returns ""
//
//the output should be ["", "", "", "BC(4), BD(5)", "BC(4), BD(5), C(6)", ""].

public class Circle {
	String[] solution(String[][] queries) {
	    String[] sol = new String[queries.length];
	    HashMap<String, List<String>> timeMap = new HashMap<>();
	    HashMap<String, HashMap<String, Integer>> dataMap = new HashMap<>();
	    
	    for(int i=0;i<queries.length;i++){
	        
	        String opr = queries[i][0];
	        String time = queries[i][1];
	        String key = queries[i][2];
	        String field = queries[i][3];
	        
	        List<String> timeList = (timeMap.containsKey(key))?timeMap.get(key):new ArrayList<>();
	        timeList.add(time);
	        timeMap.put(key, timeList);
	        
	        HashMap<String, Integer> valuesMap = dataMap.get(key);
	            
	            
	        switch(opr){
	            case "SET":
	                Integer value = Integer.parseInt(queries[i][4]);
	                if(valuesMap==null)
	                    valuesMap = new HashMap<>();
	                valuesMap.put(field, value);
	                sol[i]="";
	                break;
	            case "COMPARE_AND_SET":
	                Integer exp_value = Integer.parseInt(queries[i][4]);
	                Integer new_value = Integer.parseInt(queries[i][5]);
	                if(valuesMap!=null && valuesMap.containsKey(field)){
	                    if(exp_value == valuesMap.get(field)){
	                        valuesMap.put(field, new_value);
	                        sol[i]="true";
	                    }
	                    else
	                        sol[i]="false";
	                }
	                else
	                    sol[i]="false";
	                break;
	            case "COMPARE_AND_DELETE":
	                Integer curr_value = Integer.parseInt(queries[i][4]);
	                if(valuesMap!=null && valuesMap.containsKey(field)){
	                    if(curr_value == valuesMap.get(field)){
	                        valuesMap.remove(field);
	                        sol[i]="true";
	                    }
	                    else
	                        sol[i]="false";
	                }
	                else
	                    sol[i]="false";
	                break;
	            case "GET":
	                sol[i] = (valuesMap!=null && valuesMap.containsKey(field)) ? String.valueOf(valuesMap.get(field)) : "";
	                break;
	            case "SCAN":
	                StringBuffer sb = new StringBuffer();
	                if(valuesMap!=null){
	                    for(Map.Entry<String, Integer> entry : valuesMap.entrySet()){
	                        sb.append(entry.getKey()+"("+entry.getValue()+")");
	                    }
	                    sol[i] = sb.toString();
	                }
	                
	                break;
	            case "SCAN_BY_PREFIX":
	                List<String>sb_pref = new ArrayList<String>();
	                String prefix = queries[i][3];
	                if(valuesMap!=null){
	                    for(Map.Entry<String, Integer> entry : valuesMap.entrySet()){
	                        if(entry.getKey().startsWith(prefix))
	                            sb_pref.add(entry.getKey()+"("+entry.getValue()+")");
	                    }
	                    sol[i] = sb_pref.toString();
	                }
	                break;
	                
	                
	        }
	        dataMap.put(key, valuesMap);
	    }
	    return sol;
	}
}
