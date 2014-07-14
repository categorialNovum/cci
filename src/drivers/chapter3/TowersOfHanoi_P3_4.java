package drivers.chapter3;

import dataStructures.Stack;

// Classic cs problem. Three towers exist that can hold N disks of different sizes.
// The problem begins with the disks sorted on the first tower, sorted from smallest on top to largest on bottom.
// Move the disks to the last tower with the following constraints
//	* Move only 1 disk at a time
//	* Disks move from the top of one tower to the top of another tower
//	* A disk can only be placed on top of a larger disk.
// The problem wants it to be implemented with stacks.
public class TowersOfHanoi_P3_4 {
	static Stack<Integer> towerA;
	static Stack<Integer> towerB;
	static Stack<Integer> towerC;
	static int numDisks;

/*	public static void printTowers(Stack a, Stack b, Stack c){
		
		int tallest = a.getSize();
		tallest = (tallest < b.getSize()) ? b.getSize() : tallest;
		tallest = (tallest < c.getSize()) ? c.getSize() : tallest;
		
		while (tallest > 0){
			if (a.getSize() == tallest){
				System.out.print(a.pop());
			}
			if (b.getSize() == tallest){
				System.out.print("\t" + b.pop());
			}
			if (c.getSize() == tallest){
				System.out.print("\t\t" + c.pop());
			}
			tallest--;
			System.out.print("\n");
		}
		System.out.println("-------------------------");
	}
	
	// Stopping condition : all disks are on tower C and properly sorted
	public static void solve(Stack<Integer> a, Stack<Integer> b, Stack<Integer> c){
		if (c.getSize() == numDisks){
			return;
		}
		int zeroCt = countZeros(a,b,c);

	}*/
	
	//switch 1
	private static void ab(){
		System.out.println("AB");
		towerB.push(towerA.pop());
	}
	//switch 2
	private static void ac(){
		System.out.println("AC");
		towerC.push(towerA.pop());
	}
	//switch 3
	private static void ba(){
		System.out.println("BA");
		towerA.push(towerB.pop());
	}
	//switch 4
	private static void bc(){
		System.out.println("BC");
		towerC.push(towerB.pop());
	}
	//switch 5
	private static void ca(){
		System.out.println("CA");
		towerA.push(towerC.pop());
	}
	//switch 6
	private static void cb(){
		System.out.println("CB");
		towerB.push(towerC.pop());
	}
	
	public static int chooseNextMove(int A, int B, int C, int lastMove){
		boolean aOdd = (A % 2 != 0);
		boolean bOdd = (B % 2 != 0);
		boolean cOdd = (C % 2 != 0);
		int nextMove = 0;
		
		if (aOdd != bOdd && lastMove != 1 && (B == 0 || A<B))
			nextMove = 1;
		if (aOdd != cOdd && lastMove != 2 && (C == 0 || A<C))
			nextMove = 2;
		if (bOdd != aOdd && lastMove != 3 && (A == 0 || B<A))
			nextMove = 3;
		if (bOdd != cOdd && lastMove != 4 && (C == 0 || B<C))
			nextMove = 4;
		if (cOdd != aOdd && lastMove != 5 && (A == 0 || C<A))
			nextMove = 5;
		if (cOdd != bOdd && lastMove != 6 && (B == 0 || C<B))
			nextMove = 6;
			
		return nextMove;
	}
	
	public static void solve(){
		boolean solved = false;
		int topA,topB,topC;
		int lastMove = 0;
		if (numDisks % 2 == 0){
			ac();
			lastMove = 2;
		}else{
			ab();
			lastMove = 1;
		}
		while (!solved){
			topA = (towerA.hasNext()) ?  towerA.peek() : 0;
			topB = (towerB.hasNext()) ?  towerB.peek() : 0;
			topC = (towerC.hasNext()) ?  towerC.peek() : 0;
			int nextMove = chooseNextMove(topA, topB, topC, lastMove);
			switch(nextMove){
				case 1:
					ab();break;
				case 2:
					ac();break;
				case 3:
					ba();break;
				case 4:
					bc();break;
				case 5:
					ca();break;
				case 6:
					cb();break;
			}
			lastMove = nextMove;
			if(towerC.getSize() == numDisks){
				solved = true;
			}
		}
		System.out.println("SOLVED!");
	}
	
	public static void init(int n){
		towerA = new Stack();
		towerB = new Stack();
		towerC = new Stack();
		numDisks = n;
		for (int x=numDisks; x>0; x--){
			towerA.push(x);
		}
		
	}

	public static void main(String[] args) {
		if (args.length < 1){
			System.out.println("Requires a number N for the number of disks in the problem.");
			System.exit(0);
		}
		int n = Integer.parseInt(args[0]);
		init(n);
		solve();
	}

}
