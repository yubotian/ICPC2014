import java.util.*;
/**
 * Created by Yubo on 11/5/15.
 * 3
 1 2 3 3
 2 3 2 2
 3 4 2 2
 4
 3 5
 1 2
 4 2
 3 3
 2
 5 10 2 10
 100 100 100 100 2
 5 13
 100 101
 0
 */
public class ecna2009_H_Windows {
    public static void main(String[] args){new ecna2009_H_Windows().go();}

    Scanner in = new Scanner(System.in);

    public void go(){

        class window{
            int r;
            int c;
            int w;
            int h;

            window (int r, int c, int w, int h){this.r = r;this.c=c;this.w=w;this.h=h;}

            boolean containsPoint(int r, int c){
                if (r>=this.r && c>=this.c && r< this.r+this.h && c< this.c+this.w) return true;
                return false;
            }
        }

        int desktop_count = 0;
        while (true){
            int n = in.nextInt();

            if (n==0) break;
            desktop_count++;
            System.out.printf("Desktop %d:\n", desktop_count);
            HashMap<Integer, window> desk = new HashMap<Integer, window>();

            for (int i = 1; i <= n; i++){
                window t = new window(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());
                desk.put(i,t);
            }

            int c = in.nextInt(); // count

            for (int j = 0; j<c; j++){
                //each test scenario
                int cr = in.nextInt();
                int cc = in.nextInt();
                boolean on_window = false;
                for (int k = n; k>0; k--) {
                    if (desk.get(k).containsPoint(cr, cc)) {
                        System.out.printf("window %d\n",k);
                        on_window = true;
                        break;
                    }
                }
                if (!on_window) System.out.printf("background\n");
            }
        }
    }

}
