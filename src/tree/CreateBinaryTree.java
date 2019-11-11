package tree;

import common.TreeNode;

/**
 * @description TODO
 * @author Jeremy
 * @date 2019/08/18
 */
public class CreateBinaryTree {

	/**
	 * 递归构建二叉树
	 */
	public static TreeNode createBinaryTree(int parentIndex, int[] datas) {
		if (datas != null && parentIndex < datas.length) {
			if (datas[parentIndex] != 0) { // 0表示空结点
				TreeNode treeNode = new TreeNode(datas[parentIndex]);
				treeNode.left = createBinaryTree((parentIndex << 1) + 1, datas); // 位移优先级较低，注意加括号
				treeNode.right = createBinaryTree((parentIndex << 1) + 2, datas);
				return treeNode;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		BFS.breadthFirstSearch(createBinaryTree(0, new int[] {1,2,3,4,5,6,7,8}));
	}
	
}
