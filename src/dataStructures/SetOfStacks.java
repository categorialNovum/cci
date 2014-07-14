package dataStructures;

import dataStructures.Stack;

//provides regular stack functionality, but models it with sub-stacks, like stacks of plates with a height limit; 
public class SetOfStacks<T> {
	//create a new stack once sizeLimit is reached
	int sizeLimit;
	int stackPtr;
	Stack<T>[] stacks;

	
	public SetOfStacks(int size){
		sizeLimit = size;
		stackPtr = 0;
		stacks = new Stack[1];
		stacks[0] = new Stack<T>();
	}
	
	public void push(T item){
		if (stacks[stackPtr].size < sizeLimit){
			stacks[stackPtr].push(item);
		}else{
			stackPtr++;
			Stack<T>[] tmp = new Stack[stackPtr+1];
			for (int s=0; s<stacks.length; s++){
				tmp[s] = stacks[s];
			}
			tmp[stackPtr] = new Stack<T>();
			stacks = tmp;
			stacks[stackPtr].push(item);
		}
	}

	public T pop(){
		if(stacks[stackPtr].size == 0){
			stackPtr--;
			Stack<T>[] tmp = new Stack[stackPtr+1];
			for (int s=0; s<=stackPtr; s++){
				tmp[s] = stacks[s];
			}
			stacks = tmp;
		}
		return stacks[stackPtr].pop();
	}
	
	public boolean hasNext(){
		return stacks[0].hasNext();
	}
	
	public int getStackPtr(){
		return stackPtr;
	}
	

}
