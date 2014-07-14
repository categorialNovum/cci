package drivers.chapter2;

import dataStructures.Node;
import java.util.ArrayList;

//given a linked list containing a loop return the node that starts the loop
public class Problem_2_6 {
	
	// find the end of a list with no loop
	public static Node findTail(Node n){
		if(n.next == null){
			return n;
		}
		return findTail(n.next);
	}
	
	public static void findLoop(Node n){
//		HashMap visitedNodes;
		ArrayList<Node> visitedNodes = new ArrayList();
		boolean loopFound = false;
		while(!loopFound){
			if (!visitedNodes.contains(n)){
				visitedNodes.add(n);
				n = n.next;
			}else{
				System.out.println("Loop Point : " + n.data);
				return;
			}
		}
	}
	
	//check if list has a loop. Traverse lists at two different speeds. If a and be are ever the same, there is a loop.
	public static boolean hasLoop(Node n){
		Node a = n;
		Node b = a.next;
		
		while (a.next != null){
			if (a == b){
				return true;
			}
			if(a.next == null || b.next.next == null){
				return false;
			}
			a = a.next;
			b = b.next.next;
		}
		return false;
	}
	
	//create a list with a loop
	public static Node makeList(int startLength, int loopLength){
		Node head = new Node(0);
		Node bookmark = head;
		System.out.println("Head : " + 0);
		for (int x=1; x<startLength; x++){
			System.out.println("X : " + x);
			head.appendToTail(x);
			bookmark = bookmark.next;
		}
		for (int i=startLength; i<startLength+loopLength; i++){
			bookmark.appendToTail(i);
			System.out.println("I : " + i);
			if (i == startLength+loopLength-1){
				Node n = findTail(bookmark);
				n.next = bookmark;
				System.out.println("Closing loop");
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		int startLength = 3;
		int loopLength = 5;
		Node regList = new Node(1);
		regList.appendToTail(2);
		regList.appendToTail(3);
		
		Node node = makeList(startLength, loopLength);
		System.out.println("Loop? a: " + hasLoop(node));
		System.out.println("Loop? b: " + hasLoop(regList));
		findLoop(node);
	}
}