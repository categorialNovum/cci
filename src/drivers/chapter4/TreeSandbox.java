package drivers.chapter4;

import dataStructures.IntegerTree;
import java.util.Random;
import java.lang.Math;

import dataStructures.AbstractTreeNode;
public class TreeSandbox {
	
	public static void printTree(AbstractTreeNode<Integer> node, int level){
		if (node == null){
			return;
		}
		System.out.println("Level " + level + " : " + node.data);
		
		level++;
		printTree(node.left, level);
		printTree(node.right, level);
	}
	
	public static IntegerTree constructRandomTree(int size, int modnum){
		Random random = new Random(System.currentTimeMillis());
		int nextNum = Math.abs(random.nextInt() % modnum);
		IntegerTree root = new IntegerTree(nextNum);
		for (int i = 0; i < 20; i++){
			nextNum = Math.abs(random.nextInt() % modnum);
			root.insert(nextNum);
		}
		return root;
	}

	public static void main(String[] args) {
		IntegerTree root = constructRandomTree(10, 1069);
		printTree(root,0);
	}
	

}
