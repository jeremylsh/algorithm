package list;

import common.ListNode;

/**
 * 寻找链表中的倒数第k个结点
 * 
 * 链表
 * 1->2->3->4->5->6->null
 * 
 * 输入：k=3
 * 输出：结点4
 * 
 * 思路
 * 1.first指针先走k-1步，然后两个指针开始一起走，当first走到尾部，last就到了倒数第k个结点
 * 2.边界条件，需要先判断链表够不够长，即结点数要大于k-1
 */
public class FindKthToTail {

	public static ListNode findKthToTail(ListNode head, int k) {
		if (head == null || k <= 0) {
			return null;
		}
		
		ListNode first = head;
		ListNode last = head;
		
		for (int i = 0; i < k - 1; i++) {
			 // 链表结点数小于k
			 if (first.next == null) {
				 return null;
			 } else {
				 first = first.next;
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
		ListNode node = new ListNode(new int[] { 1, 2, 3, 4, 5, 6 });

		ListNode ln = findKthToTail(node, k);
		System.out.println(ln.value); // 4
	}

}
