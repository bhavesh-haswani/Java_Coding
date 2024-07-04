package l31_BinaryTrees_3;

import java.util.ArrayList;

import l31_BinaryTrees_3.A31_1_KthLevelOfATree.BinaryTree;
import l31_BinaryTrees_3.A31_1_KthLevelOfATree.Node;

public class A31_2_LowestCommonAnsestorOftheNodes {

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
		
		
		public static boolean getPath(Node root, int data, ArrayList<Integer> al) {
			
			if(root == null) {
				return false;
			}

			al.add(root.data);
			
			
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
		
		public static void commonAnsestor(Node root, int n1, int n2) {
			
			if(root == null) {
				return;
			}
			
			ArrayList<Integer> path1 = new ArrayList<>();
			ArrayList<Integer> path2 = new ArrayList<>();
			
			getPath(root, n1, path1);
			getPath(root, n2, path2);
			
			System.out.println(path1);
			System.out.println(path2);
			
			int lca = -1;
			for(int i=0; i<path1.size(); i++) {
				
				if(path1.get(i) == path2.get(i)) {
					lca = path1.get(i);
				} else {
					break;
				}
				
			}
			
			System.out.println("LCA = " +lca);
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int data[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1};
		
		Node root = BinaryTree.preOrder(data);
		
		BinaryTree.commonAnsestor(root, 4, 5);
		
		
		
		
		
	}

}
