package datastructure;

import java.util.Stack;

import common.TreeNode;
import tree.CreateBinaryTree;

public class BinaryTreeTraversal {

	/**
	 * 非递归DFS,其实就是先序遍历
	 */
	public static void depthFirstSearch(TreeNode root) {
		if (root == null)
			return;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode treeNode = stack.pop(); // 弹栈并打印
			System.out.print(" " + treeNode.data);
			
			if (treeNode.right != null) { // 右儿子先进栈
				stack.push(treeNode.right);
			}
			
			if (treeNode.left != null) {
				stack.push(treeNode.left);
			}
		}
	}
	
	/**
	 * 递归先序遍历，递归写法其余两种类似
	 */
	public static void preOrderTraversal(TreeNode treeNode) {
		if (treeNode != null) { // treeNode.data不会为0
			System.out.print(" " + treeNode.data);
			preOrderTraversal(treeNode.left);
			preOrderTraversal(treeNode.right);
		}
	}
	
	/**
	 * 非递归中序遍历
	 * 1.循环将当前结点和其左儿子压栈
	 * 2.直到没有左儿子，弹栈输出，并指向它的兄弟结点
	 */
	public static void inOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		
		TreeNode treeNode = root; // 指针
		Stack<TreeNode> stack = new Stack<>(); // 打印栈
		
		while (treeNode != null || !stack.isEmpty()) {
			while (treeNode != null) { // 进栈
				stack.push(treeNode);
				treeNode = treeNode.left;
			}
			
			if (!stack.isEmpty()) { // 输出最后一个左儿子，指针指向左儿子的兄弟结点，继续之前的操作
				treeNode = stack.pop();
				System.out.print(" " + treeNode.data);
				treeNode = treeNode.right;
			}
		}
	}

	/**
	 * 非递归后序遍历
	 * 1.循环将当前结点和其左儿子压栈，如果没有左儿子，指针指向右儿子，继续之前的操作
	 * 2.每当找不到左儿子就检查一次标识：如果一个结点的左右儿子都被访问过，那么就弹栈并打印
	 * 3.指针指向当前结点的右儿子,标识当前结点为已访问
	 */
	public static void postOrderTraversal(TreeNode root) {
		if (root == null)
			return;
		
		TreeNode treeNode = root;
		Stack<TreeNode> stack = new Stack<>(); // 打印栈
		Stack<Boolean> visited = new Stack<>(); // 对应打印栈里面的每个结点，标识当前结点的左右子结点是不是均被访问过
		
		while (treeNode != null || !stack.isEmpty()) {
			while (treeNode != null) { // 所有左儿子进栈
				stack.push(treeNode);
				visited.push(false); // 左儿子未访问过，标记为false
				treeNode = treeNode.left;
			}

			while (!stack.isEmpty() && visited.peek()) { // 检查标识
				System.out.print(" " + stack.pop().data);
				visited.pop();
			}

			if (!stack.isEmpty()) { // 指针指向当前结点的右儿子
				visited.pop();
				visited.push(true);
				treeNode = stack.peek().right;
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = CreateBinaryTree.createBinaryTree(0, new int[] { 1, 2, 3, 4, 5, 6, 7, 0, 9 }); // 0是空结点
		
		System.out.print("\nDFS:"); 
		depthFirstSearch(root); // 1 2 4 9 5 3 6 7
		
		System.out.print("\npreOrder:"); 
		preOrderTraversal(root); // 1 2 4 9 5 3 6 7 
		
		System.out.print("\ninOrder:");
		inOrderTraversal(root); // 4 9 2 5 1 6 3 7
		
		System.out.print("\npostOrder:");
		postOrderTraversal(root); // 9 4 5 2 6 7 3 1
		
	}
	
}
