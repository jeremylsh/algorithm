package list;

import common.ListNode;

/**
 * @description 合并两个有序链表
 * @author Jeremy
 * @date 2019/08/17
 * 
 * 思路：递归
 * 
 * 输入：1->3->5->7->9->null,2->4->6->8->null 
 * 输出：1->2->3->4->5->6->7->8->9->null
 */
public class MergeTwoSortedList {

	public static ListNode merge(ListNode node1, ListNode node2) {
		// 其中一边为空，直接返回另一边
		if (node1 == null) return node2;
		if (node2 == null) return node1;
		
		// 后继结点指向递归的结果，返回当前结点
		ListNode cur = null;
		if (node1.value <= node2.value) {
			cur = node1;
			cur.next = merge(node1.next, node2);
		} else {
			cur = node2;
			cur.next = merge(node1, node2.next);
		}
		return cur;
	}
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(new int[] { 1, 3, 5, 7, 9 });
		ListNode node2 = new ListNode(new int[] { 2, 4, 6, 8 });
		ListNode merge = merge(node1, node2);
		ListNode.display(merge);
	}
	
}
