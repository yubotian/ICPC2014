package APT201;

import java.util.*;

public class Dirsort {
	public String[] sort(String[] dirs) {
		List<dir> list = new ArrayList<dir>();
		for(String s: dirs)
			list.add(new dir(s));    
		Collections.sort(list);
		String[] answer = new String[dirs.length];
		for(int i=0;i<dirs.length;i++)
			answer[i] = list.get(i).toString();
		return answer;
	}
	
	public class dir implements Comparable<dir>{
		String a;
		Integer n;
		String[] s;
		
		public dir(String A){
			a = A;
			s = A.split("/");
			n = s.length;
		}
		
		public String toString(){
			return a;
		}
		
		public int compareTo(dir arg0) {
			int a = (this.n).compareTo(arg0.n);
			if(a!=0)
			    return a;
			else{
				for(int i=0;i<n;i++){
					int b = (this.s[i]).compareTo(arg0.s[i]);
					if(b!=0)
						return b;
				}
			}	
			return 0;
		}
    }
}