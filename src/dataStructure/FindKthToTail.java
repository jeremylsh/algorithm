package dataStructure;

import common.ListNode;

/**
 * 寻找链表中的倒数第k个结点
 */
public class FindKthToTail {

	/**
	 * first指针先走k-1步，然后两个指针开始一起走，当first走到尾部，last就到了倒数第k个结点
	 * 需要先判断链表够不够长，即结点数要大于k-1
	 */
	public static ListNode findKthToTail(ListNode head, int k) {
		if (head == null || k <= 0)
			return null;
		
		ListNode first = head;
		ListNode last = head;
		
		for (int i = 0; i < k - 1; i++) {
			 if (first.next != null) {
				 first = first.next;
			 } else {
				 return null; // 链表结点数小于k
			 }
		}
		
		while (first.next != null) {
			first = first.next;
			last = last.next;
		}
		
		return last;
	}
	
	public static void main(String[] args) {
		int k = 3;
		ListNode node = new ListNode(1);
		node.add(new ListNode(2)).
			 add(new ListNode(3)).
			 add(new ListNode(4)).
			 add(new ListNode(5)).
			 add(new ListNode(6));
		
		ListNode ln = findKthToTail(node, k);
		if (ln != null) {
			System.out.println(ln.value); // 4
		}
	}
	
}
