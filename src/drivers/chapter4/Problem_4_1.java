package drivers.chapter4;

import drivers.chapter4.TreeSandbox;
import dataStructures.AbstractTreeNode;
import dataStructures.IntegerTree;

//Test whether a tree is balanced or not
public class Problem_4_1 {
	
	public static int findDepth(AbstractTreeNode root){
		if (root == null){
			return 0;
		}
		// add one to the depth of the greater subtree
		return Math.max(findDepth(root.left), findDepth(root.right)) + 1;
	}

	public static boolean isBalanced(AbstractTreeNode node){
		int lheight = findDepth(node.left);
		int rheight = findDepth(node.right);
		System.out.println("isBalanced lheight : " + lheight);
		System.out.println("isBalanced rheight : " + rheight);

		if (Math.abs(lheight - rheight) > 1){
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		IntegerTree root = TreeSandbox.constructRandomTree(10, 20);
		TreeSandbox.printTree(root, 0);
		int depth = findDepth(root);
		System.out.println("-----------------");
		System.out.println("Depth : " + depth);
		System.out.println("-----------------");
		System.out.println("Is Balanced ? " + isBalanced(root));
	}

}
