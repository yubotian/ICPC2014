import java.util.Scanner;

/**
 * Created by Yubo on 8/29/15.
 */
public class ecna2014_H_TimeWarp
{
    public static void main(String[] args)
    {
        new ecna2014_H_TimeWarp().go();
    }

    Scanner in = new Scanner(System.in);

    public static double DIFF_PER_SEC = (double)360/3600 - (double)360/(3600*12);

    void go()
    {
        int caseCount = in.nextInt();

        for (int i = 0; i < caseCount; i++)
        {
            int angle = in.nextInt();
            String flag = in.next();
            int time = in.nextInt();

            solve(i, angle, flag, time);
        }
    }

    void solve(int caseNum, int angle, String flag, int time)
    {
        // calculate curr angle based on time
        int currAngle = Math.abs(12 - time) * 30;

        double secToGo = 0;

        if (flag.equals("after"))
        {
            if (angle > currAngle)
                secToGo = (angle - currAngle) / DIFF_PER_SEC;
            else if (angle <= currAngle)
                secToGo = 360 / DIFF_PER_SEC + (angle - currAngle) / DIFF_PER_SEC;
        }
        else if (flag.equals("til"))
        {
            if (angle < currAngle)
                secToGo = 3600 * 12 + (angle - currAngle) / DIFF_PER_SEC;
            else if (angle >= currAngle)
                secToGo = 3600 * 12 + angle / DIFF_PER_SEC - (currAngle + 360) / DIFF_PER_SEC;
        }

        int hr = (time + ((int)((secToGo + 0.5) / 3600))) % 12;
        int min = ((int) ((secToGo + 0.5) / 60.0)) % 60;
        int sec = ((int) (secToGo + 0.5)) % 60;

        System.out.printf("Case " + (caseNum+1) + ": " + (hr==0?12:hr) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec)+"\n");
    }
}
