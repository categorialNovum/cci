package dataStructures;

import dataStructures.ObjectNode;

// First in, first out
public class Queue {
	ObjectNode first,last;
	
	void enqueue(Object item){
		if(last == null){
			last = new ObjectNode(item);
			first = last;
		}else{
			last.next = new ObjectNode(item);
			last = last.next;
		}
	}
	
	Object dequeue(){
		if (first != null){
			Object item = first.data;
			first = first.next;
			if(first == null){
				last = null;
			}
			return item;
		}
		return null;
	}

}
