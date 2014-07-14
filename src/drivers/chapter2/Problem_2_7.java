package drivers.chapter2;

import dataStructures.Node;

public class Problem_2_7 {
	
	public static boolean isPalindrome(Node n){
		if (n.next == null){
			return true;
		}
		Node last = n.getTail();
		if (n.data != last.data){
			return false;
		}
		if (n.next.next == null){
			return true;
		}
		n = n.next;
		n.deleteTail();
		
		return isPalindrome(n);
	}

	public static void printList(Node n){
		while (n != null){
			System.out.println((char)n.data);
			n = n.next;
		}
	}
	
	public static Node makeList(String s){
		char[] items = s.toCharArray();
		Node head = new Node(items[0]);
		for (int x=1; x<items.length; x++){
			head.appendToTail(items[x]);
		}
		return head;
	}

	public static void main(String args[]){
		if (args.length < 1){
			System.out.println("Requires a string");
			System.exit(0);
		}	
		for (int i=0; i<args.length; i++){
			String str = args[i];
            Node head = makeList(str);
            printList(head);
            System.out.println ("Palindrome? : " + isPalindrome(head));
            System.out.println("------");
		}
	}
}
