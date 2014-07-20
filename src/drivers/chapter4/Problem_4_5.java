package drivers.chapter4;

import dataStructures.BinaryTree;
import drivers.chapter4.TreeSandbox;

public class Problem_4_5 {

	public static void main(String[] args) {
		BinaryTree bt = TreeSandbox.constructRandomBinaryTree(12, 1069);
		TreeSandbox.printTree(bt, 0);
	}

}
