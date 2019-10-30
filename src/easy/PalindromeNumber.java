package easy;

/**
 * 判断一个数是否是回文数
 * 121，121
 * -121，121--->不是
 * @author fy
 *
 */

public class PalindromeNumber {

	public boolean isPalindrome(int x) {	
		boolean is = false;
		if(x<0)
			return false;
		StringBuffer num = new StringBuffer(String.valueOf(x));
		String renum = new String(num);
		num = num.reverse();
		if(num.toString().equals(renum))
			is = true;
		return is;
	}
	
	public static void main(String[] args) {
		PalindromeNumber p = new PalindromeNumber();
		System.out.println(p.isPalindrome(0));
	}
	
}
