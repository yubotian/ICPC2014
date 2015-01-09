package fall2014submissions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yubo on 9/22/14.
 */
public class Unreachable {
    public static void main(String[] args){
        new Unreachable().go();
    }

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


    public void go(){
        List<String> records = new Unreachable().readFile("");
        int totalln = records.size();
        List<Integer> visited = new ArrayList<Integer>();
        int currln = 0;
        int prevln = 0;
        int count = 0;
        while (true){
               //break if loop back again
            // break if load last instruction again?
            if (records.get(currln).equals("NEXT")){
                if (visited.contains(currln)){break;}
                visited.add(currln);
                if (currln != totalln){currln ++;}
            }
            else {
                if (visited.contains(currln)){break;}
                String myln = records.get(currln).trim();
                String temp = myln.substring(5,myln.length());
                int tempp = Integer.parseInt(temp);
                System.out.println(tempp);
               // System.out.println("JUMP!!");
                visited.add(currln);
                //prevln = currln;
                currln = tempp;
            }
        }
        //System.out.println(visited.size());

        for (int i = 0; i < records.size();i++){
            if (visited.contains(i)){
                System.out.println(i);
            }
        }
    }
}
