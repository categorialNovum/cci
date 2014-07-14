package drivers.chapter2;
import dataStructures.SinglyLinkedList;

public class Problem_2_1 {
	

	public static void main(String args[]){
		if (args.length < 1){
			System.out.println("Requires a string as input");
			System.exit(0);
		}	
		for (int x=0; x<args.length; x++){
			SinglyLinkedList list = new SinglyLinkedList(args[x]);
			System.out.println(args[x]);
			list.printList();
			list.dedupList();
			System.out.println("--------------");
			list.printList();
		}
	}
}
