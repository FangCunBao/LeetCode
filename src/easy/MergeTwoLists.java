package easy;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * @author fy
 *关键点：
 *	1、虚拟的头结点，便于返回头结点以及防止使用空指针。
 *	2、遍历节点的方式：当前节点不是null，指向当前节点的的指针被赋予下一个节点的指针
 *	3、当前节点：临时用于保存两条链上的节点指针，用于连接节点。是新链上的最后一个节点
 */


public class MergeTwoLists {
	
	private class ListNode
	{
		int val;
		ListNode next;
		ListNode(int x){val = x;}
	}
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null && l2 != null)
			return l2;
		if(l2 == null && l1 != null)
			return l1;
		
		ListNode head = null;
		ListNode current = new ListNode(Integer.MIN_VALUE);
		head = current;
		while(l1 != null && l2 != null)
		{
			if(l1.val < l2.val)
			{
				current.next = l1;
				l1 = l1.next;
			}else if(l1.val > l2.val)
			{
				current.next = l2;
				l2 = l2.next;
			}else if(l1.val == l2.val)
			{
				current.next = l1;
				l1 = l1.next;
				current.next.next = l2;
				l2 = l2.next;
				current = current.next.next;
				continue;
			}
			current = current.next;
		}
		if(l1 == null)
			current.next = l2;
		if(l2 == null)
			current.next = l1;
		
		return head.next;
	}
}
