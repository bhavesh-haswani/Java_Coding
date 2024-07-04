package l33_BinarySearchTrees2;

import java.util.ArrayList;

public class A33_3_SizeOfLargestBSTinBT {
	
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

		public static void printTreeInOrder(Node root, ArrayList<Integer> al) {
			
			if(root == null) {
				return;
			}
			
			printTreeInOrder(root.left, al);
			System.out.print(root.data +" ");
			al.add(root.data);
			printTreeInOrder(root.right, al);
			
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
		
		
		public static Node mirrorBST(Node root, Node newNode) {
			
			if(root == null) {
				return null;
			}
			
			if(newNode == null) {
				newNode = new Node(root.data);
			}
			
			if(root.left != null) {
				newNode.right = new Node(root.left.data);
			}
			if(root.right != null) {
				newNode.left = new Node(root.right.data);
			}
			
			mirrorBST(root.left, newNode.right);
			mirrorBST(root.right, newNode.left);
			
			return newNode;
			
		}
		
		
		
		public static Node sortedArrayToBST(Node root, Integer values[], int start, int end) {
			
			int mid = start + (end - start)/2;
//			System.out.println(mid);
			
			if(root == null && start >= 0 && end >=0 && start <= end) {
				root = new Node(values[mid]);
//				System.out.println(root.data);
			} 
			
			if(root != null) {
				root.left = sortedArrayToBST(root.left, values, start, mid-1);
				root.right = sortedArrayToBST(root.right, values, mid+1, end);			
			}
			
			
			return root;
			
		}
		
		
		
		static class Infox {
			boolean isBST;
			int min;
			int max;
			int cnt;
			
			Infox() {
				this.isBST = true;
				this.min = 0;
				this.max = 0;
				this.cnt = 1;
			}
			
		}
		
		
		public static Infox sizeOfLargestBST(Node root) {
			
			if(root == null) {
				return null;
			}
			
			if(root.left == null && root.right == null) {
				Infox gg = new Infox();
				gg.min = root.data;
				gg.max = root.data;
				return gg;
			}
			
			Infox leftInfox = sizeOfLargestBST(root.left);
			Infox rightInfox = sizeOfLargestBST(root.right);
			
//			if(leftInfox != null && rightInfox != null) {
				if(leftInfox.isBST && rightInfox.isBST) {
					
					if(root.data > leftInfox.max && root.data < rightInfox.min) {
						
						Infox thisNodeInfox = new Infox();
						int min = leftInfox.min;
						int max = rightInfox.max;
						int cnt = leftInfox.cnt + rightInfox.cnt + 1;
						
						thisNodeInfox.min = min;
						thisNodeInfox.max = max;
						thisNodeInfox.cnt = cnt;
						return thisNodeInfox;
					} else if( leftInfox.cnt > rightInfox.cnt ) {
						return leftInfox;
					} else {
						return rightInfox;
					}
				
				} 
				else if(leftInfox.isBST) {
					Infox thisNodeInfox = new Infox();
					int min = Math.min(Math.min(leftInfox.min, root.data), rightInfox.min);
					int max = rightInfox.max;
					return leftInfox;
				} else if(rightInfox.isBST) {
					return rightInfox;
				}
			
			return null;
			
		}
		
		
		
	}
	
	public static void main(String[] args) {
		
//		int values[] = {5, 1, 3, 4, 2, 7, 6, 8};
//		int values[] = {1, 1, 1};
		
		/*
		 
		 			5
		 		  /	  \
		 		1		7
		 		  \	   /   \
		 			3	6	8
		 		  /	  \
		 		2		4
		 			
		 
		 
		 */
		
		/*Node root = null;
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
		
		
		Node mirrorRoot = BinarySearchTree.mirrorBST(root, null);
		System.out.println("Mirror Tree");
		BinarySearchTree.printTreePreOrder(mirrorRoot);
		System.out.println();
		BinarySearchTree.printTreeInOrder(mirrorRoot);
		*/
		
		/*
		 
			5							5
		  /	  \						   / \
		1		7					  7	   1	
		  \	   /   \				 / \   /
			3	6	8				8	6  3
		  /	  \							   /\
		2		4						  4  2
			
		 */
		
		//Sorted Array to BST
//		Integer[] values = {3, 5, 6, 8, 10, 11, 12};
		Integer[] values = {3, 10, 6, 8, 10, 11, 12};
		
		/*
		 				8
		  			5		11
		  		  3	  6	  10  12
		 
		 */
		
		Node root = BinarySearchTree.sortedArrayToBST(null, values, 0, values.length-1);
		BinarySearchTree.printTreePreOrder(root);
		System.out.println();
		BinarySearchTree.printTreeInOrder(root);
		
		
		Node rootx = new Node(8);
		rootx.left = new Node(6);
		rootx.left.left = new Node(5);
		rootx.left.left.left = new Node(3);
		
		rootx.right = new Node(10);
		rootx.right.right = new Node(11);
		rootx.right.right.right = new Node(12);

		System.out.println();
		BinarySearchTree.printTreePreOrder(rootx);
		System.out.println();
		ArrayList<Integer> al = new ArrayList<Integer>();
		BinarySearchTree.printTreeInOrder(rootx, al);
		System.out.println();
		System.out.println(al);
		Integer[] valuesx = al.toArray(new Integer[0]);
		
//		for(int i=0; i<valuesx.length; i++) {
//			System.out.println(valuesx[i]);
//		}

		Node rootxx = BinarySearchTree.sortedArrayToBST(null, valuesx, 0, values.length-1);
		System.out.println();		
		BinarySearchTree.printTreePreOrder(rootxx);
		System.out.println();
		BinarySearchTree.printTreeInOrder(rootxx);
		
		System.out.println();
		BinarySearchTree.Infox x = BinarySearchTree.sizeOfLargestBST(root);
		System.out.println(x.cnt);
		
		
	}

}

