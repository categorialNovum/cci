package drivers.chapter2;

import dataStructures.Node;

//create an algorithm to return the kth to last node
public class Problem_2_2 {
	
	public static Node makeList(String s){
		char[] items = s.toCharArray();
		Node head = new Node(items[0]);
		for (int x=1; x<items.length; x++){
			head.appendToTail(items[x]);
		}
		return head;
	}
	
	public static int getKthLast(Node head, int k){
		int n = 0;
		Node node = head;
		while (node != null){
			node = node.next;
			n++;
		}
		node = head;
		int kthLast = n - k;
		for(int x =0; x< kthLast; x++){
			node = node.next;
		}
		return node.data;
	}

	public static void main(String args[]){
		if (args.length < 2){
			System.out.println("Requires a string and number as input");
			System.exit(0);
		}	
        String str = args[0];
        int k = Integer.parseInt(args[1]);
        Node list = makeList(str);
		int klast = getKthLast(list, k);
		System.out.println("String : " + str);
		System.out.println("K : " + k);
		System.out.println("Kth Last : " + (char)klast);
        
	}
}
