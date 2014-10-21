package APT201;

import java.util.Arrays;
public class SandwichBar{
	public int whichOrder(String[] available, String[] orders){
		
		int index = 0;
		
		for(String s: orders){
			String[] S = s.split(" ");
			boolean canMake = true;
			
			for(String x: S){
				if(!Arrays.asList(available).contains(x)){
					canMake = false;
				
			    }
			}
			if (canMake==true){
				return index;	}
				index++;
			
			
		
		    }
		return -1;
	}
}
		      
    	  

