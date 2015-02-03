import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Yubo on 2/3/15.
 */
public class ncna2014_B {
    int size;
    Integer[] lst;

    public static void main(String[] args){
        new ncna2014_B().go();

    }


    private void go(){
        Scanner in = new Scanner(System.in);
        int count = 0;

        while(in.hasNextInt()){
            ArrayList<Integer> values = new ArrayList<Integer>();
            int cur = in.nextInt();
            while(cur>=0){
                values.add(cur);
                cur = in.nextInt();
            }
            lst = new Integer[values.size()];
            lst = values.toArray(lst);
            count++;
            System.out.print("Case ");
            System.out.print(count);
            System.out.print(": ");
            if(search(0,values.size()-1)){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
        }
        in.close();

    }

    boolean search(int start, int stop){
        if(stop-start<2){
            return true;
        }
        int first = lst[start];
        int larger=stop+1; //If there's no right subtree, this would be the
        for(int i=start+1;i<=stop;i++){
            if(lst[i]>first){
                larger = i;
                break;
            } // to find the start of the right subtree
        }
        for(int k=larger+1; k<=stop; k++){
            if(lst[k]<=first) return false;
        }
        return search(start+1,larger-1) && search(larger,stop);
    }


}
