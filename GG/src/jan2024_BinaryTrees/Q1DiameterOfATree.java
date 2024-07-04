package jan2024_BinaryTrees;

public class Q1DiameterOfATree {
	
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
	
	public static void preOrder(Node root) {
		
		if(root == null) {
			System.out.print("-1 ");
			return;
		}
		
		System.out.print(root.data +" ");
		preOrder(root.left);
		preOrder(root.right);
		
	}
	
	public static int height(Node root) {
		
		if(root == null) {
			return 0;
		}
		
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		
		return Math.max(leftHeight, rightHeight)+1;
		
	}
	
	public static int diameter1(Node root) {
		
		if(root == null) {
			return 0;
		}
		
		int leftHeight = height(root.left);
		int leftDiameter = diameter1(root.left);
		int rightHeight = height(root.right);
		int rightDiameter = diameter1(root.right);
		
		int selfDiameter = leftHeight + rightHeight + 1;
		
		return Math.max(Math.max(leftDiameter, rightDiameter), selfDiameter);
		
	}
	
	public static class Info {
		int diam;
		int height;

		public Info(int diam, int height) {
			this.diam = diam;
			this.height = height;
		}
	}
	
	public static Info diameter(Node root) {
		
		if(root == null) {
			return new Info(0, 0);
		}
		
		Info leftInfo = diameter(root.left);
		Info rightInfo = diameter(root.right);
		
		int diam = Math.max(Math.max(leftInfo.diam, rightInfo.diam), leftInfo.height + rightInfo.height + 1);
		int height = Math.max(leftInfo.height, rightInfo.height) + 1;
		
		return new Info(diam,height);
	}
	
	public static void main(String[] args) {
		int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
		
		Q1DiameterOfATree x = new Q1DiameterOfATree();
		BinaryTree tree = x.new BinaryTree();
		Node root = tree.buildTree(nodes);
		
		preOrder(root);
		
		int height = height(root);
		System.out.println("\nHeight of root = " +height);
		
		int diameter1 = diameter1(root);
		System.out.println("\nDiamter of the Tree = " +diameter1);

		int diameter2 = diameter(root).diam;
		System.out.println("\nDiamter of the Tree = " +diameter2);
		
	}
}
