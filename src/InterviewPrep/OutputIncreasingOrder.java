package InterviewPrep;

import java.util.*;

/**
 * Created by Yubo on 10/23/14.
 */
public class OutputIncreasingOrder {

    //eg eg: 4678912356012356    output: 6789;123;56;0123;56;
    public static void main(String[] args){
        new OutputIncreasingOrder().go();
    }
    Scanner in = new Scanner(System.in);
    public void go(){
        String n = in.next();
        char[] temp = n.toCharArray();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i< temp.length-1; i++){
            result.append(temp[i]);
            if (temp[i] != temp[i+1]-1){
                result.append(';');
            }
        }
        result.append(temp[temp.length-1]);
        result.append(';');

        System.out.print(result.toString());
    }
}
