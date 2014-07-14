package dataStructures;

public class TreeNode<T> {
	public T data;
	public TreeNode<T> left;
	public TreeNode<T> right;
	
	public TreeNode (T item){
		data = item;
	}
	public void setLeft(TreeNode<T> l){
		left = l;
	}

	public void setRight(TreeNode<T> r){
		right = r;
	}
	
}
