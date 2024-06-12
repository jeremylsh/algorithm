package datastructure;

/**
 * 输入一个数组，判断是否是一颗BST的后序遍历序列
 * @author Jeremy
 */
public class BST {

	/**
	 * 右子树任意一个结点都比整颗左子树和根大，
	 * 最后一个元素是整棵树的根结点，
	 * 倒数第二个元素就是右子树的根，
	 * 以此类推
	 */
	public static boolean isBST(int[] a) {
		if (a == null || a.length == 0)
			return false;
		for (int root = a.length - 1; root > 0; root--) {
			int i = 0;
			while (a[i] < a[root])
				i++;
			while (a[i] > a[root])
				i++;
			if (i != root)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] a1 = { 5, 7, 6, 9, 11, 10, 8 };
		int[] a2 = { 7, 4, 6, 5 };
		System.out.println(isBST(a1)); // true
		System.out.println(isBST(a2)); // false
	}

}
