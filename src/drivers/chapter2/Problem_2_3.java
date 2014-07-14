package drivers.chapter2;

import dataStructures.Node;

// Given the middle node of a linked list, delete that node given only access to that node
// Input : the node C from the list A->B->C->D->E
// Output : return nothing, but the new list looks like A->B->D->E
public class Problem_2_3 {
	// creates linked list, returns middle node
	public static Node makeList(String s){
		char[] items = s.toCharArray();
		int midPoint = items.length / 2;
		Node head = new Node(items[0]);
		for (int x=1; x<items.length; x++){
			head.appendToTail(items[x]);
		}
		Node middle = head;
		for (int x=0; x<midPoint;x++){
			middle = middle.next;
		}
		return middle;
	}

	public static void main(String args[]){
		if (args.length < 1){
			System.out.println("Requires a string");
			System.exit(0);
		}	
        String str = args[0];
        Node middle = makeList(str);
        System.out.println("String : " + str);
        System.out.println("Middle : " + (char)middle.data);
        
        
	}
}
