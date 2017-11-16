package algorithm;

public class ListNode {

	ListNode next;
	int value;

	public ListNode(int value) {
		this.value = value;
	}

	/*
	 * create a linked list
	 */
	public ListNode add(ListNode node) {
		next = node;
		return node;
	}

	public static ListNode reverse(ListNode head) {
		if (head != null) {
			ListNode prev = null;
			ListNode next = null;
			ListNode cur = head;
			
			while (cur != null) {
				next = cur.next; // save the next node
				cur.next = prev; // reset
				prev = cur;
				cur = next;
			}
			return prev;
		}
		return null;
	}

	/*
	 * merge two ordered linked list
	 */
	public static ListNode merge(ListNode node1, ListNode node2) {
		ListNode node = null;
		if (node1 == null)
			return node2;
		if (node2 == null)
			return node1;
		if (node1.value <= node2.value) {
			node = node1;
			// compare the next two nodes
			node.next = merge(node1.next, node2);
		} else {
			node = node2;
			node.next = merge(node1, node2.next);
		}
		return node;
	}

	public static void display(ListNode node) {
		while (node != null) {
			System.out.print(node.value + "->");
			node = node.next;
		}
		System.out.println("nil");
	}

	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		node1.add(new ListNode(3)).add(new ListNode(5)).add(new ListNode(7)).add(new ListNode(9));
		node2.add(new ListNode(4)).add(new ListNode(6)).add(new ListNode(8));
		
		ListNode node = merge(node1, node2);
		// 1->2->3->4->5->6->7->8->9->nil
		display(node);
		
		node = reverse(node);
		// 9->8->7->6->5->4->3->2->1->nil
		display(node);
	}

}
