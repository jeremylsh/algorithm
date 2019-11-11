package tree;

import java.util.Vector;

import common.TreeNode;

/**
 * @description TODO
 * @author Jeremy
 * @date 2019/08/25
 */
public class BFS {

	/**
	 * 非递归 BFS
	 */
	public static void breadthFirstSearch(TreeNode root) {
		if (root == null) 
			return;

		Vector<TreeNode> vector = new Vector<>();
		vector.add(root);

		while (!vector.isEmpty()) {
			TreeNode treeNode = vector.remove(0); // 出队列并输出
			System.out.print(" " + treeNode.data); 
			
			if (treeNode.left != null) {
				vector.add(treeNode.left);
			}
			if (treeNode.right != null) {
				vector.add(treeNode.right);
			}
		}
	}
	
	public static void main(String[] args) {
		TreeNode root = CreateBinaryTree.createBinaryTree(0, new int[] { 1, 2, 3, 4, 5, 6, 7, 0, 9 }); // 0是空结点
		System.out.print("BFS:"); 
		breadthFirstSearch(root); // 1 2 3 4 5 6 7 9
	}
	
}
