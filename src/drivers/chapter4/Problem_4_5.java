package drivers.chapter4;

import dataStructures.BinaryTree;
import dataStructures.IntegerTree;
import drivers.chapter4.TreeSandbox;

//create a procedure to determine whether a binary tree is a BST
public class Problem_4_5 {

	public static void main(String[] args) {
		int size = 12;
		int modnum = 1069;
		BinaryTree regularTree = TreeSandbox.constructRandomBinaryTree(size, modnum);
		IntegerTree bst = TreeSandbox.constructRandomTree(size, modnum);
		TreeSandbox.printTree(regularTree, 0);
		System.out.println("----------------");
		System.out.println("BST? (regular) : " + TreeSandbox.isBST(regularTree));
		System.out.println("----------------");
		TreeSandbox.printTree(bst, 0);
		System.out.println("----------------");
		System.out.println("BST? (bst) : " + TreeSandbox.isBST(bst));
	}

}
