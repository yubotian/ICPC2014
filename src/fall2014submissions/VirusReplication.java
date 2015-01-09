package fall2014submissions;

import java.util.*;
/**
 * Created by Yubo on 11/12/14.
 */
public class VirusReplication {
    public static void main(String[] args){
        new VirusReplication().go();
    }

    Scanner in = new Scanner(System.in);

    public void go(){
        String before = in.nextLine().trim();
        String after = in.nextLine().trim();
        int end = 0;
        int start = 0;


        StringBuilder bf = new StringBuilder();
        StringBuilder af = new StringBuilder();

        for (int i = 0; i < before.length(); i++){
            if (end == 0) {
                if (before.charAt(i) != after.charAt(i)) {end = i;}
            }
            bf.append(before.charAt(i));

        }

        for (int i = 0; i <after.length(); i++){
            af.append(after.charAt(i));
        }

        af.reverse();
        bf.reverse();
        for (int j = 0; j< Math.min(before.length(), after.length()); j++){
            if (af.charAt(j)!= bf.charAt(j)){
                if (start == 0) {start = j;}
            }
        }

        int result = Math.max(before.length(),after.length()) - start - end;

        if (before.length() < after.length()) {
            System.out.println(result);
        } else {
            System.out.println(result - Math.abs(before.length()-after.length()));
        }


//
//        System.out.println(Math.max(before.length(),after.length()));
//
//        System.out.println(start);
//        System.out.println(end);
//
//        System.out.println(result);



    }


}
