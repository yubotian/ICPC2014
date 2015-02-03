import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Yubo on 1/9/15.
 */

//Judging Troubles

public class nwerc2014_J_slvd {
    Scanner in = new Scanner(System.in);

    public static void main(String args[]){
        new nwerc2014_J_slvd().go();
    }

    public void go(){
        int c = Integer.parseInt(in.nextLine());
        int t = c;
        HashMap<String,Integer> dic = new HashMap<String, Integer>();

        while(c>0){
            c--;
            String result = in.nextLine().toString();


            if (!dic.containsKey(result)){
                dic.put(result,1);
                //test

            } else {
                dic.put(result,dic.get(result)+1);
                //System.out.println(dic.get(result));
            }
        }

        int total = 0;

        while (t>0){
            t--;
            String copy = in.nextLine().toString();
            if (dic.containsKey(copy)){
                if (dic.get(copy)>0){
                    dic.put(copy, dic.get(copy)-1);
                    total++;
                }
            }
        }

        System.out.println(total);


    }
}
