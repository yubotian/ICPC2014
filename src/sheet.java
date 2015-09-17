import java.util.*;
/**
 * Created by Yubo on 9/15/15.
 */
public class sheet {
    public static void main(String[] args){new sheet().go();}

    public void go(){
        //String
        String str = "testsheet";
        int strlen = str.length();
        int loc = str.indexOf('t');  // charAt
        boolean b = str.endsWith("et");
        boolean b2 = str.equals("testsheet");

        //array
        int[] array1 = {1,2,3,4,5,6,7,8,65,43};
        int[] array2 = new int[20];
        int[] array3;

        int len = array1.length;

        //ArrayList
        ArrayList<Character> al1 = new ArrayList<Character>();
        ArrayList<Character> al3;
        al3 = al1;

        al3.add('k');   al3.add('l');   al3.add('m'); // add to tail
        al1.addAll(al3);

        al3.remove(0);
        char removed = al3.remove(0); // get head

        loc = al3.indexOf('m');
        int i = al3.size();

        // Linkedlist (Queue)
        Queue<String> ll1 = new LinkedList<String>();
        int k = ll1.size();
        ll1.add("obj1");  // enqueue
        ll1.add("obj2");

        // linkedlist:
        // Object first = ll1.get(0);

        Object w = ll1.poll();  // dequeue
        System.out.println(w);

        Object then = ll1.peek();
        System.out.println(then);
        //Queue
        Queue<Integer> q = new LinkedList<Integer>();

        //Stack
        Stack<String> s = new Stack<String>();
        s.add("haha");
        s.push("ahahah2");
        s.push("hahaha333");
        String s_pop = s.pop();
        System.out.println(s_pop);
        System.out.println(s.pop());

        //HashMap
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        map.size();
        map.containsKey("you");
        map.containsValue(5);
        map.put("you",4);
        map.get("you");

    }

}
