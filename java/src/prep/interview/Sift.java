package prep.interview;

/*
 * Click `Run` to execute the snippet below!
 */

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

 /*
Problem: Given a string s, find the length of the longest substring without repeating characters.
* Find the value of first longest substring.

Example1: "abcabcbb"
abc, output: 3

Example2: "bbbbb"
b, output: 1

Example3: "pwwkew"
wke, output: 3

Example4: "abcdefagh"
bcdefagh, output: 8

Example5:  "bcdefagh"
bcdefagh,  output: 8

Example6: "abcdefbagh"
cdefbagh, output: 8

Example7: "abcdefabgh"
cdefabgh, output: 8
*/

class Sift {
  public int findLongestSubstring(String str)
  {
    if(str.length()==0 || str==null) return 0;

    int maxLength=0;
    int left=0;
    int right=0;
    HashSet<Character> cset = new HashSet<Character>();

    while(right<str.length())
    {
      // System.out.println("right : "+str.charAt(right));
      if(!cset.contains(str.charAt(right)))
      {
        System.out.println("adding right char to set : "+str.charAt(right));
        cset.add(str.charAt(right));
        right++;
        maxLength = Math.max(maxLength, (right-left));
        System.out.println("current value " + str.substring(left, right));
        System.out.println("set " + cset.toString());
      }
      else
      {
        System.out.println("removing left char: "+str.charAt(left));
        cset.remove(str.charAt(left));
        left++;
      }

    }
    return maxLength;
  }
  public static void main(String[] args) {
    Sift s = new Sift();
    // System.out.println(s.findLongestSubstring(""));
    // System.out.println(s.findLongestSubstring("abcabcbb"));
    // System.out.println(s.findLongestSubstring("bbbbb"));
    // System.out.println(s.findLongestSubstring("pwwkew"));
    // System.out.println(s.findLongestSubstring("abcdefagh"));
    // System.out.println(s.findLongestSubstring("bcdefagh"));
    // System.out.println(s.findLongestSubstring("abcdefbagh"));
    // System.out.println(s.findLongestSubstring("abcdefabgh"));
    System.out.println(s.findLongestSubstring("bcdaefbagh"));

    //bcdaefbagh
  }
}

// length str = m
// length sub_str = n
// O(m+(m-n))
// Your previous Plain Text content is preserved below:

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you'd like to use for your interview,
// simply choose it from the dots menu on the tab, or add a new language
// tab using the Languages button on the left.

// You can also change the default language your pads are created with
// in your account settings: https://app.coderpad.io/settings

// Enjoy your interview!