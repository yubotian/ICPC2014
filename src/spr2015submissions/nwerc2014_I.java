package spr2015submissions;

/**
 * Created by Yubo on 1/26/15.
 *
 * brute force 14!
 *
 * starting point s can be fxed = 13!
 *
 * for all other 13 points, pick each one as the middle point x,
 *
 * x and s devide all points to two side: A and B
 *
 * for side A, compute all possible paths, store in a list a,   6!
 *
 * same for B, list b
 *
 * hasha, hashb,
 *
 * for each item i in hasha, compute L- i, check whether its in hashb.
 *
 *
 *
 *
 * TAKEAWAY: if n^2 or n! doesn't work, try divide and conquer
 */
public class nwerc2014_I {
    public static void main(String[] args){
        int k = 10;
        while(--k>0){
            System.out.println(k);
        }
    }
}
