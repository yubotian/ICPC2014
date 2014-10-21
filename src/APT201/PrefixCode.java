package APT201;

public class PrefixCode {
	public String isOne(String[] words) {
		for(int i=0;i<words.length;i++){	
			for(int j=0;j<words.length;j++){
				if((i != j) && (words[j].startsWith(words[i]))){
					return "No, "+i;
				}
			}
		}
		return "Yes";
	}
	
	public static void main(String[] arg){
		PrefixCode PC = new PrefixCode();
		String[] words = {"10001", "011", "100", "001", "10" };
		String isOne = PC.isOne(words);
		System.out.println(isOne);
	}

}
          /* fill in body of this function
           * 
           * 
           * 
           * 
           */
 