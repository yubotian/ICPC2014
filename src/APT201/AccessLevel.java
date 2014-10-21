package APT201;

public class AccessLevel {
    public String canAccess(int[] rights, int minPermission) {
        String answer = "";
         
        //for (int i = 0; i < rights.length; i++)
        // if (rights[i] <= minPermission)
        
        for(int i: rights){
        	if(i >= minPermission){
        		answer = answer + "A";
           		//answer += "A";
           	}
           	else{
           		answer += "D";
           	}
        }
        
        return answer;
    }
}
