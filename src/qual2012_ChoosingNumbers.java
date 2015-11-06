import java.util.*;
/**
 * Created by Yubo on 11/5/15.
 */
public class qual2012_ChoosingNumbers {
    public static void main(String[] args){ new qual2012_ChoosingNumbers().go();}
    Scanner in = new Scanner(System.in);

    void go(){
        ArrayList<Integer> result = new ArrayList<Integer>();

        while(in.hasNext()){
            int n = in.nextInt();
            int a[] = new int[n];
            for (int c = 0; c < n; c++){
                a[c] = in.nextInt();
            }

            Arrays.sort(a);

            for (int j = n-1; j >= 0; j--){
                // check for GCF
                if (boss(j, a)) {
                    System.out.println(a[j]);
                    result.add(a[j]);
                    break;
                }
            }
        }
    }

    boolean boss(int j, int[] a){
        for (int i = 0; i< a.length; i++){
            if (greatestCommonDenominator(a[i],a[j]) > 1 && i!=j){
                return false;
            }
        }
        return true;
    }

    public int greatestCommonDenominator( int a, int b ){
	    while( b != 0 ){
		    int t = a%b;
	    	a = b;
	    	b = t;
    	}
	    return a;
    }
/**
* Sieve of Eratosthenes, returns all primes<=n
* @param n the maximum prime you want
* @return int[] of primes
*/
//    public ArrayList<Integer> findPrimes( int n ){
//	    boolean[] a = new boolean[n+1];
//    	ArrayList<Integer> temp=new ArrayList<Integer>();
//	    for( int i = 2; i <= n; i++ ) a[i] = true;
//    	for( int i = 2; i < Math.ceil(Math.sqrt(n)); i++ )if( a[i] ){
//	    	temp.add(i);
//		    for( int j = 2*i; j <= n; j += i )a[j] = false;
//	    }
//	    return temp;
//    }


}
