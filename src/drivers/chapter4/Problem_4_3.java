package drivers.chapter4;

import dataStructures.AbstractTreeNode;
import dataStructures.IntegerTree;
import java.util.Random;
import java.lang.Math;

public class Problem_4_3 {
//Given a sorted (increasing) array with unique integer elements, write an algorithm to create
//	a binary search tree of minimum height
	public static void main(String[] args) {
		if (args.length < 2){
			System.out.println("Requires two arguments, number of elements and max spacing");
			System.exit(0);
		}
		
		int numElements = Integer.parseInt(args[0]);
		int spacing = Integer.parseInt(args[1]);
		int data[] = new int[numElements];
		Random random = new Random(System.currentTimeMillis() % 1069);
		
		int curNum = 1;
		for (int i=0; i < numElements; i++){
			curNum = curNum + Math.abs(random.nextInt()) % spacing;
			data[i] = curNum;
			curNum++;
		}
		
		IntegerTree orderedtree = TreeSandbox.constructFromArray(data);
		IntegerTree mintree = TreeSandbox.constructMinDepthFromArray(data);

		System.out.println("Ordered");
		System.out.println("------------");
		TreeSandbox.printTree(orderedtree, 0);
		System.out.println("Minimum");
		System.out.println("------------");
		TreeSandbox.printTree(mintree, 0);
	}

}
