import java.io.IOException;

/**
 * Created by Yubo on 9/17/15.
 */
public class StringTo64Int {
    public static void main(String[] args){
        new StringTo64Int().parseLong("123") ;
    }

    public static long parseLong(String str) throws IllegalArgumentException {
        if (str.length() == 0) {
            throw (new IllegalArgumentException());
        }

        String valid = "0123456789+-";

        long result = 0;
        boolean positive = true;

        for (int i = 0; i < str.length(); i++) {

            char curr = str.charAt(i);
            int ref = valid.indexOf(curr);

            if (ref == -1) {
                // not a number, nor + or -
                throw (new IllegalArgumentException());
            } else if (ref >= 10) {
                // set sign
                positive = ref == 11 ? false : true;
            } else {
                // update long
                long digit = (long) (Math.pow(10,str.length() - i - 1) == 0 ? 1 : Math.pow(10,str.length() - i - 1));
                result += (long) ((valid.charAt(ref)-48) * digit);
            }
        }

        result *= (long)(positive? 1 : -1);

        return result;
    }
}
