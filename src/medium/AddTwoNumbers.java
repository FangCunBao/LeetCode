package medium;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * 
 * 示例：
 * 
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author fy
 *
 */
public class AddTwoNumbers {

	public class ListNode{
		int val;
		ListNode next;
		ListNode(int v){ val = v;}
	}
	
	public ListNode addTwoNumber(ListNode l1,ListNode l2)
	{
		int jin = 0;
		
		if(l1 == null && l2 == null)
			return null;
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		
		ListNode head = new ListNode(0);
		ListNode current = head;
		ListNode l1c = l1;
		ListNode l2c = l2;
		while(l1c != null)
		{
			if(l2c != null)
			{
				int temp = l1c.val + l2c.val + jin ;
				current.next = new ListNode(temp%10);
				current = current.next;
				if(temp >= 10)
					jin = 1;
				else
					jin = 0;
				l1c = l1c.next;
				l2c = l2c.next;
			}else
			{
				int temp = l1c.val + jin ;
				current.next = new ListNode(temp%10);
				current = current.next;
				if(temp >= 10)
					jin = 1;
				else
					jin = 0;
				l1c = l1c.next;
			}
		}
		
		while(l2c != null)
		{
			int temp = l2c.val + jin ;
			current.next = new ListNode(temp%10);
			current = current.next;
			if(temp >= 10)
				jin = 1;
			else
				jin = 0;
			l2c = l2c.next;
		}
		
		if(jin == 1)
			current.next = new ListNode(jin);
		
		return head.next;
	}
}
