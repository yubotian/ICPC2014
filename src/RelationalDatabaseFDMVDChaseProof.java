import java.util.*;

/**
 * Created by Yubo on 10/7/14.
 */
public class RelationalDatabaseFDMVDChaseProof {

    ArrayList<String> dependencies = new ArrayList<String>();
    ArrayList<String[]> tableau = new ArrayList<String[]>();
    Set equalities = new HashSet();
    String[] attributes;

    int entryLength;

    public static void main(String[] args){
        new RelationalDatabaseFDMVDChaseProof().go();
    }

    public void go(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter inputs: ");
        attributes = scanner.nextLine().toLowerCase().trim().split(", ");
        entryLength = attributes.length;
        //for (int i = 0; i < attributes.length; i++){System.out.printf("%s\n", attributes[i]);}

        //System.out.println("Enter dependencies and chase: ");
        while (true){
            //read in the FDs and MVDs
            dependencies.add(scanner.nextLine().toLowerCase());
            if (dependencies.get(dependencies.size()-1).matches("^chase.*")){break;}
        }
        String claim = dependencies.get(dependencies.size()-1);  // get the claim from dependencies
        dependencies.remove(dependencies.size()-1);

        initializeTableau(claim);

        System.out.println("after initialization, the tableau has: ");
        for (int i = 0; i < tableau.size(); i++){System.out.printf("%s\n", Arrays.asList(tableau.get(i)).toString() );}


        //analyze all dependencies
        for (int i = 0; i < dependencies.size(); i++){
            String currd = dependencies.get(i);
            //System.out.printf("%s\n", currd );
            if (currd.matches("^fd.*")){
                solve_FD(currd);
            } else {
                solve_MVD(currd);
            }
        }

 //       System.out.println("After solve dependencies: ");
//        Iterator it = equalities.iterator();               // iterator to check equalities
//        while (it.hasNext()) {
//            Object element = it.next();
//            System.out.println(element);
//        }

        //generate and check goal, print out result
        String result;
        if (claim.matches(".*fd.*")){
            result = checkGoal_FD(claim);
        } else {
            result = checkGoal_MVD(claim);
        }

        System.out.print(result);
    }

    public void initializeTableau(String claim){

            String[] temp = claim.split(":");

            String[] unsubscripted = temp[2].trim().split(",");   //columns that should be same
           // String[] subscripted = temp[3].trim().split(",");   //column that should be numbered

            String[] row1 = new String[entryLength];
            String[] row2 = new String[entryLength];
            for (int i = 0; i < unsubscripted.length ;i++ ){
                int index = -1;
                for (int j=0;j<attributes.length;j++) {
                    if (attributes[j].equals(unsubscripted[i])) {
                        index = j;
                        break;
                    }
                }
                //System.out.print(index);
                //System.out.println(Arrays.asList(attributes).toString());

                row1[index] = unsubscripted[i];  row2[index]=unsubscripted[i];
            }

            for (int i = 0; i < entryLength ;i++ ){
                if (row1[i] == null) {row1[i]= attributes[i]+"1"; row2[i] = attributes[i]+"2";}
            }

        tableau.add(row1); tableau.add(row2);
    }


    public String checkGoal_FD(String claim){
        //if claim is fd...else is a mvd...
        String result = "Target dependency proved sucessfully: " + claim ;

        String[] temp = claim.split(":");

        String[] to = temp[3].trim().split(",");
        for (int k = 0; k < to.length;k++) {
            int index = 0;
            for (int h = 0; h < attributes.length; h++) {
                if (attributes[h].equals(to[k])) {
                    index = h;
                    break;
                }
            }
            if (!equalities.contains(tableau.get(0)[index] + tableau.get(1)[index]))
                result = "Proof failed. Counter example: " + (tableau.get(0)[index] + tableau.get(1)[index]);
        }
        return result;
    }

