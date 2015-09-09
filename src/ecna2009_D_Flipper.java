import java.util.*;

/**
 * Created by Yubo on 9/9/15.
 */
public class ecna2009_D_Flipper {
    public static void main(String[] args){new ecna2009_D_Flipper().go();}
    Scanner in = new Scanner(System.in);

    private class card{
        int number;
        char face;

        card(int number, char face){
            this.number = number;
            this.face = face;
        }

        public void flip(){
            this.face = this.face == 'U' ? 'D' : 'U';
        }

    }

    private void go()
    {
        int case_c = 0;
        while (true){
            case_c ++;

            int total_cards = in.nextInt();

            if (total_cards == 0) return;

            // read in initial postions
            ArrayList<ArrayList<card>> table = new ArrayList<ArrayList<card>>();
            String line = in.next().trim();

            for (int i = 1; i<= total_cards; i++)
            {
                ArrayList<card> pile = new ArrayList<card>();
                pile.add(new card(i, line.charAt(i-1)));

                table.add(pile);
            }

            // perform flips
            String flips = in.next().trim();

            for (int i = 0; i < flips.length(); i++)
            {
                if (flips.charAt(i) == 'R')
                {
                    ArrayList<card> tail = table.get(table.size()-1);
                    ArrayList<card> base = table.get(table.size()-2);

                    table.remove(table.size()-1);
                    table.remove(table.size()-1);

                    for (int k = tail.size()-1; k >=0; k--)
                    {
                        tail.get(k).flip();
                        base.add(tail.get(k));
                    }

                    table.add(base);

                }
                else if (flips.charAt(i) == 'L')
                {
                    ArrayList<card> head = table.get(0);
                    ArrayList<card> base = table.get(1);

                    table.remove(0);
                    table.remove(0);

                    for (int k = head.size()-1; k>=0; k--)
                    {
                        head.get(k).flip();
                        base.add(head.get(k));
                    }

                    table.add(0,base);
                }
            }

            //printTable(table);

            // answer queries
            int total_queries = in.nextInt();
            System.out.println("Pile " + case_c);
            while (total_queries -- >0)
            {
                int q = in.nextInt();
                card t = table.get(0).get(total_cards - q);
                System.out.printf("Card %d is a face %s %d.\n", q, t.face == 'U'?"up":"down", t.number);
            }


        }


    }

    private void printTable(ArrayList<ArrayList<card>> table)
    {
        for (int i = 0 ; i< table.size(); i++)
        {
            ArrayList<card> pile = table.get(i);

            for (int j = 0; j < pile.size(); j++)
            {
                System.out.print(pile.get(j).number + ":" + pile.get(j).face + "  ");
            }
            System.out.println();
        }
    }


}


