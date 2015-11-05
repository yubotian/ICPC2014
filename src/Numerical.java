/**
 * Created by Yubo on 10/15/15.
 */
public class Numerical {
    public static void main(String[] args){
        Numerical n = new Numerical();
        n.go();

        System.out.println();

        n.backwards();

    }

    double e = 2.718;

    void go(){
        double curr = 1.718; // e0
        for (int i = 1; i < 12; i++){
            System.out.printf("E_%d = %f\n", i-1, curr);
            curr = e - i * curr;
        }
    }

    void backwards(){
        double curr = 0.0; // e20

        for (int j = 20; j >= 10; j--){
            System.out.printf("E_%d = %f\n", j, curr);

            curr = -1.00 *(curr - e)/(double)j;
        }
    }

}
