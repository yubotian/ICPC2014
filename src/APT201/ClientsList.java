package APT201;

import java.util.ArrayList;
import java.util.Collections;
public class ClientsList {
	public String[] dataCleanup(String[] names) {
		// fill in code here
		ArrayList<Name> list = new ArrayList<Name>();
		
		for(String s : names){
			if (s.contains(",")){
				String[] temp = s.split(", ");
	            list.add(new Name(temp[1],temp[0]));  
			}
			else{
				String[] temp = s.split(" ");
				list.add(new Name(temp[0],temp[1]));
				
			}
			
			
		}
		//loop through names to create your Name objects
		//and add all of your Name objects to list
		
		//This will sort your Names in list by using Name's compareTo method 
		//that you wrote in class
		Collections.sort(list);
		String[] answer = new String[names.length];                           //why new String[ NUMBER?]
		for (int i = 0; i<names.length; i++)
			answer [i] = list.get(i).toString();
			
		//Put your now sorted Names in list into answer
		//you can convert your names to Strings using toString
		//e.x. list.get(0).toString()
		
		return answer;
	}

	public class Name implements Comparable<Name>{

		private String myFirstName;
		private String myLastName;
		
		public Name(String first, String last){
			myFirstName = first;
			myLastName = last;
		}
		
		public String toString(){
			return myFirstName + " " + myLastName;
		}
			
		@Override
		public int compareTo(Name o) {
			// TODO Auto-generated method stub
			// a.compareTo(b);
			// if (a == b) 0
			// if a > b -> +number
			// if b > a -> -number
			
			int t = (this.myLastName).compareTo(o.myLastName);   
			if(t == 0){ // last names the same
				return (this.myFirstName).compareTo(o.myFirstName);
			}
			
			return t;    
			
		}

	}


}
