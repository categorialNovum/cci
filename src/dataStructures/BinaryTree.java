package dataStructures;

import java.util.Random;

public class BinaryTree extends AbstractTreeNode<Integer>{
		
		public BinaryTree() {
	        super();
		}

		public BinaryTree(Integer item) {
			super(item);
		}
		
		public void insertRandom(Integer item){
			Random random = new Random(System.currentTimeMillis());
			if (this.data == null){
				this.data = item;
			}
			else if (left == null){
				left = new BinaryTree(item);
			}else if (right == null){
				right = new BinaryTree(item);
			}else{
				int decision = random.nextInt() % 2;
				if (decision == 0){
					left.insert(item);
				}else{
					left.insert(item);
				}
			}
		}
		
		public void insert(Integer item){
			Random random = new Random(System.currentTimeMillis());
			if (this.data == null){
				this.data = item;
			}
			else if (left == null){
				left = new BinaryTree(item);
			}else if (right == null){
				right = new BinaryTree(item);
			}else{
				int decision = random.nextInt() % 2;
				if (decision == 0){
					left.insert(item);
				}else{
					left.insert(item);
				}
			}
		}
}
