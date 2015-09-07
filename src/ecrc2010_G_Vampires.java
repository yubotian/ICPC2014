import java.util.*;

/**
 * Created by Yubo on 9/6/15.
 *
 *

 8 0 4
 10 5
 20 5
 5 10
 10 10
 20 10
 5 20
 10 20
 20 20
 N 10 0 10 0
 E 0 20 0 20
 S 20 30 20 30
 W 30 10 30 10
 0 0 0

 */


public class ecrc2010_G_Vampires {

    boolean DEBUG = false;

    Scanner in = new Scanner(System.in);

    private class mirror
    {
        char direction;
        int start_x;
        int end_x;
        int start_y;
        int end_y;

        mirror (char direction,
                int start_x,
                int end_x,
                int start_y,
                int end_y)
        {
            this.direction = direction;
            this.start_x = start_x;
            this.end_x = end_x;
            this.start_y = start_y;
            this.end_y = end_y;
        }
    }

    public static void main(String[] args)
    {
        new ecrc2010_G_Vampires().go();
    }

    private void go()
    {
        int case_count = 1;
        while (true){

            int num_v = in.nextInt();
            int num_o = in.nextInt();
            int num_m = in.nextInt();

            if (num_v + num_o + num_m == 0)
                break;

            System.out.println("Case "+ case_count + ":");
            case_count++;

            int vampire_count = 1;
            int ordinary_count = 1;
            int mirror_count = 1;

            // 2d array: 100*100 to represent the map, Arraylist to keep result
            char[][] map = new char[101][101];
            HashMap<String,String> vampires = new HashMap<String, String>();
            ArrayList<String> indexTracker = new ArrayList<String>();


            while (vampire_count <= num_v)
            {
                int x = in.nextInt();
                int y = in.nextInt();

                map[y][x] = 'v';

                String pos = x + ":" + y;
                vampires.put(pos,"");
                indexTracker.add(pos);

                vampire_count++;
            }

            while (ordinary_count <= num_o)
            {
                int x = in.nextInt();
                int y = in.nextInt();

                map[y][x] = 'o';
                ordinary_count++;
            }


            ArrayList<mirror> mirrors = new ArrayList<mirror>();

            // iterate through each mirror and input into map
            while ( mirror_count <= num_m)
            {
                char direction = in.next().trim().toCharArray()[0];
                int start_x = in.nextInt();
                int start_y = in.nextInt();
                int end_x = in.nextInt();
                int end_y = in.nextInt();

                mirror m = new mirror(direction, start_x, end_x, start_y, end_y);

                mirrors.add(m);

                if (start_x == end_x) {
                    for (int k = Math.max(start_y,end_y); k >= Math.min(start_y, end_y); k--)
                    {
                        map[k][start_x] = 'm';
                    }
                }
                else if (start_y == end_y)
                {
                    for (int k = Math.min(start_x,end_x); k <= Math.max(start_x, end_x); k++)
                    {
                        map[start_y][k] = 'm';
                    }
                }

                mirror_count ++;
            }

            if (DEBUG) printMap(map);

            if (DEBUG) printMirrors(mirrors);

            // iterate through each mirror and solve
            for (mirror m : mirrors)
            {
                char direction = m.direction;
                int start_x = m.start_x;
                int start_y = m.start_y;
                int end_x = m.end_x;
                int end_y = m.end_y;

                if (DEBUG) System.out.println(" @@@@@@@@@@@@@@@@@@@@@@@@   Solving Mirror " + (mirrors.indexOf(m)+1) + " " + m.direction);


                if (direction == 'W')
                {
                    for (int i = Math.max(start_y, end_y); i >= Math.min(start_y,end_y); i--)
                    {
                        for (int j = end_x-1; j >= 0; j --)
                        {
                            String curr_pos = j+":"+i;

                            if (DEBUG) System.out.printf("**** AT : " + curr_pos + "\n");

                            if (map[i][j] == 'v')
                            {   // record
                                if (DEBUG) System.out.printf("**** HIT : " + curr_pos + "\n");
                                //System.out.printf(vampires.get(curr_pos) + "\n");

                                vampires.put(curr_pos, vampires.get(curr_pos)+ "E");
                            }

                            if (map[i][j] == 'o' || map[i][j] == 'm') {/*mirror interfered*/ break;}
                        }
                    }
                }
                else if (direction == 'E')
                {
                    for (int i = Math.max(start_y,end_y); i >= Math.min(start_y,end_y); i--)
                    {
                        for (int j = end_x+1; j <= 100; j ++)
                        {
                            String curr_pos = j+":"+i;

                            if (DEBUG) System.out.printf("**** AT : " + curr_pos + "\n");

                            if (map[i][j] == 'v')
                            {   // record
                                if (DEBUG) System.out.printf("**** HIT : " + curr_pos + "\n");
                                //System.out.printf(vampires.get(curr_pos) + "\n");

                                vampires.put(curr_pos, vampires.get(curr_pos)+ "W");
                            }

                            if (map[i][j] == 'o' || map[i][j] == 'm') {/*mirror interfered*/ break;}
                        }
                    }
                }
                else if (direction == 'S')
                {
                    for (int i = Math.min(start_x,end_x); i <= Math.max(start_x, end_x); i++)
                    {
                        for (int j = start_y-1; j >= 0; j --)
                        {
                            String curr_pos = i+":"+j;

                            if (DEBUG) System.out.printf("**** AT : " + curr_pos + "\n");

                            if (map[j][i] == 'v')
                            {   // record
                                if (DEBUG) System.out.printf("**** HIT : " + curr_pos + "\n");
                                //System.out.printf(vampires.get(curr_pos) + "\n");

                                vampires.put(curr_pos, vampires.get(curr_pos)+ "N");
                            }

                            if (map[j][i] == 'o'|| map[j][i] == 'm') {/*mirror interfered*/ break;}
                        }
                    }
                }
                else if (direction == 'N')
                {
                    for (int i = Math.min(start_x,end_x); i <= Math.max(start_x,end_x); i++)
                    {
                        for (int j = start_y+1; j <= 100; j ++)
                        {
                            String curr_pos = i+":"+j;

                            if (DEBUG) System.out.printf("**** AT : " + curr_pos + "\n");

                            if (map[j][i] == 'v')
                            {   // record
                                if (DEBUG) System.out.printf("**** HIT : " + curr_pos + "\n");
                                //System.out.printf(vampires.get(curr_pos) + "\n");

                                vampires.put(curr_pos, vampires.get(curr_pos)+ "S");
                            }

                            if (map[j][i] == 'o'|| map[j][i] == 'm') {/*mirror interfered*/ break;}
                        }
                    }
                }

                if (DEBUG) printVampires(vampires, indexTracker);

                mirror_count++;
            }

            boolean allSafe = true;

            for (int index = 0; index < indexTracker.size(); index ++)
            {
                String r = vampires.get(indexTracker.get(index));

                if ( r != "" ) {


                    String buf = "vampire " + (index+1);

                    buf += r.indexOf('E') > -1 ? " east" : "";
                    buf += r.indexOf('N') > -1 ? " north" : "";
                    buf += r.indexOf('S') > -1 ? " south" : "";
                    buf += r.indexOf('W') > -1 ? " west" : "";

                    buf.trim();

                    allSafe = false;
                    System.out.println(buf);

                }
            }

            if (allSafe) System.out.println("none");


        }

    }

    // debug helpers
    public void printMap(char[][] map)
    {
        for (int i =  map.length-1; i >= 0; i--)
        {
            for (int j = 0; j < map[i].length; j++)
            {
                System.out.printf("%c ", (map[i][j] == 'v'||map[i][j] =='o'||map[i][j] =='m') ? map[i][j] : '_');
            }
            System.out.printf("\n");
        }
    }

    public void printMirrors (ArrayList<mirror> M)
    {
        for (int i = 0; i < M.size(); i++)
        {
           System.out.printf( "mirror " + (i+1) + " : " + M.get(i).direction + " s_x=" + M.get(i).start_x + " s_y=" + M.get(i).start_y +" e_x" +  M.get(i).end_x + " e_y" + M.get(i).end_y + "\n");
        }
    }


    public void printVampires(HashMap<String, String> vampires, ArrayList<String> indexTracker)
    {
        for (int index = 0; index < indexTracker.size(); index ++) {
            String r = vampires.get(indexTracker.get(index));

            System.out.println( (index+1) + " = " + indexTracker.get(index) + " = " + r + "\n");

        }
    }

}
