package common;

/**
 * 链表结点
 */
public class ListNode {

	public int value;
	public ListNode next;
	
	public ListNode(int value) {
		this.value = value;
	}
	
	public ListNode add(ListNode node) {
		this.next = node;
		return node;
	}
	
	/**
	 * 数组转链表
	 */
	public ListNode(int[] values) {
		if (values == null || values.length == 0) {
			return;
		}
		
		ListNode cur = this;
		for (int i = 0; i < values.length; i++) {
			cur.value = values[i];
			// 创建下一个结点
			if (i + 1 < values.length) {
				cur.next = new ListNode(values[i + 1]);
			}
			cur = cur.next;
		}
	}
	
	/**
	 * 打印链表
	 */
	public static void display(ListNode node) {
		while (node != null) {
			System.out.print(node.value + "->");
			node = node.next;
		}
		System.out.println("null");
	}
	
}
