import java.util.*;
/**
 * Created by Yubo on 11/5/15.
 */
public class qual2012_CurvyBlocks {
    public static void main(String[] args){new qual2012_CurvyBlocks().go();}
    Scanner in = new Scanner(System.in);

    double h0,h1,h2,h3;

    void go(){
        while (in.hasNext()){
            double b0 = in.nextDouble();
            double b1 = in.nextDouble();
            double b2 = in.nextDouble();
            double b3 = in.nextDouble();
            double t0 = in.nextDouble();
            double t1 = in.nextDouble();
            double t2 = in.nextDouble();
            double t3 = in.nextDouble();

            // h = h0 + h1 x + h2 x^2 + h3 x^3
            h0 = b0-t0;
            h1 = b1-t1;
            h2 = b2-t2;
            h3 = b3-t3;

            //derivative of h = H = H1 + H2 x + H3 x^2
            double H1 = h1; double H2 = h2 * (double)2 ; double H3 = h3 * (double)3;
            double c = h1; double b = h2 * (double)2 ; double a = h3 * (double)3;
            // System.out.printf("c: %.6f  b: %.6f  a: %.6f \n", c, b,  a);


            if (Math.pow(b, 2) - (double)4*a*c < 0)
            {
                // b^2 - 4ac < 0
                // 差函数单调递增or递减
                double v0 = getDiffAt((double)0); // at 0
                double v1 = getDiffAt((double)1); // at 1

                System.out.printf("%.6f\n", Math.abs(v0-v1));
            }
            else if (Math.pow(b, 2) - (double)4*a*c == 0)
            {
                // b^2 - 4ac = 0
                double root = (-b / ((double)2*a));

                double v0 = getDiffAt((double)0); // at 0
                double v1 = getDiffAt((double)1);

                if (root > 0 && root < 1){
                    double v_root = getDiffAt(root);
                    System.out.printf("%.6f\n", Math.max(Math.abs(v0-v_root), Math.abs(v1-v_root)));
                } else {
                    // root is outside of [0,1], -> 在［0，1］上差函数单调递增or递减
                    System.out.printf("%.6f\n", Math.abs(v0-v1));
                }
            }
            else
            {
                // b^2 - 4ac > 0
                double root1, root2;
                root1 = (-b + Math.sqrt(Math.pow(b, 2) - (double)4*a*c)) / ((double)2*a);
                root2 = (-b - Math.sqrt(Math.pow(b, 2) - (double)4*a*c)) / ((double)2*a);

                double v0 = getDiffAt((double)0); // at 0
                double v1 = getDiffAt((double)1);

                double v_root1 =  getDiffAt(root1);
                double v_root2 =  getDiffAt(root2);

                if (root1>0 && root1<1 && root2>0 && root2<1){
                    //两个根都在（0，1）
                    double f[] = {v0,v1,v_root1,v_root2};
                    //System.out.printf("debug: %.6f, %.6f, %.6f, %.6f", v0,v1,v_root1,v_root2);
                    Arrays.sort(f);
                    //System.out.printf("debug: %.6f, %.6f, %.6f, %.6f", f[0],f[1],f[2],f[3]);
                    System.out.printf("%.6f\n", Math.abs(f[3]-f[0]));

                } else if ((root1<=0 || root1 >= 1) && (root2<=0 || root2 >= 1)){
                    // 两个根都不在 （0，1），=> (0,1)之间 差函数单调
                    System.out.printf("%.6f\n", Math.abs(v0-v1));
                } else {
                    // root1 或 root2 在 （0，1）之间， same as b^2 - 4ac = 0 && root is between 0 and 1
                    double root_of_interest = (root1>0 && root1<1) ? root1 : root2;
                    double v_root_of_interest = getDiffAt(root_of_interest);
                    System.out.printf("%.6f\n", Math.max(Math.abs(v0-v_root_of_interest), Math.abs(v1-v_root_of_interest)));
                }
            }
        }
    }

    double getDiffAt(double x){
        return h0 + h1 * x + h2 * Math.pow(x,2) + h3 * Math.pow(x,3);
    }
}
