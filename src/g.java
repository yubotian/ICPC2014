import java.util.*;
/**
 * Created by Yubo on 10/3/15.
 */
public class g {

    public static void main(String[] args){
        new g().go();
    }

    Scanner in = new Scanner(System.in);

    public void go(){
        int num_room = in.nextInt();

        int c_room = 0;

        ArrayList<Integer> rooms = new ArrayList<Integer>();

        int min = 0;
        int max = 0;

        while (c_room < num_room){
            c_room ++;
            int r = in.nextInt();
            min = Math.min(min,r);
            max = Math.max(max,r);

            rooms.add(r);
        }

        int[][] adj = new int[num_room][num_room];

        Collections.sort(rooms);

        for (int i = 0; i< num_room; i++){
            for (int j = 0; j < num_room; j++) {
                if ( i == j) {
                    continue;
                }
                int g = GCD(rooms.get(i), rooms.get(j));
                if (g != 1) {
                    adj[i][j] = g;
                }
            }

        }

        int result = mf1(0, num_room-1, adj);
        System.out.println(result);

    }



    public int mf1(int u,int v,int[][] in){
        int[][] flow=new int[in.length][in.length];
        int tot=0;
        while(true){
            Queue<Integer>q=new LinkedList<Integer>();
            int[] prev=new int[in.length],fill=new int[in.length];
            q.offer(u);
            Arrays.fill(prev, -1);
            prev[u]=-2;
            fill[u]=Integer.MAX_VALUE;
            while(prev[v]==-1){
                if(q.isEmpty())return tot;
                int p=q.poll();
                for(int i=0;i<in.length;i++)if(p!=i&&prev[i]==-1&&(flow[p][i]<in[p][i]||flow[i][p]>0)){
                    prev[i]=p;
                    fill[i]=Math.min(fill[p], in[p][i]-flow[p][i]+flow[i][p]);
                    q.offer(i);
                }
            }
            tot+=fill[v];
            int t=v;
            while(t!=u){
                int s=prev[t];
                flow[t][s]-=Math.max(0, flow[s][t]+fill[v]-in[s][t]);
                flow[s][t]=Math.min(flow[s][t]+fill[v], in[s][t]);
                t=s;
            }
        }
    }

    public int GCD(int a, int b) {
        if (b==0) return a;
        return GCD(b,a%b);
    }
}
