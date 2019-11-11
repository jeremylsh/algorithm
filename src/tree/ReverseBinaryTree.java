package tree;

import java.util.Vector;

import common.TreeNode;

/**
 * @description 反转二叉树
 * @author Jeremy
 * @date 2019/08/18
 */
public class ReverseBinaryTree {

	/**
	 * 反转二叉树,其实就是广度优先遍历
	 */
	public static void reverse(TreeNode root) {
		if (root == null)
			return;

		Vector<TreeNode> vector = new Vector<>();
		vector.add(root);

		while (!vector.isEmpty()) {
			TreeNode treeNode = vector.remove(0);
			System.out.print(" " + treeNode.data);

			TreeNode temp = treeNode.left; // 使用临时变量来交换左右子结点
			treeNode.left = treeNode.right;
			treeNode.right = temp;

			if (treeNode.left != null)
				vector.add(treeNode.left);
			
			if (treeNode.right != null)
				vector.add(treeNode.right);
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = CreateBinaryTree.createBinaryTree(0, new int[] { 1, 2, 3, 4, 5, 6, 7, 0, 9 }); // 0是空结点
		System.out.print("\nreverse:");
		reverse(root); // 1 3 2 7 6 5 4 9
	}
	
}
