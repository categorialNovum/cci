package dataStructures;

public class IntegerTree extends AbstractTreeNode<Integer>{
	

	public IntegerTree(Integer item) {
		super(item);
	}

	@Override
	public void insert(Integer item) {
		//System.out.println("insert was passed : " + item);
		//System.out.println("current data : " + this.data);
		if (left == null && item <= this.data){
		//	System.out.println("inserting left : " + item);
		//	System.out.println("---------------------------");
			left = new IntegerTree(item);
		}else if (right == null && item > this.data){
		//	System.out.println("inserting right : " + item);
		//	System.out.println("---------------------------");
			right = new IntegerTree(item);
		}else if (item <= this.data) {
		//	System.out.println("recurring left" + item);
		//	System.out.println("---------------------------");
			left.insert(item);
		}else if (item > this.data){
		//	System.out.println("recurring right : " + item);
		//	System.out.println("---------------------------");
			right.insert(item);
		}
	}

}
