package APT201;

public class Tourney {

	public String winner(String[] bracket, String results) {
		
		if (bracket.length == 1)
			return bracket[0];

		String[] nextbracket = new String[(bracket.length) / 2];

	
		String ref = "LH";
		for (int i = 0; i<bracket.length; i++){
			if (bracket[i].equals("bye")){
				results = results.substring(0,i/2) + ref.charAt(i%2) + results.substring(i/2);
			}
		}		
		for (int i = 0; i < bracket.length; i = i + 2) {
			
			if (results.charAt(i/2) == 'H') {
				nextbracket[i / 2] = bracket[i];
			}
			if (results.charAt(i/2) == 'L') 
				nextbracket[i / 2] = bracket[i + 1];
		}
		String nextresults = results.substring((bracket.length)/2);
		return winner(nextbracket, nextresults);
		
	
	}

	public static void main(String[] args) {
		Tourney T = new Tourney();
		String[] Bracket = { "A", "B", "A", "C", "X", "bye", "bye", "D", "E",
				"F", "G", "H", "I", "J", "K", "L" };
		String results = "LHHLLHHLHLLLH";
		String TT = T.winner(Bracket, results);
		System.out.println(TT);
	}

}


	