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
	
	public static boolean search(String key) {
		
		Node currNode = root;
		int pointer;
		char letters[] = key.toCharArray();
		
		for(int i=0; i<letters.length; i++) {
			pointer = letters[i] - 'a';
			
			if(currNode.children[pointer] == null) {
				return false;
			}
			currNode = currNode.children[pointer];
		}
		
		if(currNode.eow == true) {
			return true;
		}
		
		return false;
	}
	
//count of UniqueSubstrings
	public static int count(Node currNode) {
		if(currNode == null) {
			return 0;
		}
		
		int count = 0;
		
		for(int i=0; i<26; i++) {
			if(currNode.children[i] != null) {
				count += count(currNode.children[i]);
			}
		}
		
		return count+1;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("Hello");
		
		/*
		String words[] = {"the", "a", "there", "their", "any", "thee"};
		
		for(int i=0; i<words.length; i++) {
			insert(words[i]);
		}
		
		for(int i=0; i<words.length; i++) {
			System.out.println(search(words[i]));
		}
		
		System.out.println(search("dolphil"));
		*/
		
		//UniqueSubstrings;
		
		String word = "ababa";
		for(int i=0; i<word.length(); i++) {
			insert(word.substring(i));
		}
		
		Node currNode = root;
		
		int countOfUniqueSubstrings = count(currNode);
		System.out.println(countOfUniqueSubstrings);
				
		
	}

}


