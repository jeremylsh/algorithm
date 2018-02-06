package dataStructure;

import common.ListNode;

public class ListOperation {

	/**
	 * 反转链表
	 */
	public static ListNode reverse(ListNode head) {
		if (head != null) {
			ListNode prev = null;
			ListNode next = null;
			ListNode cur = head;
			
			while (cur != null) {
				next = cur.next; // 先保存下一个移动目标
				cur.next = prev; // 维护重建后的关系
				prev = cur; // prev移动
				cur = next; // cur移动
			}
			return prev;
		}
		return null;
	}
	
	/**
	 * 合并2个有序链表
	 */
	public static ListNode merge(ListNode node1, ListNode node2) {
		ListNode node = null;
		if (node1 == null)
			return node2;
		if (node2 == null)
			return node1;
		if (node1.value <= node2.value) {
			node = node1;
			node.next = merge(node1.next, node2);
		} else {
			node = node2;
			node.next = merge(node1, node2.next);
		}
		return node;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		
		node1.add(new ListNode(3))
			 .add(new ListNode(5))
			 .add(new ListNode(7))
			 .add(new ListNode(9));

		node2.add(new ListNode(4))
			 .add(new ListNode(6))
		     .add(new ListNode(8));
		
		ListNode node = merge(node1, node2);
		ListNode.display(node); // 1->2->3->4->5->6->7->8->9->nil
		
		node = reverse(node);
		ListNode.display(node); // 9->8->7->6->5->4->3->2->1->nil
	}
	
}
