package list;

import common.ListNode;

/**
 * @description 链表每K个结点进行反转
 * @author Jeremy
 * @date 2019/08/27
 * 
 * 1.如果最后一组不足K个也要反转
 * 链表 1->2->3->4->5
 * 输入：k=3
 * 输出:3->2->1->4->5
 * 
 * 2.如果最后一组不足K个不反转
 * 链表 1->2->3->4->5
 * 输入：k=3
 * 输出:3->2->1->5->4
 * 
 */
public class ReverseNodeInKGroup {

	/**
	 * 反转链表，并把k组最后一个结点指向下一个k组的头结点
	 * 传入:1->2->3->4
	 * 传出:1<-2<-3  4
	 * 	   |________|
	 * 函数返回:3
	 */
	private static ListNode reverse(ListNode head, ListNode nextHead) {
		ListNode newHead = nextHead;
		while (head != nextHead) {
			ListNode next = head.next;
			head.next = newHead;
			newHead = head;
			head = next;
		}
		return newHead;
	}
	
	/**
	 * 解法一，递归
	 * 最后一组不足k个要不要反转，区别在于最后一组直接return head还是再调一次递归函数
	 */
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k < 2) {
			return head;
		}
		
		ListNode cur = head;
		for (int i = 0; i < k; i++) {
			if (cur == null) {
				// 如果最后一组也要反转，这里return reverse(head,cur)即可
				return head;
			}
			cur = cur.next;
		}
		
		// 得到k组的头结点
		ListNode newHead = reverse(head, cur);
		// 递归，当前k组的尾结点指向下一个k组的头结点
		head.next = reverseKGroup(cur, k);
		return newHead;
	}
	
	
	/**
	 * 解法二，非递归：最后一组不足k个，也要反转
	 */
	public static ListNode reverseKGroup2(ListNode head, int k) {
		if (head == null || k < 2) {
			return head;
		}
		
		ListNode newHead = null;
		ListNode newTail = null;
		ListNode cur = head;
		
		// 遍历整个链表
		while (cur != null) {
			// 每一组的调整操作
			ListNode groupHead = null;
			ListNode groupTail = cur;
			int count = k;
			while (cur != null && count > 0) {
				ListNode pre = groupHead;
				groupHead = cur;
				cur = cur.next;
				groupHead.next = pre;
				count--;
			}
			
			// 调整完一组后，找到新链表的头尾
			if (newHead == null) {
				newHead = groupHead;
			} else {
				newTail.next = groupHead;
			}
			newTail = groupTail;
		}
		
		return newHead;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.add(new ListNode(2))
			.add(new ListNode(3))
			.add(new ListNode(4))
			.add(new ListNode(5))
			.add(new ListNode(6))
			.add(new ListNode(7))
			.add(new ListNode(8))
			;
		
//		ListNode result = reverseIncludeLast(head, 2);
		ListNode result = reverseKGroup(head, 3);
		ListNode.display(result);
	}
	
}
