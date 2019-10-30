package easy;

/**
 * 返回最后一个单词的长度
 * @author fy
 *
 */
public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		
        s = s.trim();
        return s.length() - s.lastIndexOf(" ") - 1;
    }
	
	public static void main(String[] args) {
		String a = "1";
		String b = "1";
		
		System.out.println(a);
	}
}
