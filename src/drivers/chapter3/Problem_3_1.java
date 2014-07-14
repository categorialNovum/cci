package drivers.chapter3;

import dataStructures.Stack;

public class Problem_3_1 {

		public static void main(String[] args) {
			
			//Stack<Integer> s = new Stack<Integer>();
			Stack<Integer> s = new Stack<Integer>();
			for (int i= 0; i < 10; i++){
				System.out.println("Pushing " + i + " onto stack");
				s.push(i);
			}
			
			System.out.println("---------------------");
				
			while (s.hasNext()){
				Integer num = s.pop();
				System.out.println("Popped " + num + " from stack");
			}
	}
}
