package fall2014submissions;

import java.util.*;

/**
 * Created by Yubo on 11/11/14.
 */
public class temp {
    public static void main(String[] args){

        int[] num = {1,2,3,7,45};

        ArrayList<Integer> myal = new ArrayList<Integer>();

        LinkedList<Integer> myll = new LinkedList<Integer>();


        Collections.addAll(myll, 3,6,7,41546,48,12,145,98,4,1,231);
        Collections.addAll(myal, 645,45,31,13,34,534,2);

//
//        myal.add(2,99);
//
//        int i = myal.indexOf(99);
//
//        int n = Collections.binarySearch(myal, 99);

        int k= Collections.frequency(myll,3);
        System.out.println(k);

        Collections.sort(myll,Collections.reverseOrder());


        

        System.out.println(Arrays.toString(myll.toArray()));

        Iterator i = myll.iterator();

        while(i.hasNext()){
            System.out.println(i.next());

        }

        for (int j : myll){
            System.out.println(j);
        }





    }
}
