package dataStructures;

//data structure for problem 3.5 - create a queue using two stacks
public class MyQueue<T> {
	Stack<T> data;
	Stack<T> buffer;
	
	public MyQueue(){
		data = new Stack<T>();
		buffer = new Stack<T>();
	}
	
	public void push(T item){
		data.push(item);
	}
	
	public T pop(){
		if (!buffer.hasNext()){
			while (data.hasNext()){
				buffer.push(data.pop());
			}
		}
		return buffer.pop();
	}
	
	public boolean hasNext(){
		return data.hasNext() || buffer.hasNext();
	}

}
