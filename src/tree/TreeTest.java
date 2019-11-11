package tree;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @description TODO
 * @author Jeremy
 * @date 2019/08/30
 */
public class TreeTest {

	public static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
		}

		public static Node create(int[] a, int parentIndex) {
			if (a == null || a.length == 0 || parentIndex > a.length - 1 || a[parentIndex] == 0) {
				return null;
			}
			Node parent = new Node(a[parentIndex]);
			parent.left = create(a, parentIndex * 2 + 1);
			parent.right = create(a, parentIndex * 2 + 2);
			return parent;
		}

	}

	public static void bfs(Node node) {
		if (node == null) {
			return;
		}

		LinkedBlockingQueue<Node> queue = new LinkedBlockingQueue<>();
		queue.offer(node);

		while (queue.size() > 0) {
			Node n = queue.poll();
			System.out.print(n.value + " ");
			if (n.left != null) {
				queue.offer(n.left);
			}

			if (n.right != null) {
				queue.offer(n.right);
			}
		}

	}

	public static void main(String[] args) {
		Node root = Node.create(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }, 0);
		bfs(root);
	}

}
