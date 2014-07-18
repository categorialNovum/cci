package dataStructures;

public abstract class AbstractTreeNode<T> {
	public AbstractTreeNode<T> left;
	public AbstractTreeNode<T> right;
	public T data;
	private boolean visited;

	public AbstractTreeNode (){
		visited = false;
		left = null;
		right = null;
	}
	
	public AbstractTreeNode (T item){
		data = item;
		visited = false;
		left = null;
		right = null;
	}
	
	public void setLeft(AbstractTreeNode<T> l){
		left = l;
	}

	public void setRight(AbstractTreeNode<T> r){
		right = r;
	}
	
	public boolean wasVisited(){
		return visited;
	}
	
	abstract public void insert(T item);
}
