package dataStructures;
import dataStructures.Node;

public class SinglyLinkedList {
	private static Node head;
	public static int length;
	
	public SinglyLinkedList(String s){
		length = 0;
		populateList(s);
	}
	
	public void populateList(String s){
		char[] chars = s.toCharArray();
		head = new Node(chars[0]);
		length++;
		for (int x=1; x<chars.length; x++){
			head.appendToTail(chars[x]);
			length++;
		}
	}
	
	public void deleteNode(int d){
		Node n = head;
		if (n.data == d){
			head = head.next; // head contains data to delete
			length--;
			return;
		}
		
		while (n.next != null){
			if (n.next.data == d){
				n.next = n.next.next; // the next node contains the data to delete, point to the node after that instead
				length--;
				return;
			}
			n = n.next;
		}
	}
	
	public void printList(){
		Node n = head;
		System.out.println("PL : " + n.data + " : " + (char)n.data);
		while (n.next != null){
			n = n.next;
			System.out.println("PL : " + n.data + " : " + (char)n.data);
		}
	}
	
	public void dedupList(){
		Node bookmark = head;
		Node cursor = bookmark.next;
		while (bookmark.next != null){
			System.out.println("-----------------");
			System.out.println("Bookmark : " + (char)bookmark.data);
			int d = bookmark.data;
			int dcount = 1;
			while (cursor != null){
				System.out.println("Cursor : " + (char)cursor.data);
				if (cursor.data == d){
					dcount++;
				}
				cursor = cursor.next;
			}
			for(int x=1; x<dcount; x++){
				System.out.println("Deleting " + (char)d);
				deleteNode(d);
			}
			if (bookmark.next != null){
				bookmark = bookmark.next;
				cursor = bookmark.next;
			}
		}
	}
}
