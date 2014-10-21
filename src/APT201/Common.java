package APT201;

import java.util.HashMap;

public class Common {
     public int count (String a, String b) {
    	 char[] A = a.toCharArray();
    	 char[] B = b.toCharArray();
    	 HashMap<Character,Integer> M = new HashMap<Character,Integer>();
    	 HashMap<Character,Integer> N = new HashMap<Character,Integer>();
    	 int i = 0;
    	 for (int k = 0 ; k < a.length(); k++){
    		 if(!M.containsKey(A[k])){
    			 M.put(A[k], 0);
    		 }
    		 M.put(A[k], M.get(A[k])+1);
    	 }
    	 for (int k = 0 ; k < b.length(); k++){
    		 if(!N.containsKey(B[k])){
    			 N.put(B[k], i);
    		 }
    		 N.put(B[k], N.get(B[k])+1);
    	 }
    	 
    	 
    	 for ( char m: M.keySet() ){
    		 for ( char n: N.keySet()){
    			 if (m==n){
    				 if (M.get(m) >= N.get(n)) i += N.get(n);
    				 else i += M.get(m);
    			 }
    		 }
    		 
    	 }
    	 
    	 
    	 
    	 return i;
    	 
     }
  }