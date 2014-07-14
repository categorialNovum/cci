package drivers.chapter3;

import dataStructures.SetOfStacks;

// driver to test 'set of stacks' data structure
public class Problem_3_3 {
	public static void main(String[] args) {
		if (args.length < 2){
			System.out.println("Requires two numbers, a stack limit and a count limit");
			System.exit(0);
		}
		
		int stackLimit = Integer.parseInt(args[0]);
		int countLimit = Integer.parseInt(args[1]);
		
		SetOfStacks<Integer> s = new SetOfStacks<Integer>(stackLimit);
		for (int i=1; i < countLimit; i++){
			s.push(i);
			System.out.println("Pushed (" +s.getStackPtr()+ ") " + i + " onto stack");
		}
		
		System.out.println("---------------------");
			
		while (s.hasNext()){
			Integer num = s.pop();
			System.out.println("Popped (" +s.getStackPtr()+ ") " + num + " from stack");
		}
	}
}
