package dataStructure;

import java.util.Stack;

/**
 * 用两个栈实现队列 
 * 1.stack1将入队的元素缓存起来，stack2存将要出队的元素
 * 2.出队只需要将stack2弹出，负负得正
 * 3.如果弹栈的时候stack2是空的，就把stack1全部压入stack2中
 */
public class TwoStackQueue {

	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();
	
	/**
	 * 入队
	 */
	public void put(Integer i) {
		stack1.push(i);
	}

	/**
	 * 出队
	 */
	public Integer offer() {
		if (!stack2.isEmpty()) {
			return stack2.pop();
		}
		
		while (!stack1.isEmpty()) { // stack1全部压入stack2
			stack2.push(stack1.pop());
		}
		
		return stack2.pop();
	}
	
	public static void main(String[] args) {
		TwoStackQueue queue = new TwoStackQueue();
		queue.put(1);
		System.out.println(queue.offer()); // 1
		queue.put(2);
		queue.put(3);
		System.out.println(queue.offer()); // 2
		System.out.println(queue.offer()); // 3
	}
	
}
