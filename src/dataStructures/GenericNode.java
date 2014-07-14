package dataStructures;

public class GenericNode<T> {

	public GenericNode<T> next = null;
	public T data;

	public GenericNode(T item){
		data = item;
	}
	
	public void appendToTail(T item){
		GenericNode<T> end = new GenericNode<T>(item);
		GenericNode<T> n = this;
		
		while(n.next != null){
			n = n.next;
		}
		n.next = end;
	}
}
