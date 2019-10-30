package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 * 
 * @author fy
 *
 */

public class ReverseInteger {

	public int reverse(int x) {
		if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE || x==0 || x==-0)
			return 0;
		
		String str = String.valueOf(x);
		
		List<String> listStr = new ArrayList<>(str.length());
		String result = "";
		int index = 0;
		
		if(x<0)
			result = "-";
		
		for(int i=0;i<str.length();i++){
			String num = str.substring(i,i+1);
			listStr.add(num);
		}
		listStr = reseve(listStr);
		index = firstNumNotZeroIndex(listStr);
		for(int i=index;i<listStr.size();i++){
			if(!listStr.get(i).equals("-"))
				result+=listStr.get(i);
			else
				result+="";
		}
		long ll = Long.valueOf(result);
		if(ll>Integer.MAX_VALUE || ll<Integer.MIN_VALUE)
			return 0;
		return Integer.valueOf(result);
	}
	
	private List<String> reseve(List<String> list){
		List<String> li = new ArrayList<String>();

		for (int i = list.size() - 1; i >= 0; i--) {
			li.add(list.get(i));
		}
		return li;
		
	}
	
	private int firstNumNotZeroIndex(List<String> list){
		int index = -1;
		boolean isFirst = false;
		for(String num : list){
			if(num.equals("0") && !isFirst){
				index++;
			}else{
				isFirst = true;
				break;
			}
		}
		if(isFirst)
			return index+1;
		return index+1;
	}
	
	public static void main(String[] args) {
		ReverseInteger ri = new ReverseInteger();
		
		System.out.println(ri.reverse(-102));
		System.out.println(ri.reverse(-100));
		System.out.println(ri.reverse(102));
		System.out.println(ri.reverse(02));
		System.out.println(ri.reverse(020));
		
	}
}
