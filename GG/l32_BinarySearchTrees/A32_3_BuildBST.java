package l32_BinarySearchTrees;

public class A32_3_BuildBST {
	
	public static class Node {
		
		int data;
		Node left;
		Node right;
		
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
		
	}
	
	public static class BinarySearchTree{
		
		public static Node buildTreeINSERT(Node node, int data) {
			
			if(node == null) {
				node = new Node(data);
				return node;
			}
			
			if(data < node.data) {
				node.left = buildTreeINSERT(node.left, data);
			} else {
				node.right = buildTreeINSERT(node.right, data);
			}
			return node;
			
		}
		

		
		
		public static void printTreePreOrder(Node root) {
			
			if(root == null) {
				return;
			}
			
			System.out.print(root.data +" ");
			printTreePreOrder(root.left);
			printTreePreOrder(root.right);
						
		}

		public static void printTreeInOrder(Node root) {
			
			if(root == null) {
				return;
			}
			
			printTreeInOrder(root.left);
			System.out.print(root.data +" ");
			printTreeInOrder(root.right);
			
		}
		
	}
	
	public static void main(String[] args) {
		
		int values[] = {5, 1, 3, 4, 2, 7};
		
		Node root = null;
		for(int i=0; i<values.length; i++) {
			root = BinarySearchTree.buildTreeINSERT(root, values[i]);
		}
		
		BinarySearchTree.printTreePreOrder(root);
		System.out.println();
		BinarySearchTree.printTreeInOrder(root);
		
	}

}
