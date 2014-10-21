package APT201;

import java.util.*;

public class MedalTable {
	public String[] generate(String[] results) {
		HashMap<String,Integer[]> map = new HashMap<String,Integer[]>();
		for(String s: results){
			String[] x = s.split(" ");
			for(int i=0;i<3;i++){
				if(!map.containsKey(x[i])){
					Integer[] a = {0,0,0};
					map.put(x[i], a);
				}
				map.get(x[i])[i]++;
			}
		}
		ArrayList<CC> list = new ArrayList<CC>();
	    for(String x: map.keySet()){
	    	Integer[] I = map.get(x);
	    	list.add(new CC(x,I[0],I[1],I[2]));
	    }
		Collections.sort(list);
		String[] answer = new String[list.size()];
		for(int i=0;i<list.size();i++)
			answer[i] = list.get(i).toString();
		return answer;
	}

	public class CC implements Comparable<CC>{
		String Country;
		Integer Gold;
		Integer Silver;
		Integer Bronze;
		
		public CC(String C, int G, int S, int B){
			Country = C;
			Gold = G;
			Silver = S;
			Bronze = B;
		}

	    public String toString(){
	    	return Country + " " + Gold + " " + Silver + " " + Bronze;
	    }
		
		public int compareTo(CC arg0) {

			int i1 = (arg0.Gold).compareTo(this.Gold);
			if(i1 != 0)
				return i1;
			int i2 = (arg0.Silver).compareTo(this.Silver);
			if(i2 != 0)
				return i2;
			int i3 = (arg0.Bronze).compareTo(this.Bronze);
			if(i3 != 0)
				return i3;
			int i0 = (this.Country).compareTo(arg0.Country);
			return i0;
		}

	}

}
