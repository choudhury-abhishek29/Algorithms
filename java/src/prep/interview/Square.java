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

class Solution {
  public List<String> findConnected(String connected)
  {
    //--A----B---C
    List<String> pairList = new ArrayList<String>();
    StringBuilder pair = new StringBuilder();
    int left=0;
    int right=1;

    for(int i=0;i<connected.length();i++)
    {
      if(connected.charAt(i)!='-')
        {
          pair.append(connected.charAt(i));
          left=i;
          if(pair.length()==2)
          {
            pairList.add(pair.toString());
            pair=new StringBuilder();
            pair.append(connected.charAt(left));
          }
        }
        
      
        
    }
      return pairList;
  }

  public static void main(String[] args) {
    String ip = "A----B---C";
    Solution s = new Solution();
    List<String> pairs = s.findConnected(ip);
    System.out.println(pairs);
  }
}

// ------------------- Intro -------------------

// Problem format:

// * Multi-step problem
// * Nobody is expected to finish all steps
// * Steps build on top of one another
// * No set timeline for how fast a given step is completed
// * But, roughly expect them to take more time the farther we go
// * By default, I give a preview of the next step so you can plan ahead and/or combine multiple steps into one if you want
// * But if you prefer to focus on one at a time that is fine too

// We look at a combination of factors including progress on the steps, code quality, and problem-solving approach.

// Feel free to:
// * use the supported language you're most comfortable with.
// * look up any standard libraries, etc. on the internet.
// * ask me for help and bounce ideas off me (I'm here to help!)
// * run the code at any point and as often as you like; it doesn't have to be perfect the first time

// -------------------

// Overall goal: Write a function that accepts a string. This string is a diagram of letters connected to one another. The function will make sense of that string by finding the connected letters in it.

// Suggested breakdown into steps:

// Step 1: horizontal connections

// input: a string that consists of letters connected to each other by hyphens
// the string will be a single line, so no newlines

// output: all pairs of letters that are connected by hyphens (printing is OK, or you can return it if you prefer)

// example input:
// A----B---C

// output for example input:
// AB
// BC

// * order and exact formatting of the output don't matter
// * note that AC is NOT in the output, because A and C are not directly connected to each other

// ------------------- END OF STEP 1 -------------------

// PREVIEW of the next step:
// NOT required to handle this in step 1.
// However, all else being equal, you might consider how you would write step 1 so that it can easily be extended to do step 2.
// Step 2 is going to be vertical connections connected by pipes.

// "A---B----C\n|        |\n|        E\nD--F      "
// if you print this input, it shows up as:
// A---B----C
// |        |
// |        E
// D--F

// output:
// AB
// BC
// CE
// AD
// DF

// Details on that later, let's do step 1 first.
