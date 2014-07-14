package drivers.chapter2;

import dataStructures.Node;

//INPUT : two integers stored as a linked list
//OUTPUT : sum of the two ints.

// the integers are stored as linked lists in reverse order, one digit per node. IE 716 as 6->1->7
// add two of these digits together.

// Follow up : the two ints are represented in proper order.
public class Problem_2_5 {
	
	public static void printNum(Node n){
		while (n != null){
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	public static int addReverse(Node a, Node b, int carry, String work){
		System.out.println("Work : " + work);
		if (a != null && b != null){
			int digit = a.data + b.data + carry;
			int c = 0;
			if (digit >= 10){
				digit = digit%10;
			}
			addReverse(a.next, b.next,c, Integer.toString(digit) + work);
		}
		if (a != null && b == null){
			addReverse(a.next, b,0, Integer.toString(a.data) + work);
		}
		if (a == null && b != null){
			addReverse(a,b.next,0, Integer.toString(b.data) + work);
		}
		return Integer.parseInt(work);
	}
	
	public static int addRevIter(Node a, Node b){
		if(a == null && b == null){
			return 0;
		}
		boolean done = false;
		String work = "";
		int carry = 0;
		while(!done){
			if (a != null && b != null){
				int digit = a.data + b.data + carry;
				if (digit >= 10){
					digit = digit%10;
					carry = 1;
				}else{
					carry = 0;
				}
				work = Integer.toString(digit) + work;
				a = a.next;
				b = b.next;
			}
			if (a != null && b == null){
				work = Integer.toString(a.data + carry) + work;
				carry = 0;
				a = a.next;
			}
			if (a == null && b != null){
				work = Integer.toString(b.data + carry) + work;
				carry = 0;
				b = b.next;
			}
			if (a == null && b == null){
				done = true;
			}
		}
		return Integer.parseInt(work);
	}
	
	public static Node makeReverseNum(String s){
		Node head = null;
		String[] digits = s.split("");
		
		for (int i=digits.length-1; i>0; i--){
			System.out.println("makeNum : " + digits[i]);
			if (head == null){
				head = new Node(Integer.parseInt(digits[i]));
			}else{
				head.appendToTail(Integer.parseInt(digits[i]));
			}
		}
		return head;
	}

	public static void main(String args[]){
		if (args.length < 2){
			System.out.println("Requires two integers");
			System.exit(0);
		}	
		String numA = args[0];
		String numB = args[1];
		Node a = makeReverseNum(numA);
		Node b = makeReverseNum(numB);
		
		System.out.println("A : " + numA);
		System.out.println("------");
		printNum(a);
		System.out.println("------");
		System.out.println("B : " + numB);
		System.out.println("------");
		printNum(b);
		System.out.println("------");
		System.out.println("Sum : " + addRevIter(a,b));

	}
}
