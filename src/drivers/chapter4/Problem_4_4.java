package drivers.chapter4;

import java.util.LinkedList;

import dataStructures.MyQueue;
import dataStructures.IntegerTree;
import dataStructures.AbstractTreeNode;
import drivers.chapter4.TreeSandbox;

//Given a binary search tree, design an algorithm that creates linked lists of nodes at each depth (a tree of depth D will have D lists)
public class Problem_4_4 {
	
	// Perform a breadth first traversal of the entire tree. create a linked list for each level, return all level lists in an array.
	public static LinkedList<AbstractTreeNode<Integer>>[] splitLevels(IntegerTree tree){
                int maxDepth = TreeSandbox.maxDepth(tree);
                LinkedList<AbstractTreeNode<Integer>>[] levels = new LinkedList[maxDepth];
                MyQueue<AbstractTreeNode<Integer>> q = new MyQueue<AbstractTreeNode<Integer>>();
                q.push(tree);
                int level = 0;
                
                while(q.hasNext()){
                	MyQueue<AbstractTreeNode<Integer>> next = new MyQueue<AbstractTreeNode<Integer>>();
                	LinkedList<AbstractTreeNode<Integer>> levelList = new LinkedList<AbstractTreeNode<Integer>>();
                	while (q.hasNext()){
                		AbstractTreeNode<Integer> node = q.pop();
                		levelList.push(node);
                		if (node.left != null){
                			next.push(node.left);
                		}
                		if (node.right != null){
                			next.push(node.right);
                		}
                	}
                	levels[level] = levelList;
                	level++;
                	q = next;
                }
                return levels;
	}
	
	public static void main(String[] args) {
                IntegerTree tree = TreeSandbox.constructRandomTree(10, 317);
                TreeSandbox.printTree(tree, 0);
                int maxDepth = TreeSandbox.maxDepth(tree);
                System.out.println("-------------------");
                System.out.println("Max Depth : " + maxDepth);
                LinkedList<AbstractTreeNode<Integer>>[] levels = splitLevels(tree);
                System.out.println("-------------------");
                System.out.println("levels Size  : " + levels.length);
                System.out.println("-------------------");
                for(int x =0; x<maxDepth; x++){
                	LinkedList<AbstractTreeNode<Integer>> curList = levels[x];
                	while (!curList.isEmpty()){
                		System.out.println(x + " : " + curList.pop().data);
                	}
                	System.out.println("-------------------");
                }
                
	}
}
