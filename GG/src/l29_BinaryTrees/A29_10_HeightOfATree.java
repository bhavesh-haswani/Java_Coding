package l29_BinaryTrees;

import l29_BinaryTrees.A29_9_LevelOrderTraversal.Node;

public class A29_10_HeightOfATree {

	public static class Node {
		
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;	
		}
				
	}
	
	public static class BinaryTree {
		
		static int idx = -1;
		public static Node buildTreeUsingPreOrder(int nodes[]) {
			
			idx++;
			if(nodes[idx] == -1) {
				return null;				
			}

			Node node = new Node(nodes[idx]);
			node.left = buildTreeUsingPreOrder(nodes);
			node.right = buildTreeUsingPreOrder(nodes);
			return node;
						
		}
		
		public static void printTreePreOrder(Node root) {
			
			if(root == null) {
				System.out.print(-1 +" ");
				return;
			}
			
			System.out.print(root.data +" ");
			printTreePreOrder(root.left);
			printTreePreOrder(root.right);
		}

		public static void printTreeInOrder(Node root) {
			
			if(root == null) {
				System.out.print(-1 +" ");
				return;
			}
			
			printTreeInOrder(root.left);
			System.out.print(root.data +" ");
			printTreeInOrder(root.right);
		}

		public static void printTreePostOrder(Node root) {
			
			if(root == null) {
				System.out.print(-1 +" ");
				return;
			}
			
			printTreePostOrder(root.left);
			printTreePostOrder(root.right);
			System.out.print(root.data +" ");
		}
		
		public static int heightOfATree(Node root) {
			
			if(root == null) {
				return 0;
			}
			
			int height = Math.max(heightOfATree(root.left), heightOfATree(root.right)) + 1;
			
			return height;
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTreeUsingPreOrder(nodes);
		
		System.out.print("PreOrder: ");
		tree.printTreePreOrder(root);
		System.out.println();
		System.out.print("InOrder: ");
		tree.printTreeInOrder(root);
		System.out.println();
		System.out.print("PostOrder: ");
		tree.printTreePostOrder(root);
		
		System.out.println();
		System.out.println("Height of a tree = " +tree.heightOfATree(root));
		
	}

}
