package dataStructures;

public class IntegerTree extends AbstractTreeNode<Integer>{
	
	public IntegerTree() {
<<<<<<< HEAD
        super();
=======
>>>>>>> FETCH_HEAD
	}

	public IntegerTree(Integer item) {
		super(item);
	}

	@Override
	public void insert(Integer item) {
		if (this.data == null){
			this.data = item;
		}
		else if (left == null && item <= this.data){
			left = new IntegerTree(item);
		}else if (right == null && item > this.data){
			right = new IntegerTree(item);
		}else if (item <= this.data) {
			left.insert(item);
		}else if (item > this.data){
			right.insert(item);
		}
	}

}
