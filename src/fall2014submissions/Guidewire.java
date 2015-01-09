package fall2014submissions;

/**
 * Created by Yubo on 11/17/14.
 */
public class Guidewire {
    public static void main(String[] args){
        new Guidewire().go();
    }

    public void go(){
        int A = 1000;
        int B = 9999;
        int count = 0;

        for (int i = A; i < B-1; i++){
            for (int j = i+1; j < B; j++){
                if (i == reverse(j)){
                    System.out.println("");
                    count ++;
                }
            }
        }
        System.out.println(count);
    }

    public int reverse(int num){
        String n = ""+num;
        char[] k = n.toCharArray();
        StringBuilder b = new StringBuilder();

        for (int m = 0; m < n.length() ; m++){
            b.append(k[m]);
        }
        String temp = b.reverse().toString();
        return Integer.parseInt(temp);
    }
}

