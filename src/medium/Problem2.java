package medium;

class Soultion{
	
	
	public int solution(String s){
		int maxLength = 1;
		if(s.equals("")){
			return 0;
		}
		for(int i=0;i<s.length()-1;i++){
			int temp = 1;
			for(int j = i+1;j<s.length();j++){
				String sonOfIn = s.substring(i, j);
				String nextString = s.substring(j,j+1);
				if(isContaint(sonOfIn,nextString)){
					temp = sonOfIn.length();
					break;
				}else{
					temp++;
				}
			}
			if(maxLength < temp)
				maxLength = temp;
		}
		return maxLength;
	}
	
	private boolean isContaint(String s,String c){
		if(s.indexOf(c)>=0)
			return true;
		else
			return false;
	}
}

public class Problem2 {
	public static void main(String args[]){
		Soultion st = new Soultion();
		//System.out.println(st.solution("abcabcbb"));
		//System.out.println(st.solution("bbbbbb"));
		System.out.println(st.solution(" s "));
	}
	
}
