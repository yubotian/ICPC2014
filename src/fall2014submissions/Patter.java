package fall2014submissions;

import java.util.Arrays;
import java.io.BufferedReader;
import java.util.List;
import java.util.ArrayList;
import java.io.FileReader;

/**
 * Created by Yubo on 9/18/14.
 */
public class Patter {

    public static void main(String[] args) {
        new Patter().go();
    }


    //Scanner scanner = new Scanner(S);

    //String address = "/Users/Yubo/Desktop/CompSci309/src/PracticeInput.txt";
    //File newFile = new File();


    /**
     * Open and read a file, and return the lines in the file as a list
     * of Strings.
     * (Demonstrates Java FileReader, BufferedReader, and Java5.)
     */


    private List<String> readFile(String filename) {
        List<String> records = new ArrayList<String>();
        //System.out.println(System.getProperty("user.dir"));
       // File file = new File(System.getProperty("user.dir") + "/file.txt");
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
            reader.close();
            return records;
        } catch (Exception e) {
            System.err.format("Exception occurred trying to read '%s'.", filename);
            e.printStackTrace();
            return null;
        }
    }

    public void go() {

        List<String> records = new Patter().readFile("/Users/Yubo/Desktop/CompSci309/src/PracticeInput.txt");
        //System.out.println(records.size());

        int count = 0;
        while(count<records.size()){
            String temp = records.get(count);
            String[] tempp = temp.split(",");
            String stra = tempp[0].toLowerCase().replace(" ","");
            String strb = tempp[1].toLowerCase().replace(" ","");

            boolean t = true;
            char[] a =stra.toCharArray();
            char[] b =strb.toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);


            int x = a.length;
            if (b.length < x) {x = b.length;}
            if (a.length != b.length){t=false;}

            for (int i = 0; i< x ;i++){
                if (a[i] != b[i]) {t = false;}
            }
            if (t){System.out.println("Valid Pattern");} else {System.out.println("Invalid Pattern");}
            count++;

        }
    }


}

