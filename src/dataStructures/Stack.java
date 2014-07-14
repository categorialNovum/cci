package dataStructures;

import dataStructures.GenericNode;

//Last in, first out
//Generic implementation
public class Stack<T> {
	GenericNode<T> top;
	int size;
	
	public Stack(){
		size = 0;
	}
	
	public T pop(){
		if (top != null){
			T item = top.data;
			top = top.next;
			size--;
			return item;
		}
		return null;
	}
	
	public void push(T item){
		GenericNode<T> node = new GenericNode<T>(item);
		node.next = top;
		top = node;
		size++;
	}
	
	public T peek(){
		return top.data;
	}
	
	public boolean hasNext(){
		if (top == null){
			return false;
		}
		return true;
	}
	
	public int getSize(){
		return size;
	}
}
