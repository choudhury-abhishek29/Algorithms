package prep.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Design a simplified version of Twitter where users can post tweets, follow another user and is able to see the 
10 most recent tweets in the user's news feed. Your design should support the following methods:

postTweet(userId, tweetId): Compose a new tweet.
getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by the users who the user followed. Tweets must be ordered from most recent to least recent.
follow(followerId, followeeId): Follower follows a followee.

Example:

Twitter twitter = new Twitter();


// User 1 follows user 2.
twitter.follow(1, 2);

// User 2 posts a new tweet (id = 100).
twitter.postTweet(2, 100);

// User 1's news feed should return a list with tweet id -> [100].
twitter.getNewsFeed(1);

// User 1 follows user 3.
twitter.follow(1, 3);

// User 3 posts a new tweet (id = 200).
twitter.postTweet(3, 200);

// User 1's news feed should return a list with tweet ids -> [200,100].
// Tweet id 200 should precede tweet id 100 because it is posted later in time.
twitter.getNewsFeed(1);
*/



public class Twitter
{
    public HashMap<Integer, Set<Integer>> follow_map;
    public Map<Integer, List<Integer>> user_tweet_map;
    
    public Twitter()
    {
    	
    	follow_map = new HashMap<Integer, Set<Integer>>();
    	user_tweet_map = new HashMap<Integer, List<Integer>>();
    }
   
    public void postTweet(int user_id, int tweet_id)
    {
        List<Integer> tweet_list = user_tweet_map.get(user_id);
        if(tweet_list==null)
        	tweet_list = new ArrayList<Integer>();
        	
    	tweet_list.add(tweet_id);
        user_tweet_map.put(user_id, tweet_list);
    }
    
    public List<Integer> getNewsFeed(int user_id)
    {

    	List<Integer> news_feed = new ArrayList<Integer>();
    	
    	Set<Integer> follow_list = follow_map.get(user_id);
    	if(follow_list!=null && follow_list.size()>0)
    	{
    		for(int follwer : follow_list)
    		{
    			List<Integer> tweet_list = user_tweet_map.get(follwer);
    			if(tweet_list!=null && tweet_list.size()>0)
    				tweet_list.stream()
    				.forEach(x->news_feed.add(x));
    		}
    		
    	}
        return news_feed;
    }
    
    public void follow(int followee, int follower)
    {
        Set<Integer> follower_set = follow_map.get(followee);
        if(follower_set==null)
        	follower_set = new HashSet<Integer>();
        follower_set.add(follower);
        
        follow_map.put(followee, follower_set);
        
    }
    
    public static void main(String[] args)
    {
    	Twitter twitter = new Twitter();


    	// User 1 follows user 2.
    	twitter.follow(1, 2);

    	// User 2 posts a new tweet (id = 100).
    	twitter.postTweet(2, 100);

    	// User 1's news feed should return a list with tweet id -> [100].
    	System.out.println(twitter.getNewsFeed(1));

    	// User 1 follows user 3.
    	twitter.follow(1, 3);

    	// User 3 posts a new tweet (id = 200).
    	twitter.postTweet(3, 200);

    	// User 1's news feed should return a list with tweet ids -> [200,100].
    	// Tweet id 200 should precede tweet id 100 because it is posted later in time.
    	System.out.println(twitter.getNewsFeed(1));
        
    }
    
}
