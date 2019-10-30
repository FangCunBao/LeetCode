package easy;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 
 * 有效字符串需满足：
 * 
 * 左括号必须用相同类型的右括号闭合。 左括号必须以正确的顺序闭合。 注意空字符串可被认为是有效字符串。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author fy
 *
 */
public class ValidParenthese {

	/**
	 * 思路：
	 * 使用栈作为数据结构，先在栈中放入一个字符防止读取空栈
	 * 将首个字符放入栈中；
	 * 从下一个字符开始遍历，将下个字符与栈顶元素比较
	 * 		若匹配或者字符为空则弹出栈
	 * 		否则压入栈
	 * 若栈中元素为1个，则表示匹配，否则不匹配
	 * @param s
	 * @return
	 */
	public boolean isValid(String s)
	{
		if(s.equals("") || s.equals(" "))
			return true;
		if(s.length()==1)
			return false;
		Stack<String> st = new Stack<>();
		st.push("O");
		st.push(s.substring(0, 1));
		for (int i = 1; i < s.length(); i++) {
			String p = s.substring(i, i+1);
			
			if(p.equals(")") && st.peek().equals("("))
			{
				st.pop();
				continue;
			}
			else if(p.equals("]") && st.peek().equals("["))
			{
				st.pop();
				continue;
			}
			else if(p.equals("}") && st.peek().equals("{"))
			{
				st.pop();
				continue;
			}
			else if(p.equals("") || p.equals(" "))
			{
				continue;
			}
			else{
				st.push(p);
			}
		}
		
		return st.size()==1;
	}
	
	public static void main(String[] args) {
		ValidParenthese vp = new ValidParenthese();
		System.out.println(vp.isValid("()"));
		System.out.println(vp.isValid("()[]{}"));
		System.out.println(vp.isValid("(]"));
		System.out.println(vp.isValid("([)]"));
		System.out.println(vp.isValid("{[]}"));
		System.out.println(vp.isValid("()][]{}"));
	}
}
