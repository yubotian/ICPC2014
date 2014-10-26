package gcpc2014;

import java.util.*;


public class KPizzaVoting {
	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		String first = s.nextLine();
		List<Integer> list = new ArrayList<Integer>();
		int numPizzas = Integer.parseInt(first.split(" ")[0]);
		int fav = Integer.parseInt(first.split(" ")[1]);
		for (int i = 0; i < numPizzas; i++) {
			String line = s.nextLine();
			list.add(Integer.parseInt(line.split(" ")[0]));
		}
		boolean can = fav > numPizzas || fav < 1? false : canGetFav(list, fav);
//		boolean can = canGetFav(list, fav);
		if (can) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static boolean canGetFav(List<Integer> list, int fav) {
		while (list.size() > 1) {
			if (fav-1 == list.size()-1) {
				return false;
			}
			if (list.size() == 2) {
				return true;
			}
			if (fav-1 == 0) {
				return false;
			} 
			list = list.subList(1, list.size()-1);
			fav--;
			if (list.size() == 2) {
//				if (fav == 2) {
//					return false;
//				}
				return true;
			}



			if (fav < list.size()/2) {
				list = list.subList(0, list.size()-1);
			} else {
				list = list.subList(1, list.size());
			}
			fav--;
		}
		return true;
	}
}
