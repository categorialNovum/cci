package drivers.chapter4;

import dataStructures.IntegerTree;
import dataStructures.BinaryTree;
import java.util.LinkedList;
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
	
	public static int maxDepth(AbstractTreeNode node){
		if (node == null){
			return 0;
		}
		int leftDepth = maxDepth(node.left);
		int rightDepth = maxDepth(node.right);
		return Math.max(leftDepth + 1, rightDepth + 1);
	}
	
	//make  a random binary search tree
	//uses size for number of nodes and modnum to constrain the size of the values
	public static IntegerTree constructRandomTree(int size, int modnum){
		Random random = new Random(System.currentTimeMillis());
		int nextNum = Math.abs(random.nextInt() % modnum);
		IntegerTree root = new IntegerTree(nextNum);
		for (int i = 0; i < size; i++){
			nextNum = Math.abs(random.nextInt() % modnum);
			root.insert(nextNum);
		}
		return root;
	}

	//make a binary tree of random numbers
	// uses size for number of nodes and modnum to constrain the size of the values
	public static BinaryTree constructRandomBinaryTree(int size, int modnum){
		Random random = new Random(System.currentTimeMillis());
		int nextNum = Math.abs(random.nextInt() % modnum);
		BinaryTree root = new BinaryTree(nextNum);
		for (int i = 0; i < size; i++){
			nextNum = Math.abs(random.nextInt() % modnum);
			root.insertRandom(nextNum);
		}
		return root;
	}

	//create a binary search tree from an array of numbers
	public static IntegerTree construstFromArray(int[] numbers){
		IntegerTree root = new IntegerTree(numbers[0]);
		for (int i=1; i<numbers.length; i++){
			root.insert(numbers[i]);
		}
		return root;
	}
	
	// takes a sorted array, returns a binary search tree of minimum height;
	public static IntegerTree constructMinDepthFromArray(int[] numbers){
		IntegerTree root = new IntegerTree();
		int middle = numbers.length / 2;
		LinkedList<Integer> interleaved = new LinkedList<Integer>();
		
		System.out.println("MinDepth : size : " + numbers.length);
		System.out.println("MinDepth : middle : " + middle);
		
		for (int i=middle; i < numbers.length; i++){
			root.insert(numbers[i]);
			if (i-middle != middle){ 	// don't insert middle a second time
				root.insert(numbers[i-middle]);
			}
		}
		return root;
	}
	
	// is the tree passed in a binary search tree?
	public static boolean isBST(AbstractTreeNode<Integer> root){
		if(root == null){
			return true;
		}
		if (root.left != null && root.left.data > root.data){
			return false;
		}
		if (root.right != null && root.right.data < root.data){
			return false;
		}
		return isBST(root.left) && isBST(root.right);
	}

	public static void main(String[] args) {
		IntegerTree root = constructRandomTree(150000, 10069);
		printTree(root,0);
		System.out.println("Max Depth : " + maxDepth(root));
		System.out.println("Is BST ? : " + isBST(root));
	}
}
