import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;


public class Q1_EightQueens {
	public static void main (String[] args) {
		Scanner sc = new Scanner (System.in);
		String[] board = new String[8];
		boolean ans = true;
		for (int i = 0; i < 8; i++) {
			board[i] = sc.nextLine();
		}
		ArrayList<Point> pos = new ArrayList<Point>();
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (board[i].charAt(j)=='*') {
					pos.add(new Point(i, j));
				}
			}


        }

        if (pos.size() != 8){System.out.printf("invalid");
        return;}

		for (int i = 0; i < pos.size(); i++) {
			for (int j = i+1; j < pos.size(); j++) {
				if (notValid(pos.get(i), pos.get(j))) {
					System.out.printf("invalid");
					return;
				}
			}
		}
		System.out.printf("valid");
		sc.close();
	}



	private static boolean notValid(Point point, Point point2) {
		
		if (point.y == point2.y || point.x == point2.x) {
			return true;
		}
		return Math.abs((double) (point.y - point2.y) / (point.x - point2.x)) == 1.0;
	}
}
