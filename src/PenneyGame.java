import java.util.Scanner;

/**
 * Created by Yubo on 9/28/14.
 */
public class PenneyGame {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int ttl = Integer.parseInt(scanner.nextLine());
        int count = 0;
        while(count<ttl){
            count ++;
            int casenum = Integer.parseInt(scanner.nextLine().trim());

            String in = scanner.nextLine();
            Integer[] re = {0,0,0,0,0,0,0,0};
            for (int i = 0; i< 38;i++){
                //TTT, TTH, THT, THH, HTT, HTH, HHT and HHH
                if (in.substring(i, i+3).equals("TTT")) re[0]++;
                if (in.substring(i, i+3).equals("TTH")) re[1]++;
                if (in.substring(i, i+3).equals("THT")) re[2]++;
                if (in.substring(i, i+3).equals("THH")) re[3]++;
                if (in.substring(i, i+3).equals("HTT")) re[4]++;
                if (in.substring(i, i+3).equals("HTH")) re[5]++;
                if (in.substring(i, i+3).equals("HHT")) re[6]++;
                if (in.substring(i, i+3).equals("HHH")) re[7]++;

            }
            System.out.printf("%d ",casenum);
            System.out.printf("%d %d %d %d %d %d %d %d\n",re[0],re[1],re[2],re[3],re[4],re[5],re[6],re[7]);

//            StringBuilder s = new StringBuilder();
//            s.append(casenum);
//
//            for (int j = 0; j<8; j++){
//                s.append(" ");
//                s.append(re[j]);
//            }
//            System.out.println(s.toString());



        }

    }


}
