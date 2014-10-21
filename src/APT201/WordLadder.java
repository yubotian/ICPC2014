package APT201;

public class WordLadder {
	public String ladderExists(String[] words, String from, String to) {
		int n = words.length;
		if (n == 0)
			return "none";
		for (int i = 0; i < n; i++) {
			String word = words[i];

			if (isLadder(from, word)) {
				if (isLadder(word, to))
					return "ladder";

				String[] next = new String[n - 1];

				for (int j = 0; j < i; j++)
					next[j] = words[j];
				for (int j = i; j < n - 1; j++)
					next[j] = words[j + 1];

				if (ladderExists(next, word, to) == "ladder")
					return "ladder";
			}
		}
		return "none";
	}

	public boolean isLadder(String a, String b) {
		int diff = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				diff++;
		}
		return diff == 1;
	}
}