    public String checkGoal_MVD(String claim){
        String result = "Target dependency proved sucessfully: " + claim ;

        String[] temp = claim.split(":");
        String[] to = temp[3].trim().split(",");

        String[] goala = new String[entryLength];
        String[] goalb = new String[entryLength];

        for (int k = 0; k < to.length; k++){
            int index = 0;
            for (int h=0;h<attributes.length;h++) {
                if (attributes[h].equals(to[k])) {
                    index = h;
                    goala[index] = tableau.get(1)[index];  goalb[index] = tableau.get(0)[index];
                    break;
                }
            }
        }
        for (int m = 0; m< entryLength; m++){
            if (goala[m]!=null){ goala[m]= tableau.get(0)[m]; goalb[m]= tableau.get(1)[m];}
        }

        if (!tableau.contains(goala)) {
            result =  "Proof failed. Counter example: cannot infer:" + Arrays.asList(goala).toString(); }
        if (!tableau.contains(goalb)) {
            result =  "Proof failed. Counter example: cannot infer:" + Arrays.asList(goalb).toString(); }
        return result;
    }

    //solve each fd, add the inferred equality to equals

    public void solve_FD (String fd){
        String[] temp = fd.split(":");

        String[] from = temp[1].trim().split(", ");   //columns that should be same
        String[] to = temp[2].trim().split(",");

        System.out.println(Arrays.asList(from).toString() );

        for (int i = 0; i< tableau.size()-1;i++){
            for (int j = i+1; j< tableau.size(); j++){
                //if i and j agree on all of 'from',  then if i and j's value at 'to' are diff and not in equalities, add it in
                boolean isAgree = agree(tableau.get(i), tableau.get(j), from);
                //System.out.println(isAgree);
                if (isAgree) {
                    // get teh to entries be equal
                    for (int k = 0; k < to.length;k++){
                        int index = 0;
                        for (int h=0;h<attributes.length;h++) {
                            if (attributes[h].equals(to[k])) {
                                index = h;
                                break;
                            }
                        }
                        equalities.add((tableau.get(i)[index]+tableau.get(j)[index]));
                        equalities.add((tableau.get(j)[index]+tableau.get(i)[index]));
                        //add this equality(both way) to equalities
                    }
                }
            }
        }
    }

    //solve each mvd, add two new tuples to tableaus
    public void solve_MVD(String mvd){

        String[] temp = mvd.split(":");

        String[] from = temp[1].trim().split(", ");   //columns that should be same
        String[] to = temp[2].trim().split(",");

        for (int i = 0; i< tableau.size()-1;i++) {
            for (int j = i + 1; j < tableau.size(); j++) {

                boolean isAgree = agree(tableau.get(i), tableau.get(j), from);
                //System.out.println(isAgree);
                if (isAgree) {
                    String[] a = new String[entryLength];
                    String[] b = new String[entryLength];
                    for (int k = 0; k < to.length; k++){
                        int index = 0;
                        for (int h=0;h<attributes.length;h++) {
                            if (attributes[h].equals(to[k])) {
                                index = h;
                                a[index] = tableau.get(j)[index];  b[index] = tableau.get(i)[index];
                                break;
                            }
                        }
                    }
                    for (int m = 0; m< entryLength; m++){
                        if (a[m]!=null){ a[m]= tableau.get(i)[m]; b[m]= tableau.get(j)[m];}
                    }
                    if (!tableau.contains(a)) {tableau.add(a);}
                    if (!tableau.contains(b)) {tableau.add(b);}
                }
            }
        }

    }


    public boolean agree(String[] entrya, String[] entryb, String[] from){
        boolean isAgree = true;
        for (int i = 0; i<from.length;i++){
            int index = -1;
            for (int j=0;j<attributes.length;j++) {
                if (attributes[j].equals(from[i])) {
                    index = j;
                    break;
                }
            }
            if (! (entrya[index].equals(entryb[index]) | equalities.contains(entrya[index]+entryb[index])) ){

//                System.out.println("b1b2 different!!!!!!!!");
//                System.out.println(entrya[index]);
//                System.out.println(entryb[index]);
                isAgree = false;}
        }
        return isAgree;

    }
}
