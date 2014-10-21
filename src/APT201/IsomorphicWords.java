package APT201;

import java.util.*;

public class IsomorphicWords {
	public int countPairs(String[] words) {
		int result = 0;
		for(int i=0;i<words.length;i++){
			for(int j=i+1;j<words.length;j++){
				if(isIsomorphic(words[i],words[j]))
					result++;
			}
		}
		return result;
	}
	
	public boolean isIsomorphic(String a, String b){
		if(a.length() != b.length())
			return false;
		char[] A = a.toCharArray();
		char[] B = b.toCharArray();
		HashMap<Character,Character> M = new HashMap<Character,Character>();
		HashMap<Character,Character> N = new HashMap<Character,Character>();
		for(int i=0;i<a.length();i++){
			if(!M.containsKey(A[i]))
				M.put(A[i], B[i]);
			if(M.get(A[i]) != B[i])
				return false;
		}
		for(int j=0;j<a.length();j++){
			if(!N.containsKey(B[j]))
				N.put(B[j], A[j]);
			if(N.get(B[j]) != A[j])
				return false;
		}
		return true;
	}
	
	public static void main(String[] arg){
		IsomorphicWords IW = new IsomorphicWords();
		String[] words =  {"aa", "ab", "bb", "cc", "cd" };
		int cP = IW.countPairs(words);
		System.out.println(cP);
	}
}
