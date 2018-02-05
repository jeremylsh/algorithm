package common;

/**
 * 公用链表，所有属性方法对外可见
 */
public class ListNode {

	public int value; // 0代表结点为空
	
	public ListNode next;
	
	public ListNode(int value) {
		this.value = value;
	}
	
	/**
	 * 链式添加结点，方便测试
	 */
	public ListNode add(ListNode node) {
		return next = node;
	}
	
	/**
	 * 遍历打印链表结点
	 */
	public static void display(ListNode node) {
		while (node != null) {
			System.out.print(node.value + "->");
			node = node.next;
		}
		System.out.println("nil");
	}
	
}
