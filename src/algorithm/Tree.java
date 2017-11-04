package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

/*
 * recursive/non-recursive:
 * 1.createBinaryTree
 * 2.BFS
 * 3.DFS(same as preOrder)
 * 4.reverse
 * 5.preOrder
 * 6.inOrder
 * 7.postOrder
 */
public class Tree {

	TreeNode root;
	// used to create
	List<TreeNode> nodeList = new ArrayList<>();

	static class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;

		TreeNode(int data) {
			this.data = data;
		}
	}

	/*
	 * recursive
	 */
	public TreeNode createBinaryTree(int parentIndex, int[] datas) {
		if (datas != null && parentIndex < datas.length) {
			// 0 means empty node
			if (datas[parentIndex] != 0) {
				TreeNode treeNode = new TreeNode(datas[parentIndex]);
				treeNode.left = createBinaryTree((parentIndex << 1) + 1, datas);
				treeNode.right = createBinaryTree((parentIndex << 1) + 2, datas);
				return treeNode;
			}
		}
		return null;
	}

	/*
	 * non-recursive BFS, use Vector
	 */
	public void breadthFirstSearch() {
		if (root == null) {
			return;
		}

		Vector<TreeNode> vector = new Vector<>();
		vector.add(root);

		while (!vector.isEmpty()) {
			TreeNode treeNode = vector.remove(0);
			System.out.print(treeNode.data + " ");
			if (treeNode.left != null) {
				vector.add(treeNode.left);
			}
			if (treeNode.right != null) {
				vector.add(treeNode.right);
			}
		}
	}

	/*
	 * non-recursive DFS, use Stack
	 */
	public void depthFirstSearch() {
		if (root == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode treeNode = stack.pop();
			System.out.print(treeNode.data + " ");
			// push right first
			if (treeNode.right != null) {
				stack.push(treeNode.right);
			}
			if (treeNode.left != null) {
				stack.push(treeNode.left);
			}
		}
	}

	/*
	 * recursive, preOrder
	 */
	public void preOrderSearch(TreeNode treeNode) {
		if (treeNode != null && treeNode.data != 0) {
			System.out.print(treeNode.data + " ");
			preOrderSearch(treeNode.left);
			preOrderSearch(treeNode.right);
		}
	}

	/*
	 * non-recursive, inOrder
	 */
	public void inOrderSearch() {
		if (root != null) {
			TreeNode treeNode = root;
			Stack<TreeNode> stack = new Stack<>();
			while (treeNode != null || !stack.isEmpty()) {
				// push until no left child
				while (treeNode != null) {
					stack.push(treeNode);
					treeNode = treeNode.left;
				}
				// print the last left child, then point to its sibling
				if (!stack.isEmpty()) {
					treeNode = stack.pop();
					System.out.print(treeNode.data + " ");
					treeNode = treeNode.right;
				}
			}
		}
	}

	/*
	 * non-recursive, postOrder
	 * 1.push until no left child, then point to its right child
	 * 2.if left & right children are visited, pop & print
	 */
	public void postOrderSearch() {
		if (root != null) {
			TreeNode treeNode = root;
			Stack<TreeNode> stack = new Stack<>();
			// check if current node is visited
			Stack<Boolean> visited = new Stack<>();
			while (treeNode != null || !stack.isEmpty()) {
				//push until no left child
				while (treeNode != null) {
					stack.push(treeNode);
					visited.push(false);
					treeNode = treeNode.left;
				}

				// pop & print
				while (!stack.isEmpty() && visited.peek()) {
					System.out.print(stack.pop().data + " ");
					visited.pop();
				}
				
				// visit the root, and point to its right child
				if (!stack.isEmpty()) {
					visited.pop();
					visited.push(true);
					treeNode = stack.peek().right;
				}
			}
		}
	}

	/*
	 * same as BFS
	 */
	public void reverse() {
		if (root == null) {
			return;
		}

		Vector<TreeNode> vector = new Vector<>();
		vector.add(root);

		while (!vector.isEmpty()) {
			TreeNode treeNode = vector.remove(0);
			System.out.print(treeNode.data + " ");

			// use a temp node to swap
			TreeNode temp = treeNode.left;
			treeNode.left = treeNode.right;
			treeNode.right = temp;

			if (treeNode.left != null) {
				vector.add(treeNode.left);
			}
			if (treeNode.right != null) {
				vector.add(treeNode.right);
			}
		}
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.root = tree.createBinaryTree(0, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });

		System.out.print("BFS : ");
		tree.breadthFirstSearch();

		System.out.println();
		System.out.print("DFS : ");
		tree.depthFirstSearch();

		System.out.println();
		System.out.print("preOrder : ");
		tree.preOrderSearch(tree.root);

		System.out.println();
		System.out.print("inOrder : ");
		tree.inOrderSearch();

		System.out.println();
		System.out.print("postOrder : ");
		tree.postOrderSearch();

		System.out.println();
		System.out.print("reverse : ");
		tree.reverse();
	}

}
