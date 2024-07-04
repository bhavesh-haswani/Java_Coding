package l31_BinaryTrees_3;

import java.util.ArrayList;

import l31_BinaryTrees_3.A31_1_KthLevelOfATree.BinaryTree;
import l31_BinaryTrees_3.A31_1_KthLevelOfATree.Node;

public class A31_5_TransformToSumTree {

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
		
		
		public static boolean getPath(Node root, int data, ArrayList<Node> al) {
			
			if(root == null) {
				return false;
			}

			al.add(root);
			
			
			if(root.data == data) {
				return true;
			} 

			
			boolean left = getPath(root.left, data, al);
			boolean right = getPath(root.right, data, al);				
		
			if(left || right) {
				return true;
			}

			
			al.remove(al.size()-1);
			return false;
			
			
		}
		
		public static Node commonAnsestor(Node root, int n1, int n2) {
			
			if(root == null) {
				return null;
			}
			
			ArrayList<Node> path1 = new ArrayList<>();
			ArrayList<Node> path2 = new ArrayList<>();
			
			getPath(root, n1, path1);
			getPath(root, n2, path2);
			
//			System.out.println(path1);
//			System.out.println(path2);
			
			Node lca = null;
			for(int i=0; i<path1.size(); i++) {
				
				if(path1.get(i).data == path2.get(i).data) {
					lca = path1.get(i);
				} else {
					break;
				}
				
			}
			
			return lca;
//			System.out.println("LCA = " +lca);
			
		}
		
		
		public static int minimumDistance(Node root, int n1, int n2) {
			
			if(root == null) {
				return -1;
			}
			
			
			ArrayList<Node> l1 = new ArrayList<>();
			ArrayList<Node> l2 = new ArrayList<>();
			
			//get PATH
			getPath(root, n1, l1);
			getPath(root, n2, l2);
			
			if(l1.size() == 0 || l2.size() == 0) {
				return -1;
			}
			
			
			for(Node n : l1) {
				System.out.print(n.data +" ");
			}
			System.out.println();
			for(Node n : l2) {
				System.out.print(n.data +" ");
			}
			System.out.println();
			
			//get LCA
			Node lca = null;
			int minimumIndex = -1;
			for(int i=0; i<l1.size(); i++) {
				
				if(l1.get(i).data == l2.get(i).data) {
					lca = l1.get(i);
					minimumIndex = i;
				} else {
					break;
				}
				
			}
			
			int leftMinimumDistance = 0;
			int rightMinimumDistance = 0;
//			System.out.println("minimum index = " +minimumIndex);
//			System.out.println("l1.size()=" +l1.size());
			
			for(int i=minimumIndex; i<l1.size()-1; i++) {
				leftMinimumDistance++;
			}
			for(int i=minimumIndex; i<l2.size()-1; i++) {
				rightMinimumDistance++;
			}
			
			return leftMinimumDistance +rightMinimumDistance;
		}
		
		//myway
		public static int kthAncestorMyWay(Node root, int n, int k) {
			
			if(root == null) {
				return -1;
			}
			
			ArrayList<Node> list = new ArrayList<>();
			getPath(root, n, list);
			
			for(int i=0; i<list.size(); i++) {
				if(list.size() > i+k) {
					if(list.get(i+k).data == n) {
						return list.get(i).data;
					}
				} else {
					System.out.println("kth is greater than tree's height ");
					break;
				}
			}
			
			return -1;
			
		}
		
		
		//Alpha way
		public static int KthAncestor(Node root, int n, int kth) {
		
			if(root == null) {
				return -1;
			}
			
			if(root.data == n) {
				return 0;
			}
			
			
			int leftDist = KthAncestor(root.left, n, kth);
			int rightDist = KthAncestor(root.right, n, kth);
			
			if(leftDist == -1 && rightDist == -1) {
				return -1;
			}
			
			int max = Math.max(leftDist, rightDist);
			
			if(max+1 == kth) {
				System.out.println("Kth node = " +root.data);
//				return root.data;
			}
			
			return max+1;
			
		}

		public static int transformToSumTree(Node root) {
			
			if(root == null) {
				return -1;
			}
			
			int leftSum = transformToSumTree(root.left);
			int rightSum = transformToSumTree(root.right);
			
			if(leftSum == -1 && rightSum == -1) {
				int data = root.data;
				root.data = 0;
				return data;				
			}
			
			if(leftSum == -1) {
				leftSum = 0;
			}
			if(rightSum == -1) {
				rightSum = 0;
			}
			
			int data = root.data;
			root.data = leftSum + rightSum;
			return root.data + data;
			
		}
		
		
		public static void printTree(Node root) {
			
			if(root == null) {
				System.out.print("-1 ");
				return;
			}
			
			System.out.print(root.data +" ");
			printTree(root.left);
			printTree(root.right);
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		int data[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
		
		Node root = BinaryTree.preOrder(data);
		
		Node lca = BinaryTree.commonAnsestor(root, 4, 5);
		System.out.println("LCA = " +lca.data);
		
		int minimumDistance = BinaryTree.minimumDistance(root, 4, 6);
//		System.out.println();
		System.out.println("minimumDistance=" +minimumDistance);
		
		
//		int kthRoot = BinaryTree.KthAncestor(root, 4, 1);
//		System.out.println(kthRoot);
		BinaryTree.KthAncestor(root, 6, 1);
		int kthRoot = BinaryTree.kthAncestorMyWay(root, 4, 2);
		System.out.println("kthRoot=" +kthRoot);
		
		//Transform to Sum Tree
		int gg = BinaryTree.transformToSumTree(root);
		BinaryTree.printTree(root);
		
		
	}

}
