package easy;

public class StrStr {
	public int strStr(String haystack, String needle) {
		
		int index = -1;
		int j = needle.length();
		if(needle.equals(" ") || needle.equals(""))
			return index;
		if(needle.length() > haystack.length())
			return index;
		
		for(int i=0; i<=(haystack.length()-j);i++)
		{
			String str = haystack.substring(i, i+j);
			System.out.println(str);
			if(str.equals(needle))
			{
				index = i;
				break;
			}
				
		}
		return index;
	}
	
	public static void main(String[] args) {
		StrStr s = new StrStr();
		int index = s.strStr("a", "a");
		System.out.println(index);
	}
}
