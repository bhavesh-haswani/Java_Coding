package l36Tries;

public class A36_9_UniqueSubstrings {

	static class Node {
		
		Node children[] = new Node[26];
		boolean eow;
		
		Node() {
			for(int i=0; i<children.length; i++) {
				children[i] = null;
				eow = false;
			}
		}
	}
	
	
	static Node root = new Node();
	
	public static void insert(String word) {
		
		Node currNode = root;
		char letters[] = word.toCharArray();
		int pointer;
		
		for(int i=0; i<letters.length; i++) {
			
			pointer = letters[i] - 'a';
			if(currNode.children[pointer] == null) {
				currNode.children[pointer] = new Node();
			}
			currNode = currNode.children[pointer];
		}
		
		currNode.eow = true;  
			
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Hello");
		
		
		
	}

}


