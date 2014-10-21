package APT201;

import java.util.*;

public class Anonymous {
	public int howMany(String[] headlines, String[] messages) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for(String s: headlines){
			char[] C = s.toLowerCase().toCharArray();
			for(char c: C){	
				if(c!=' '){
					if(!map.containsKey(c))
						map.put(c, 0);
					map.put(c, map.get(c) + 1);
				}
			}
		}
		int result = 0;
		for(String x: messages){
			char[] X = x.toLowerCase().toCharArray();
			HashMap<Character, Integer> M = new HashMap<Character, Integer>();
			for(char a: X){
				if(a!=' '){
					if(!M.containsKey(a))
						M.put(a, 0);
					M.put(a, M.get(a)+1);
				}
			}
			boolean OK = true;
			for(char n: M.keySet()){
				if(map.containsKey(n)){
					if(map.get(n) < M.get(n))
						OK = false;
				}
				else
					OK = false;
			}
			if(OK)
				result++;
		}
		return result;
	}
	
}
