import java.util.Scanner;

/**
 * Created by Yubo on 3/30/15.
 *
 *
 * 0 0 5 0 0 5 3 2 7 2 0 4
 1.3 2.6 12.1 4.5 8.1 13.7 2.2 0.1 9.8 6.6 1.9 6.7
 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0 0.0
 *
 */
public class scrim_a {

    Scanner in  = new Scanner(System.in);

    public static void main(String args[]){ new scrim_a().go();}

    public void go(){
        while(true){

            double side1 = 0;
            double side2 = 0;
            double side3 = 0;

            double ax = in.nextDouble();
            double ay = in.nextDouble();

            double bx = in.nextDouble();
            double by = in.nextDouble();

            double cx = in.nextDouble();
            double cy = in.nextDouble();

            double side1x  = in.nextDouble();
            double side1y  = in.nextDouble();
            double side2x  = in.nextDouble();
            double side2y  = in.nextDouble();
            double side3x  = in.nextDouble();
            double side3y  = in.nextDouble();

            if (side1x + side1y + side2x +side2y + side3x + side3y == 0.0){
                break;
            }

            side1 = Math.sqrt(Math.pow((side2x - side1x), 2)+ Math.pow((side2y - side1y), 2));
            side2 = Math.sqrt(Math.pow((side3x - side2x), 2)+ Math.pow((side3y - side2y), 2));
            side3 = Math.sqrt(Math.pow((side1x - side3x), 2)+ Math.pow((side1y - side3y), 2));

            double s = (side1 + side2 + side3) / 2;
            double area = Math.sqrt(s * (s - side1) * (s - side2) * (s-side3));

            //System.out.println("area : " + area);


            // area /

            double AB = Math.sqrt(Math.pow((bx - ax), 2)+ Math.pow((by - ay), 2));
            double AC = Math.sqrt(Math.pow((cx - ax), 2)+ Math.pow((cy - ay), 2));
            double d = area / AB;
            double cos_theta = ((cx-ax)*(bx-ax)+(cy-ay)*(by-ay)) / (AB * AC);
            double theta = Math.acos(cos_theta);
            double AH = d / Math.sin(theta);
            double hx = ax + (AH / AC)*(cx - ax);
            double hy = ay + (AH / AC)*(cy - ay);
            double gx = bx + (AH / AC)*(cx - ax);
            double gy = by + (AH / AC)*(cy - ay);

            System.out.printf("%.3f %.3f %.3f %.3f\n", gx,gy,hx,hy);
        }


    }





}
