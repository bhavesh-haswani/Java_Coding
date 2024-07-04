package l32_BinarySearchTrees;

import java.util.ArrayList;

public class A32_8_ValidateBST {
	
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

		public static Node getNode(Node root, int n) {
			
			if(root == null) {
				return null;
			}
			
			if(root.data == n) {
				return root;
			}
			
			Node node;
			if(n < root.data) {
				node = getNode(root.left, n);
			} else {
				node = getNode(root.right, n);
			}
			
			return node;
		}
		
		public static Node getParentNode(Node root, int n) {
			
			if(root == null) {
				return null;
			}
			
			if(root.data == n) {
				return null;
			}
			
			if(n < root.data) {
				if(root.left.data == n) {
					return root;
				} else {
					return getParentNode(root.left, n);
				}
			} else {
				if(root.right.data == n) {
					return root;
				} else {
					return getParentNode(root.right, n);
				}
			}
			
			
		}
		public static void deleteANode(Node root, int n) {
			
			if(root == null) {
				return;
			}
			
			//here after deleting the node, we will have to attach it's parent node with it's subtree
			Node node = getNode(root, n);
			Node parentNode = getParentNode(root, n);
			
			//case 1: where node doesnt have any child
			if(node.left == null && node.right == null) {
				if(parentNode.left == node) {
					parentNode.left = null;
				} else {
					parentNode.right = null;
				}
			} else if(node.left == null) {	// node has 1 child - at its right
				if(parentNode.left == node) {
					parentNode.left = node.right;
				} else {
					parentNode.right = node.right;
				}			
			} else if(node.right == null) {	// node has 1 child - at its left
				if(parentNode.left == node) {
					parentNode.left = node.left;
				} else {
					parentNode.right = node.left;
				}			
				
			} else {
//				System.out.println("****Delete Node with 2 childs****\n*******WORK IN PROGRESS*******");
				
				Node IS = inorderSuccessor(root.right);
				deleteANode(root, IS.data);
				node.data = IS.data;
			}
			
			
		}		
		
		public static Node inorderSuccessor(Node root) {
			while(root.left != null) {
				root = root.left;
			}
			return root;
		}
		
		//my 1st instinct method
		public static void inOrder(Node root, ArrayList<Integer> al) {
			
			if(root == null) {
				return;
			}
			
			inOrder(root.left, al);
			al.add(root.data);
			inOrder(root.right, al);
		}
		
		public static void printInRangex1(Node root, int k1, int k2) {
			ArrayList<Integer> al = new ArrayList<>();
			inOrder(root, al);
			
			for(int i=0; i<al.size(); i++) {
				if(al.get(i) >= k1 && al.get(i) <=k2) {
					System.out.print(al.get(i) +" ");
				}
			}
			
		}
		
		
		public static void printInRange(Node root, int k1, int k2) {
			
			if(root == null) {
				return;
			}
			
			if(root.data >= k1 && root.data <= k2) {
				System.out.print(root.data +" ");
				printInRange(root.left, k1, k2);
				printInRange(root.right, k1, k2);
			} else if(k1 > root.data) {	//all nodes at right subtree				
				printInRange(root.right, k1, k2);
			} else if(k2 < root.data) {
				printInRange(root.left, k1, k2);	// all nodes at left subtree
			}
			
		}
		
		
		public static void printPath(Node root, ArrayList<Integer> al) {
			
			if(root == null) {
				return;
			}
			
			
			al.add(root.data);
			printPath(root.left, al);
			printPath(root.right, al);
			
			if(root.left == null && root.right == null) {
				System.out.println(al);
			}
			al.remove(al.size()-1);
			
		}
		
		
		public static boolean validateTree(Node root, Node min, Node max) {
			
			if(root == null) {
				return true;
			}
			
			
			if(min != null && root.data <= min.data) {
				return false;
			}
			if(max != null && root.data >= max.data) {
				return false;
			}
			
			
			boolean leftSubtree = validateTree(root.left, null, root);
			boolean rightSubtree = validateTree(root.right, root, null);
			
			return leftSubtree && rightSubtree;
			
		}
		
		
	}
	
	public static void main(String[] args) {
		
//		int values[] = {5, 1, 3, 4, 2, 7, 6, 8};
		int values[] = {1, 1, 1};
		
		/*
		 
		 			5
		 		  /	  \
		 		1		7
		 		  \	   /   \
		 			3	6	8
		 		  /	  \
		 		2		4
		 			
		 
		 
		 */
		
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
		
		
//		BinarySearchTree.deleteANode(root, 4);
//		BinarySearchTree.deleteANode(root, 7);
//		BinarySearchTree.deleteANode(root, 8);
//		BinarySearchTree.deleteANode(root, 5);
//		BinarySearchTree.deleteANode(root, 7);
//		BinarySearchTree.printTreePreOrder(root);
//		System.out.println();
//		BinarySearchTree.printTreeInOrder(root);
		
		System.out.println();
		BinarySearchTree.printInRangex1(root, 4, 8);
		
		System.out.println();
		BinarySearchTree.printInRange(root, 4, 8);
		
		System.out.println();
		ArrayList<Integer> al = new ArrayList<>();
		BinarySearchTree.printPath(root, al);
		
		System.out.println();
		boolean validate = BinarySearchTree.validateTree(root, null, null);
		System.out.println(validate);
		
		
	}

}
