package APT201;

public class SoccerLeagues {
	public int[] points(String[] matches) { 

		int l =matches.length ; 
		int[] results = new int[l];

		for(int i=0;i<l;i++){
			char[] M = matches[i].toCharArray(); 
			for(int j=0;j<l;j++){ 
				if(M[j]=='W'){
					results[i] += 3; }
				if(M[j]=='D'){
					results[i] += 1; results[j] += 1; } 
				if(M[j]=='L'){
					results[j] += 3; } 
			} 
		} 
		return results;
	} 
}

