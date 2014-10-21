package APT201;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheBestName {
	public String[] sort(String[] names) {
		List<Name> list = new ArrayList<Name>();
		for(String s: names)
			list.add(new Name(s));
		Collections.sort(list);
		String[] answer = new String[names.length];
		for(int i=0;i<names.length;i++)
			answer[i] = list.get(i).toString();
		return answer;
	}
	
	public class Name implements Comparable<Name>{
		String name;
		Integer score;
		
		public Name(String N){
			name = N;
			String reference = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			int I = 0;
			for(char c: N.toCharArray())
				I += reference.indexOf(c);
			score = I;
		}
		
		public String toString(){
			return name;
		}
		
		public int compareTo(Name arg0) {
			if((this.name).equals("JOHN")){
				if((arg0.name).equals("JOHN"))
					return 0;
				else
					return -1;
			}
			if((arg0.name).equals("JOHN"))
				return 1;
			
			int I = (arg0.score).compareTo(this.score);
			if(I!=0)
				return I;
			return (this.name).compareTo(arg0.name);
		}
	}
}
