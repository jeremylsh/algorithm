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
				cur.next = prev; // maintain the relation
				prev = cur; // move to the next
				cur = next; // move to the next
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

	/*
	 * 
	 */
	public static ListNode getEntrance(ListNode node) {
		ListNode end = getEnd(node);
		if (node != null && end != null) {
			ListNode n1 = node;
			ListNode n2 = end;
			while (n1 != n2) {
				n1 = n1.next;
				n2 = n2.next;
			}
			return n1;
		}
		return null;
	}
	
	/*
	 * The fast moves two steps while the slow moves one step 
	 * each time. They will meet if the list is circular.
	 * Otherwise, the fast will arrive at null.
	 */
	public static ListNode getEnd(ListNode node) {
		if (node != null) {
			ListNode fast = node;
			ListNode slow = node;
			while (fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				slow = slow.next;
				if (fast == slow) {
					return fast;
				}
			}
		}
		return null;
	}
	
	public static void display(ListNode node) {
		while (node != null) {
			System.out.print(node.value + "->");
			node = node.next;
		}
		System.out.println("nil");
	}

	/*
	 * node3: 1 -> 2 -> 3 -> 4 -> 5 -> 6
	 *                  |______________|
	 */
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(1);
		
		node1.add(new ListNode(3)).add(new ListNode(5)).add(new ListNode(7)).add(new ListNode(9));
		node2.add(new ListNode(4)).add(new ListNode(6)).add(new ListNode(8));
		
		ListNode entrance = new ListNode(3);
		node3.add(new ListNode(2)).add(entrance).add(new ListNode(4)).add(new ListNode(5)).add(new ListNode(6))
				.add(entrance);
		
		ListNode node = merge(node1, node2);
		// 1->2->3->4->5->6->7->8->9->nil
		display(node);
		
		node = reverse(node);
		// 9->8->7->6->5->4->3->2->1->nil
		display(node);
		
		// the entrance is 3
		System.out.println(getEntrance(node3).value);
	}

}
