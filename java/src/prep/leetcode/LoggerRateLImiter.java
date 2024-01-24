package prep.leetcode;

import java.util.HashMap;

public class LoggerRateLImiter {
	private HashMap<String, Integer> logger;
	private int EXPIRY=10;
	
	public LoggerRateLImiter() {
        logger = new HashMap<String, Integer>();
    }
	
	public boolean shouldPrintMessage(int timestamp, String message) 
	{
		if(logger.containsKey(message) && logger.get(message)>timestamp)
			return false;
		
		logger.put(message, timestamp+EXPIRY);
		return true;
		
    }
	
	public static void main(String[] args)
	{
		LoggerRateLImiter logger = new LoggerRateLImiter();
		System.out.println(logger.shouldPrintMessage(1, "foo"));  // return true, next allowed timestamp for "foo" is 1 + 10 = 11
		System.out.println(logger.shouldPrintMessage(2, "bar"));  // return true, next allowed timestamp for "bar" is 2 + 10 = 12
		System.out.println(logger.shouldPrintMessage(3, "foo"));  // 3 < 11, return false
		System.out.println(logger.shouldPrintMessage(8, "bar"));  // 8 < 12, return false
		System.out.println(logger.shouldPrintMessage(10, "foo")); // 10 < 11, return false
		System.out.println(logger.shouldPrintMessage(11, "foo")); // 11 >= 11, return true, next allowed timestamp for "foo" is 11 + 10 = 21
	}

}
