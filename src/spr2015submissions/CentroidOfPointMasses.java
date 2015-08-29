package spr2015submissions;

import java.util.Scanner;

/**
 * Created by Yubo.
 */
public class CentroidOfPointMasses {
    public static void main(String args[]){
        new CentroidOfPointMasses().go();
    }

    Scanner in = new Scanner(System.in);

    public float masspoint(float[] x, float[] m){
        float r = 0;
        float d = 0;
        for (int i = 0; i < x.length; i++) {
            r += x[i] * m[i];
            d += m[i];
        }
        return r/d ;
    };


    public void go(){

        int c = 0;

        while(true){
            c ++;
            int num = in.nextInt();

            if (num < 0 ){
                return ;
            }

            float[] x = new float[num];
            float[] y = new float[num];
            float[] m = new float[num];

            for (int i = 0; i < num; i++) {
                x[i] = in.nextFloat();
                y[i] = in.nextFloat();
                m[i] = in.nextFloat();
            }
            float rx = masspoint(x,m);
            float ry = masspoint(y,m);

            System.out.printf("Case %d: %.2f %.2f\n", c, rx, ry);

        }

    };
}
