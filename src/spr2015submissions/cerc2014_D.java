package spr2015submissions;

import java.util.*;


/**
 * wheels
 *
 * Created by Yubo on 3/16/15.
 *
 * worked with Lydia Xu
 */


class Wheels {
    
    Wheel[] wheels; // storing all the 
    
    // alternative way
    public class Wheel{
        int x,y,radius;
        int p=0,q;
        //int index; // the index of the wheels adjacent to it?
        boolean isClock;
        boolean visited;
        ArrayList<Wheel> adj; // store the wheels adjacent to it
        
        public Wheel(int nx,int ny, int nr){
            x=nx;
            y=ny;
            radius = nr;
            visited = false;
        }
    }
    
    public boolean isTangent(Wheel w1,Wheel w2){
        int r1,r2,d;
        r1 = w1.radius;
        r2 = w2.radius;
        d = (int) (Math.pow((w1.x-w2.x),2)+Math.pow((w1.y-w2.y),2));
        int sum = (int) (Math.pow(r1+r2,2));
        /*System.out.println(d);
        System.out.println(sum);
        System.out.println("-------");*/
        return d==sum;
    }
    
    // then run bfs starting at first, every adjacent wheel has the !isClock of previous one and 
    public void bfs(Wheel w){
        if(!w.visited){
            w.visited = true;
            for(Wheel temp:w.adj){
                temp.isClock = !w.isClock;
                temp.p = w.radius*w.p;
                temp.q = temp.radius*w.q;
                int gcd = gcd(temp.p,temp.q);
                temp.p = temp.p/gcd;
                temp.q = temp.q/gcd;
                /*
                 *  
                 */
                //System.out.println("p is: "+temp.p);
                //System.out.println("q is: "+ temp.q);
                bfs(temp);
            }
        }
    }
    
    //String gcd()
    public int gcd(int a, int b){
        if(b!=0){
            int temp = b;
            b = a%b;
            a = temp;
            return gcd(a,b);
        }
        return a;
    }
    
    public String speed(int a, int b){
        if(gcd(a,b)==b){
            b = a/b;
            return Integer.toString(b);
        }else if(gcd(a,b)==a){
            //a = (a/a)/(b/a);
            return "1/"+Integer.toString(b/a);
        }else{
            int temp = gcd(a,b);
            a = a/temp;
            b = b/temp;
            String s = Integer.toString(a)+"/"+Integer.toString(b);
            return s;
        }
    }
    
    //bfs queue
    // hashcode - the order of the circle
    
    
    
    public void solve(){
        Scanner in = new Scanner(System.in);
        int cases = in.nextInt();
        int i=0;
        //for(int i=0;i<cases;i++){
        while(i<cases){
            int n = in.nextInt();
            Wheel first = new Wheel(in.nextInt(),in.nextInt(),in.nextInt());
            first.p = 1;
            first.q = 1;
            first.isClock = true;
            wheels = new Wheel[n];
            wheels[0] = first;
            for(int k=1;k<n;k++){
                Wheel temp = new Wheel(in.nextInt(),in.nextInt(),in.nextInt());
                wheels[k] = temp;
            }
            
            // storing the adj wheels to each wheel in an arraylist
            for(int j=0;j<n;j++){
                ArrayList<Wheel> temp1 = new ArrayList<Wheel>();
                for(int k=0;k<n;k++){
                    if(isTangent(wheels[j],wheels[k])){
                        temp1.add(wheels[k]);
                    }
                }
                wheels[j].adj = temp1;
            }
            
            // start to run bfs and update the clock and speed
            bfs(first);
            
            // print the result
            for(int k=0;k<n;k++){
                Wheel cur = wheels[k];
                // consider not moving
                if(cur.p==0){
                    System.out.println("not moving");
                    continue;
                }
                //System.out.println(cur.p);
                //System.out.println(cur.q);
                String s = speed(cur.p,cur.q);
                String clock = "";
                if(cur.isClock){
                    clock = " clockwise";
                }
                else{
                    clock = " counterclockwise";
                }
                System.out.print(s);
                System.out.println(clock);
            }
            i++;
        //System.out.println(i);
        //System.out.println(cases);
        }
        
    }
    
    public static void main(String[] arg){
        Wheels w = new Wheels();
        w.solve();
        
    }

}
 