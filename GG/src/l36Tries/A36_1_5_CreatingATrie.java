package l36Tries;

public class A36_1_5_CreatingATrie {
	
	static class Node {
		
		Node children[] = new Node[26];
		boolean eow;
		
		Node() {
			for(int i=0; i<26; i++) {
				children[i] = null;
//				System.out.print(i +":" +arr[i] +" ");
			}
	
			eow = false;
		}
	}
	
	
	
	static Node root = new Node();
	
	public static void insertWords(String word) {
		
		Node currNode = root;
		
		for(int i=0; i<word.length(); i++) {
			int pointer = word.charAt(i) - 'a';
			
			if(currNode.children[pointer] == null) {
				currNode.children[pointer] = new Node();
			}			
			currNode = currNode.children[pointer];
			
			if(i == word.length()-1) {
				currNode.eow = true;
			}
		}
	}
	
	public static boolean isWord(String word) {
		
		Node currNode = root;
		for(int i=0; i<word.length(); i++) {
			int pointer = word.charAt(i) - 'a';
			
			if(currNode.children[pointer] == null) {
				return false;
			} else {			
				currNode = currNode.children[pointer];
			}
			
			if(i == word.length()-1 && currNode.eow == true) {
				return true;
			}
		}
		
		return false;
	}
	

	public static void main(String[] args) {
		
//		System.out.println('b' - 'a');
		
//		Node node = new Node();
		
		String words[] = {"the", "a", "there", "their", "any", "thee"};
		
		
//		System.out.println(words.length);
		for(int i=0; i<words.length; i++) {
			insertWords(words[i]);
		}
		System.out.println("completed");
		
		boolean isWord = isWord("any");
		System.out.println(isWord);
		
		
	}

}
