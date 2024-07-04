package l32_BinarySearchTrees;

public class A32_4_SearchInBST {
	
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
		
		
		//not the bestway - doesn't utilize the Binary Search Tree advantage
		
		public static boolean searchInBSTx(Node root, int n) {
			
			if(root == null) {
				return false;
			}
			
			if(root.data == n) {
				return true;
			}
			
			boolean searchInLeftSubTree = searchInBST(root.left, n);
			boolean searchInRightSubTree = searchInBST(root.right, n);
			
			if(searchInLeftSubTree || searchInRightSubTree) {
				return true;
			}
			
			return false;
		}
		
		
		public static boolean searchInBST(Node root, int n) {
			
			if(root == null) {
				return false;
			}
			
			if(root.data == n) {
				return true;
			}
			
			boolean search;
			if(n < root.data) {
				search = searchInBST(root.left, n);
			} else {
				search = searchInBST(root.right, n);
			}

			return search;
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
		
		//not the bestway
		System.out.println();
		boolean searchResultx = BinarySearchTree.searchInBSTx(root, 5);
		System.out.println(searchResultx);

		boolean searchResult = BinarySearchTree.searchInBST(root, 5);
		System.out.println(searchResult);
		
	}

}
