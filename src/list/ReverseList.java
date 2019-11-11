package list;

import common.ListNode;

/**
 * @description 反转链表
 * @author Jeremy
 * @date 2019/08/17
 * 
 * 思路
 * 1.三个指针，指向当前、前驱、后继
 * 2.后继先走，前驱次之，当前最后
 * 
 * 输入：1->2->3->4->5->null
 * 返回：5->4->3->2->1->null
 */
public class ReverseList {

	public static ListNode reverse(ListNode head) {
		if (head == null) {
			return null;
		}
		
		// 前驱指针
		ListNode prev = null;
		// 后继指针
		ListNode next = null;
		// 当前结点
		ListNode cur = head;

		while (cur != null) {
			// 后继结点先走
			next = cur.next;
			// 重构关系，当前结点的指针调头
			cur.next = prev;
			// 前驱结点跟着走
			prev = cur;
			// 当前结点最后走
			cur = next;
		}
		return prev;
	}
	
	public static void main(String[] args) {
		ListNode node = new ListNode(new int[] { 1, 2, 3, 4, 5 });
		ListNode reverse = reverse(node);
		ListNode.display(reverse);
	}
	
}
