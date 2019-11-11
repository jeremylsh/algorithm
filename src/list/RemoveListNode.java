package list;

import common.ListNode;

/**
 * @description 删除链表指定结点
 * @author Jeremy
 * @date 2019/08/17
 * 
 * 思路： 
 * 1.所谓删除，其实就是把删除点后面的所有结点都前移 
 * 2.要考虑边界情况：删除的点是不是尾结点？
 */
public class RemoveListNode {

	public static void remove(ListNode head, ListNode delNode) {
		if (head == null || delNode == null) {
			return;
		}

		// 1.删除的不是尾结点，删除点后面的结点直接全部前移
		if (delNode.next != null) {
			delNode.value = delNode.next.value;
			delNode.next = delNode.next.next;
		}
		// 2.有且只有一个结点
		else if (delNode == head) {
			head = null;
		}
		// 3.链表多结点，并且删除尾结点，需要找到倒数第二个结点，把它指向null
		else {
			ListNode node = head;
			while (node.next != delNode) {
				node = node.next;
			}
			node.next = null;
		}
	}

	public static void main(String[] args) {
		ListNode first = new ListNode(1);
		ListNode mid = new ListNode(3);
		ListNode last = new ListNode(5);
		first.add(new ListNode(2)).add(mid).add(new ListNode(4)).add(last);

		remove(first, first);
		remove(first, mid);
		remove(first, last);
		ListNode.display(first);
	}

}
