package tree;

import common.TreeNode;

/**
 * @description 求树的最大深度
 * @author Jeremy
 * @date 2019/08/23
 * 
 * 思路：递归，每个结点的最大深度与它左右子结点最大深度相关
 * 
 * 输入：tree{1,2,3,4,5,6,7,8}
 * 输出：4
 */
public class TreeDepth {

	public static int treeDepth(TreeNode node) {
		if (node == null) {
			return 0;
		}
		
		int leftDepth = treeDepth(node.left);
		int rightDepth = treeDepth(node.right);
		
		return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
	}
	
	public static void main(String[] args) {
		TreeNode node = CreateBinaryTree.createBinaryTree(0, new int[] {1,2,3,4,5,6,7,8}); //4
		System.out.println(treeDepth(node));
	}
	
}
