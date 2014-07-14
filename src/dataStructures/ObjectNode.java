package dataStructures;

public class ObjectNode {
	public ObjectNode next = null;
	public Object data;
	
	public ObjectNode(Object o){
		data = o;
	}
	
	public void appendToTail(Object o){
		ObjectNode end = new ObjectNode(o);
		ObjectNode n = this;
		
		while(n.next != null){
			n = n.next;
		}
		n.next = end;
	}
}
