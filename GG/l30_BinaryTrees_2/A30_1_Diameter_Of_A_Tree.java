package l30_BinaryTrees_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import l29_BinaryTrees.A29_z12_SumOfNodes.BinaryTree;
import l29_BinaryTrees.A29_z12_SumOfNodes.Node;

public class A30_1_Diameter_Of_A_Tree {
	
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
		
		public static int sumOfNodes(Node root) {
			
			if(root == null) {
				return 0;
			}
						
			int sum = sumOfNodes(root.left) + sumOfNodes(root.right) + root.data;
			
			return sum;
		}
		
		
		public static int heightOfATree(Node root) {
			
			if(root == null) {
				return 0;
			}
			
			int height = Math.max(heightOfATree(root.left), heightOfATree(root.right)) + 1;
			
			return height;
			
		}
		
		
		public static int diameterOfATree(Node root) {
			
			if(root == null) {
				return 0;
			}
			
			//there are 2 case to be noted
			//1. when diameter passes through the root
			//2. when diameter passes through the subtree
			
			int rootDiameter = heightOfATree(root.left) + heightOfATree(root.right) + 1;
			
			int leftDiameter = diameterOfATree(root.left);
			int rightDiameter = diameterOfATree(root.right);
			
			int diameter = Math.max(Math.max(leftDiameter, rightDiameter), rootDiameter);
			
			
			return diameter;			
		}
		
		
		
		public static boolean isIdentical(Node root, Node subroot) {
			
			if(root == null && subroot == null) {
				return true;
			} else if(root == null || subroot == null) {
				return false;
			} 
			
			if(root.data == subroot.data) {
				boolean checkLeft = isIdentical(root.left, subroot.left);
				boolean checkRight = isIdentical(root.right, subroot.right);
				
				return checkLeft || checkRight;
			}			
			
			return false;
			
		}
		
		
		
		
		public static boolean isSubroot(Node root, Node subroot) {
			
			if(root == null) {
				return false;
			}
			
			if(root.data == subroot.data) {
				if(isIdentical(root, subroot)) {
					return true;
				}
			}
			
			return isSubroot(root.left, subroot) || isSubroot(root.right, subroot);
			
		}
			
		
		public static class Infox {
			Node node;
			int idx;
			
			public Infox(Node node,int idx) {
				this.node = node;
				this.idx = idx;
			}
			
		}
		
		public static void topViewOfATree(Node root) {
			System.out.println("ggstart");
			
			if(root == null) {
				return;
			}
			
			//for this we have to do level order traversal
			Queue<Infox> q = new LinkedList<>();
			HashMap<Integer, Integer> h = new HashMap<>();
			
			q.add(new Infox(root, 0));
			q.add(null);
			
			int min=0, max=0;
			
			while(!q.isEmpty()) {
				
				Infox x = q.remove();

				if(x == null) {
					if(q.isEmpty()) {
						break;
					} else {
						q.add(null);
					}
				} else {
					if(!h.containsKey(x.idx)) {
						h.put(x.idx, x.node.data);
					}
				}
				
				if(root.left != null) {
					q.add(new Infox(root.left, --min));					
				}
				if(root.right != null) {
					q.add(new Infox(root.right, ++max));
				}
					
				
				
			}
			
			System.out.println("gg");
			
			ArrayList<Integer> sortedKeys = new ArrayList<>(h.keySet());
			
			Collections.sort(sortedKeys);
			
			for (Integer x : sortedKeys)
	            System.out.println("Key = " + x
	                               + ", Value = " + h.get(x));
			
//			h.put(0, root.data);
//			System.out.println(h.get(0));
			
//			while()
			
			
		}
		
		
		
		
	}
	
	
	public static void main(String args[]) {
		int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		
		/*
				 1
			   2   3
			  4 5   6
		*/
		
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTreeUsingPreOrder(nodes);
		
		System.out.println();
		System.out.println("Height of a tree = " +tree.heightOfATree(root));
		
		System.out.println();
		System.out.println("Diameter of a tree1 = " +tree.diameterOfATree(root));
		
		System.out.println();
		System.out.println("Diameter of a tree1 = " +tree.diameterOfATree(root));
		
		Node rootx = new Node(1);
		rootx.left = new Node(2);
		rootx.right = new Node(3);
		rootx.left.left = new Node(4);
		rootx.left.right = new Node(5);
		rootx.right.left = new Node(6);
		rootx.right.right = new Node(7);
		/*
		  		      1
		  		  2      3
		  		4   5  6   7
		 
		 */
		
		System.out.println();
		System.out.println("Diameter of a tree2 = " +BinaryTree.diameterOfATree(rootx));
		
		Node rootx2 = new Node(1);
		rootx2.left = new Node(2);
		rootx2.right = new Node(3);
		rootx2.left.left = new Node(4);
		rootx2.left.left.left = new Node(8);
		rootx2.left.left.left.left = new Node(10);
		rootx2.left.right = new Node(5);
		rootx2.left.right.right = new Node(9);
		rootx2.right.left = new Node(6);
		rootx2.right.right = new Node(7);
		/*
		  		      1
		  		  2      3
		  		4   5  6   7
		  	  8       9
		  	10
		 
		 */
		
		System.out.println();
		System.out.println("Diameter of a tree3 = " +BinaryTree.diameterOfATree(rootx2));
		
		
		
		
		Node subroot = new Node(2);
		subroot.left = new Node(4);
		subroot.right = new Node(50);
		
		System.out.println();
		System.out.println("is Subroot " +BinaryTree.isSubroot(rootx,subroot));
		
		
		System.out.println();
		System.out.println("Top View Of A Tree");
		BinaryTree.topViewOfATree(root);
		
		
	}
	
}
