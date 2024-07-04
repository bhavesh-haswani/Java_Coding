package l31_BinaryTrees_3;

public class A31_1_KthLevelOfATree {
	
	public static class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		
	}
	
	public static class BinaryTree {
		
		static int idx = -1;
		public static Node preOrder(int data[]) {
			
			idx++;
			if(data[idx] == -1) {
				return null;
			}
			Node root = new Node(data[idx]);
			
			root.left = preOrder(data);
			root.right = preOrder(data);
			
			return root;
		}
		
//		static int level = 0;
		public static void printKthLevel(Node root, int level, int givenLevel) {
			
			//level++;
			
			if(root == null) {
				return;
			}
			
			if(level == givenLevel) {
				System.out.print(root.data +" ");
			}
			
			printKthLevel(root.left, level+1, givenLevel);
			printKthLevel(root.right, level+1, givenLevel);
			
		}
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("gg");
		
		int data[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
		
		Node root = BinaryTree.preOrder(data);
		
//		System.out.println(root.data);
//		System.out.println(root.left.data);
//		System.out.println(root.left.left.data);
//		System.out.println(root.left.right.data);
//		System.out.println(root.right.data);
//		System.out.println(root.right.left.data);
//		System.out.println(root.right.right.data);
//		
		BinaryTree.printKthLevel(root, 1, 3);
		
		
	}

}
