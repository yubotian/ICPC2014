package APT201;

import java.util.*;

public class FriendScore {
	public int highestScore(String[] friends) {
		int len = friends.length;
		List<Set<Integer>> F = new ArrayList<Set<Integer>>();  
		//f is a list of sets. each set is a person, each set contains ints, indicating who is friend with this person
		for (int i = 0; i < len; i++){
			HashSet<Integer> set = new HashSet<Integer>();
			char[] ch = friends[i].toCharArray();

			for (int j = 0; j < len; j++){
				if (ch[j] == 'Y'){
					set.add(j);
				}
			}
			F.add(set);
		}

		List<Set<Integer>> FF = new ArrayList<Set<Integer>>();
		for (int i=0; i<len; i++){
			HashSet<Integer> set = new HashSet<Integer>();

			FF.add(set);
		}
		for (int i=0; i<len; i++){
			for (int j: F.get(i)){
				for(int k: F.get(i)){
					if ((j!=k) && (!F.get(k).contains(j)))
						FF.get(k).add(j);
				}
			}
		}
		List<Integer> result = new ArrayList<Integer>();
		for (int x=0; x<len; x++){
			result.add(F.get(x).size()+FF.get(x).size());
		}

		int max = 0;
		for (int y: result){
			if (y>max)
				max = y;

		}

		return max;

	}
}


