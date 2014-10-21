package APT201;

import java.util.HashMap;


public class Encryption {
	public String encrypt(String message){
		
		String letters = "abcdefghijklmnopqrstuvwxyz";
		char[] R = new char[message.length()];
		
		HashMap<Character, Character> map = new HashMap<Character, Character>();
		int i = 0;
		
		for (int k = 0 ; k < message.length(); k++){
			
			if(!map.containsKey(message.charAt(k))){
				map.put(message.charAt(k), letters.charAt(i));
				i++;
				}	
			
			R[k] = map.get(message.charAt(k));
			}
		
	
		return new String (R);
     }


}
