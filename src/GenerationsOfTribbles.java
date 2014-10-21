import java.util.Scanner;

/**
 * Created by Yubo on 9/18/14.
 */
public class GenerationsOfTribbles {
    public static void main(String[] args) {
        new GenerationsOfTribbles().go();
    }

    Scanner scanner = new Scanner(System.in);
    int count = scanner.nextInt();
    int c = 0;


    public void go() {
        long[] a = new long[68];
        a[0]=1;
        a[1]=1;
        a[2]=2;
        a[3]=4;

        for(int n =4; n <68; n++){ a[n] = a[n-1]+a[n-2]+a[n-3]+a[n-4];}

        while (c < count) {
            c++;
            int num = scanner.nextInt();
            System.out.println(a[num]);
        }
    }

//    public int tribblenacci(int i) {
//        System.out.println("computing");
//        if (i < 2) return 1;
//        if (i == 2) return 2;
//        if (i == 3) return 4;
//
//        else {
//            return tribblenacci(i - 1) + tribblenacci(i - 2) + tribblenacci(i - 3) + tribblenacci(i - 4);
//        }
//
//    }
}