package easy;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String[] strs){
		String common = "";
		if(strs.length == 0 || strs == null)
			return "";
		if(strs.length ==1)
			return strs[0];
		
		for(int i=0; i < strs[0].length(); i++)
		{
			String commPre = strs[0].substring(0, i+1);
			int count = 0;
			for(int j=1; j < strs.length; j++)
			{
				if(strs[j].indexOf(commPre) ==0)
				{
					count++;
				}
			}
			if(count == strs.length-1){
				common = commPre;
			}
			
		}
		return common;
	}
	
	/**
	 * 官方给出的一种解法
	 * @param strs
	 * @return
	 */
	
	public String longestCommonPrefix2(String[] strs){
		if(strs == null || strs.length == 0)
			return "";
		for(int i =0 ;i<strs[0].length(); i++)
		{
			char c = strs[0].charAt(i);
			for(int j = 1; j<strs.length; j++)
			{
				if(i == strs[j].length() || strs[j].charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}
	
	public static void main(String[] args) {
		LongestCommonPrefix lc = new LongestCommonPrefix();
		String [] strs = new String[]{"flower","flow","flight"};
		String [] strs2 = new String[]{"bsassv","bssc"};
		String [] strs3 = new String[]{""," "};
		String [] strs4 = new String[]{"a"};
		String [] strs5 = new String[]{"ab","ab"};
		String [] strs6 = new String[]{"baab","ab"};
		System.out.println(strs+":"+lc.longestCommonPrefix(strs));
		System.out.println(strs2+":"+lc.longestCommonPrefix(strs2));
		System.out.println(strs3+":"+lc.longestCommonPrefix(strs3));
		System.out.println(strs4+":"+lc.longestCommonPrefix(strs4));
		System.out.println(strs5+":"+lc.longestCommonPrefix(strs5));
		System.out.println(strs6+":"+lc.longestCommonPrefix(strs6));
	}
}
