package l36Tries;

public class A36_6__WordBreakProblem {
	
	static class Node {
		
		Node children[] = new Node[26];
		boolean eow;
		
		Node() {
			for(int i=0; i<children.length; i++) {
				children[i] = null;
			}
			eow = false;
		}
				
	}
	
	static Node root = new Node();
	
	public static void insert(String word) {
		
		Node currNode = root;
		char letters[] = word.toCharArray();
		
		
		for(int i=0; i<letters.length; i++) {
			int pointer = letters[i] - 'a';
			if(currNode.children[pointer] == null) {
				currNode.children[pointer] = new Node();
			}
			currNode = currNode.children[pointer];
		}
		currNode.eow = true;		
		
	}
	
	public static boolean search(String key) {
		
		Node currNode = root;
		char letters[] = key.toCharArray();
		
		for(int i=0; i<letters.length; i++) {
			int pointer = letters[i] - 'a';
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
	
	public static boolean wordBreakAlgo(String key) { 
		
		if(key.length() == 0) { 		
			return true;
		}		
		
		for(int i=1; i<=key.length(); i++) {
			String key1 = key.substring(0, i);
			String key2 = key.substring(i);
			
			boolean isPresentKey1 = search(key1);
			boolean isPresentKey2 = wordBreakAlgo(key2);
			
			if(isPresentKey1 && isPresentKey2) {
				return true;
			}
		}		
		return false;
	}
	
	public static void main(String[] args) {
		
		String[] words = {"i", "like", "sam", "samsung", "mobile", "ice"};
		
		for(int i=0; i<words.length; i++) {
			insert(words[i]);
		}
		
		boolean isPresent;
		
		for(int i=0; i<words.length; i++) {
			isPresent = search(words[i]);
			System.out.println(words[i] +": " +isPresent);
		}
		
		String word = "gmail";
		isPresent = search(word);
		System.out.println(word +": " +isPresent);
		
		
		System.out.println("--Word Break Problem--");
		String key = "ilikesamsung";
		isPresent = wordBreakAlgo(key);
		System.out.println(key +": " +isPresent);
		
		
	}

}
