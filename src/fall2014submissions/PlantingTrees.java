package fall2014submissions;

import java.util.*;

/**
 * Created by Yubo on 11/10/14.
 */
public class PlantingTrees {
    public static void main(String[] args){
        new PlantingTrees().go();
    }

    Scanner in = new Scanner(System.in);

    public void go(){
        int c = in.nextInt();
        int q = c;
        Integer[] t = new Integer[c];
        while(c>0){
            c--;
            t[c] = in.nextInt();


        }

        //Arrays.sort(t,Collections.reverseOrder());

        Arrays.sort(t);
        List<Integer> temp = Arrays.asList(t);
        Collections.reverse(temp);
        temp.toArray(t);

        int n   = t.length;



        int re = t[q-1] + q;
        //System.out.println(re);


        for (int i = 0 ; i < q-1 ; i++){

            if (t[i] -1  <= t[i+1]  ){
                int ret = t[i+1] + i +2;
                if (re < ret){re = ret; System.out.println(re);}
            }

        }
        System.out.println(re+1);
    }
}
