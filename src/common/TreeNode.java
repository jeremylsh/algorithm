package common;

/**
 * 公用二叉树，所有属性方法对外可见
 */
public class TreeNode {

	public int data;
	
	public TreeNode left;
	
	public TreeNode right;
	
	TreeNode(int data) {
		this.data = data;
	}
	
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
	
	/**
	 * 非递归太丑陋了就不写了。。
	 */
	public TreeNode createBinaryTree() {
		return null;
	}
	
}
