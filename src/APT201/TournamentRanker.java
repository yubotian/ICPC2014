package APT201;

import java.util.*;


public class TournamentRanker {
	public String[] rankTeams(String[] names, String[] lostTo) {
	HashMap<String,Integer> Round = new HashMap<String,Integer>();
	for(String s: lostTo){
		if(!Round.containsKey(s))
			Round.put(s,0);
		Round.put(s,Round.get(s)+1);
	}
	for(String s: names){
		if(!Round.containsKey(s))
			Round.put(s, 0);
	}
	HashMap<String,ArrayList<String>> winOver = new HashMap<String,ArrayList<String>>();
	

       for(int i=0;i<lostTo.length;i++){
		if(!winOver.containsKey(lostTo[i]))
			winOver.put(lostTo[i],new ArrayList<String>());
		winOver.get(lostTo[i]).add(names[i]);
	}
	String champion = winOver.get("").get(0);
	int round = Round.get(champion);
	ArrayList<String> team = new ArrayList<String>();
	ArrayList<String> temp = new ArrayList<String>();
	team.add(champion);
	while(round>0){
		for(String w: team){
			for(String l: winOver.get(w)){
				if(Round.get(l)==round-1)
					temp.add(l);
			}
		}
		team.addAll(temp);
		temp.clear();
		round--;
	}
	String[] answer = new String[names.length];
	for(int i=0;i<names.length;i++)
		answer[i] = team.get(i);
	return answer;
	}
	
	public static void main(String[] args){
		l		String[] names = {"RODDICK", "SCHUETTLER", "FERREIRA", "AGASSI" };
		String[] lostTo = {"SCHUETTLER", "AGASSI", "AGASSI", "" };
		String[] rT = TR.rankTeams(names, lostTo);
		System.out.println(rT);
	}
}
