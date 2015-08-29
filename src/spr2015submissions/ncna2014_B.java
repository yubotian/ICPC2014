package spr2015submissions;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * preorder traversals
 *
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
        int c = 0;

        while(in.hasNextInt()){
            ArrayList<Integer> line = new ArrayList<Integer>();
            int cur = in.nextInt();
            while(cur>=0){
                line.add(cur);
                cur = in.nextInt();
            }
            lst = new Integer[line.size()];
            lst = line.toArray(lst);
            c++;

            if(preorder_traversal(0,line.size()-1)){
                System.out.printf("Case %d: yes\n",c);
            }
            else{
                System.out.printf("Case %d: no\n",c);
            }
        }
        in.close();

    }

    boolean preorder_traversal(int start, int stop){
        if(stop-start<=1){ //basecase
            return true;
        }
        int rt = lst[start];
        int right = stop+1;
        for(int i=start+1;i<=stop;i++){
            if(lst[i]>rt){
                right = i; //rt of the right subtree
                break;
            }
        }
        for(int k=right+1; k<=stop; k++){
            if(lst[k]<=rt) return false;
        }
        return preorder_traversal(start+1,right-1) && preorder_traversal(right,stop); //check both subtree recursively
    }
}
