package APT201;

public class DNAcgcount {
	public double ratio(String dna) {
		if (dna.length() == 0)
			return 0;
		char[] dna1 = dna.toCharArray();
		double count = 0;
		for (char s : dna1) {
			if (s == 'c' || s == 'g')
				count++;
		}
		return count / dna.length();
	}
}
