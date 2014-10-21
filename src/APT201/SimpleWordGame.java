package APT201;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SimpleWordGame {
      public int points(String[] player, String[] dictionary) {
    	  
    	  Set<String> mySet = new HashSet<String>(Arrays.asList(player)); 
    	  mySet.retainAll(Arrays.asList(dictionary));
    	  int points = 0;
    	  for (String i :mySet){
    		  points += Math.pow(i.length(), 2); 
    	  }
    	  
    	  return points;
      }
  }   	  
          /* you write code here
           * 
           * 
           * Arrays.asList(dictionary)
           *
           * mySet.retainAll(Arrays.asList(dictionary));
           */
