import java.util.*;

/**
 * Created by Yubo on 10/3/15.
 */
public class k {
    public static void main(String[] args){
        new k().go();
    }
    Scanner in = new Scanner(System.in);
    public void go(){
        ArrayList<Integer> t = new ArrayList<Integer>();

        int max = 0;
        String line;
        while (in.hasNextLine()){
            line = in.nextLine();

            int temp = line.length();

            max = temp > max ? temp : max;

            t.add(temp);
        }

        // result
        int result = 0;
        for (int i = 0; i < t.size()-1; i++){
            result += Math.pow((max-t.get(i)),2);
        }
        System.out.println(result);
        return;
    }

}
