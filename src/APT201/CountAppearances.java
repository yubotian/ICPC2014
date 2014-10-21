package APT201;

public class CountAppearances {
	public int numberTimesAppear(int number, int digit){
		int c = 0;
		char[] N = Integer.toString(number).toCharArray();
		for(char x: N){
			if(x==Character.forDigit(digit, 10))
				c++;
		}
		return c;
	}
}