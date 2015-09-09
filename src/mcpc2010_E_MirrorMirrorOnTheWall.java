import java.util.Scanner;

/**
 * Created by Yubo on 9/9/15.
 */
public class mcpc2010_E_MirrorMirrorOnTheWall {
    public static void main(String[] args){new mcpc2010_E_MirrorMirrorOnTheWall().go();}
    Scanner in = new Scanner(System.in);

    public void go()
    {
        String line = in.nextLine().trim();

        while(line.charAt(0) != '#')
        {
            boolean isInvalid = false;
            StringBuffer re = new StringBuffer();
            for (int i = line.length()-1; i>= 0; i--)
            {
                switch(line.charAt(i)){
                    case('i'):
                        re.append(line.charAt(i));
                        break;
                    case('o'):
                        re.append(line.charAt(i));
                        break;
                    case('v'):
                        re.append(line.charAt(i));
                        break;
                    case('w'):
                        re.append(line.charAt(i));
                        break;
                    case('x'):
                        re.append(line.charAt(i));
                        break;
                    case('p'):
                        re.append('q');
                        break;
                    case('q'):
                        re.append('p');
                        break;
                    case('b'):
                        re.append('d');
                        break;
                    case('d'):
                        re.append('b');
                        break;
                    default:
                        isInvalid = true;
                }
            }
            System.out.println(isInvalid? "INVALID" : re.toString());
            line = in.nextLine().trim();
        }
    }

}
