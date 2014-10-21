package APT201;

import java.util.*;

public class SortedFreqs{
	public int[] freqs(String[] data) {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(String d: data){
			if(!map.containsKey(d))
				map.put(d,0);
			map.put(d,map.get(d)+1);
		}
		List<String> list = new ArrayList<String>(map.keySet());
		Collections.sort(list);
		int[] number = new int[list.size()];
		for (int i=0;i<list.size();i++){
			number[i] = map.get(list.get(i));
		
		}
		return number;
	}
}

      
