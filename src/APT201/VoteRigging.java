package APT201;

public class VoteRigging {
	

	
	public int minimumVotes(int[] votes) {
		int max = indexMax(votes);
		if (max==0) return 0;
		
		votes[max] --;
		votes[0] ++;
		return minimumVotes(votes) + 1;
	}
		
	public int indexMax(int[] votes) {
		int max = Integer.MIN_VALUE;
		int maxIndex = -1;
		for (int i = 0; i < votes.length; i++) {
			if (votes[i] >= max){
			    max = votes[i];
				maxIndex = i;
			
			}
		}
		return maxIndex;
	}
}