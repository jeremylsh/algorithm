package tree;

import java.util.Stack;
import java.util.Vector;

import common.TreeNode;

/**
 * @description 之字打印二叉树
 * @author Jeremy
 * @date 2019/09/05
 * 
 * 输入：二叉树
 *     1
 * 	 2   3
 * 	4 0 5 6 
 * 7 8
 * 输出：
 * 1 
 * 3 2 
 * 4 5 6 
 * 7 8
 */
public class PrintZhiTree {

	public static void printZhiTree(TreeNode root) {
		Stack<TreeNode> stack1 = new Stack<>();
		Stack<TreeNode> stack2 = new Stack<>();
		stack1.add(root);
		
		while (!stack1.isEmpty() || !stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				TreeNode node = stack1.pop();
				System.out.print(node.data+" ");
				if (node.left != null) {
					stack2.push(node.left);
				}
				if (node.right != null) {
					stack2.push(node.right);
				}
			}
			System.out.println();
			
			while(!stack2.isEmpty()) {
				TreeNode node = stack2.pop();
				System.out.print(node.data+" ");
				if (node.right != null) {
					stack1.push(node.right);
				}
				if (node.left != null) {
					stack1.push(node.left);
				}
			}
			System.out.println();
		}
	}
	
	/**
	 * 类似题目：按层打印二叉树
	 */
	public static void printLine(TreeNode root) {
		Vector<TreeNode> v1 = new Vector<>();
		Vector<TreeNode> v2 = new Vector<>();
		v1.add(root);
		
		while (!v1.isEmpty() || !v2.isEmpty()) {
			while (!v1.isEmpty()) {
				TreeNode n = v1.remove(0);
				System.out.print(n.data + " ");
				if (n.left != null) {
					v2.add(n.left);
				}
				if (n.right != null) {
					v2.add(n.right);
				}
			}
			System.out.println();
			while (!v2.isEmpty()) {
				TreeNode n = v2.remove(0);
				System.out.print(n.data + " ");
				if (n.left != null) {
					v1.add(n.left);
				}
				if (n.right != null) {
					v1.add(n.right);
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = CreateBinaryTree.createBinaryTree(0, new int[] {1,2,3,4,0,5,6,7,8});
		printZhiTree(root);
		printLine(root);
	}
}
