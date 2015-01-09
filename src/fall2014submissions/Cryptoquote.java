package fall2014submissions;

import java.util.Scanner;

/**
 * Created by Yubo on 9/29/14.
 */
public class Cryptoquote {
    public static void main(String[] args){
        new Cryptoquote().go();
    }
    Scanner scanner = new Scanner(System.in);
    public void go(){
        int ttl = Integer.parseInt(scanner.nextLine());
        int count = 0;
        while (count<ttl){
            count++;
            System.out.printf("%d", count);
            char[] en = scanner.nextLine().toCharArray();
            String dic = scanner.nextLine();
            StringBuffer de = new StringBuffer();
            for (int i = 0; i< en.length; i++){
                if (en[i]== ' ') {de.append(" ");}
                else {de.append(dic.charAt((int)(en[i])-65));}
            }
            System.out.println(de.toString());
        }
    }
}
