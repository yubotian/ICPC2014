package APT201;

import java.util.Stack;

public class QBalance {
	public int bindex(String symbols) {
		String left = "({[";
		String right = ")}]";
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < symbols.length(); i++) {
			if (right.indexOf(symbols.charAt(i)) == -1
					&& left.indexOf(symbols.charAt(i)) == -1) {
				continue;
			}
			if (left.indexOf(symbols.charAt(i)) != -1) {
				stack.push(symbols.charAt(i));
			}
			if (right.indexOf(symbols.charAt(i)) != -1) {
				if (stack.isEmpty())
					return i;
				if (left.indexOf(stack.pop()) != right.indexOf(symbols.charAt(i)))
					return i;
			}
		}
		if (stack.isEmpty())
			return -1;
		return symbols.length();
	}

}
