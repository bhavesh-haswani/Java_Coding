package jan2024_BinaryTrees;

import java.util.*;

public class P4_CountOfNodes {
	
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
	
	public class BinaryTree {
		
		static int idx = -1; 
		public static Node buildTree(int nodes[]) {
			
			idx++;
			if(nodes[idx] == -1) {
				return null;
			}
			
			Node root = new Node(nodes[idx]);
			root.left = buildTree(nodes);
			root.right = buildTree(nodes);
			
			return root;
		}
		
	}
	
	public static void levelOrder(Node root) {
		
		if(root == null) {
			return;
		}
		
		Queue<Node> q = new LinkedList<>();
		
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			
			Node currNode = q.remove();
			
			if(currNode != null) {
				System.out.print(currNode.data +" ");
				if(currNode.left != null) {
					q.add(currNode.left);
				}
				if(currNode.right != null) {
					q.add(currNode.right);
				}
			} else {
				if(q.isEmpty()) {
					break;
				} else {
					System.out.println();
					q.add(null);
				}
			}
			
		}
		
	}
	
	public static int height(Node root) {
		
		if(root == null) {
			return 0;
		}
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		return Math.max(leftHeight, rightHeight) + 1; 
		
	}
	
	public static int countOfNodes(Node root) {
		
		if(root == null) {
			return 0;
		}
		
		int countOfLeftNodes = countOfNodes(root.left);
		int countOfRightNodes = countOfNodes(root.right);
		
		return countOfLeftNodes + countOfRightNodes + 1;
		
	}
	
	public static void main(String[] args) {
		
		int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		
		P4_CountOfNodes gg = new P4_CountOfNodes(); 
		BinaryTree tree = gg.new BinaryTree();
		Node root = tree.buildTree(nodes);
		levelOrder(root);
		
		int height = height(root);
		System.out.println("\nheight = " +height);
		
		int noOfNodes = countOfNodes(root);
		System.out.println("noOfNodes = " +noOfNodes);
		
	}

}
