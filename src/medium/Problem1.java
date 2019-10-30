package medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 80
 * @author fy
 *
 */
class ListNode{
	int val;
	ListNode next;
	ListNode(int x){val = x;}
}

public class Problem1 {
	public static void main(String args[]){
		Solution s = new Solution();
		ListNode a1 = new ListNode(2);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(3);
		ListNode b1 = new ListNode(5);
		ListNode b2 = new ListNode(6);
		ListNode b3 = new ListNode(7);
		a1.next = a2;
		a2.next = a3;
		b1.next = b2;
		b2.next = b3;
		
		ListNode result = s.solution(a1, b1);
		for(ListNode i = result; i!=null;i=i.next){
			System.out.println(i.val);
		}
	}

}
	
class Solution{
	public ListNode solution(ListNode l1,ListNode l2){
		Queue<Integer> a = new LinkedList<Integer>();
		Queue<Integer> b = new LinkedList<Integer>();
		int advance = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		ListNode first = new ListNode(-1);
		ListNode next = first;
		
		for(ListNode i = l1;i != null; i=i.next){
			a.offer(i.val);
		}
		for(ListNode i = l2; i != null; i = i.next){
			b.offer(i.val);
		}
		
		int zero = a.size() - b.size();
		if(zero>0){
			for(int i=1;i<zero;i++){
				b.offer(0);
			}
		}
		if(zero<0){
			for(int i=1;i<(-zero);i++){
				a.offer(0);
			}
		}
		int len = a.size();
		for(int i=0;i<len;i++){
			int sum = a.poll() + b.poll() + advance;
			if(sum >= 10){
				advance = 1;
				sum = sum - 10;
			}else{
				advance  = 0;
			}
			q.offer(sum);
			if(i == len-1 && advance == 1){
				q.offer(advance);
			}
		}
		
		while(!q.isEmpty()){
			next.next = new ListNode(q.poll());
			next = next.next;
		}
		return first.next;
	}
}

