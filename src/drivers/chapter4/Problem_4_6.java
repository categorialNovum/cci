package drivers.chapter4;

import drivers.chapter4.TreeSandbox;
import dataStructures.BinaryTree;
import dataStructures.AbstractTreeNode;
import java.util.Random;
import java.lang.Math;


public class Problem_4_6 {
	static Random random;

	public static void shuffle(int[] array){
		int arraySize = array.length;
		//Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < arraySize; i++){
			int currentNum = array[i];
			int swapIdx = Math.abs(random.nextInt() % arraySize);
			array[i] = array[swapIdx];
			array[swapIdx] = currentNum;
		}
	}

	public static void main(String[] args) {
		if (args.length < 1){
			System.out.println("Requires an argument for size of the tree.");
			System.exit(0);
		}
		random = new Random(System.currentTimeMillis());
		
		int size = Integer.parseInt(args[0]);
		int[] numbers = new int[size];
		
		for (int x = 0; x < size; x++){
			numbers[x] = x + 1;
		}
		
		shuffle(numbers);
		BinaryTree root = TreeSandbox.constructBinaryFromArray(numbers);
		TreeSandbox.printTree(root, 0);
		
		int a = Math.abs(random.nextInt()%size + 1);
		int b = Math.abs(random.nextInt()%size + 1);
		while (a == b){
			b = Math.abs(random.nextInt()%size + 1);
		}
		System.out.println("A : " + a);
		System.out.println("B : " + b);
		AbstractTreeNode<Integer> ancestor = TreeSandbox.findCommonAncestor(root, a, b);
		System.out.println("First Common Ancestor : " + ancestor.data);
		
	}
}
