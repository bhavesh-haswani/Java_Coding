package l36Tries;

public class A36_910_LongestWordWithAllPrefix {

	static class Node {

		Node children[] = new Node[26];
		boolean eow;
		char ch;

		Node() {
			for (int i = 0; i < 26; i++) {
				children[i] = null;
			}
			eow = false;
		}
	}

	static Node root = new Node();

//----> 1. insert
	public static void insert(String word) {

		Node currNode = root;
		char letters[] = word.toCharArray();
		int pointer;

		for (int i = 0; i < letters.length; i++) {
			pointer = letters[i] - 'a';

			if (currNode.children[pointer] == null) {
				currNode.children[pointer] = new Node();
				currNode.children[pointer].ch = letters[i];
			}
			currNode = currNode.children[pointer];
		}

		currNode.eow = true;
	}

//----> 2. Search	
	public boolean search(String key) {

		Node currNode = root;
		char letters[] = key.toCharArray();
		int pointer;

		for (int i = 0; i < letters.length; i++) {
			pointer = letters[i] - 'a';

			if (currNode.children[pointer] == null) {
				return false;
			}
			currNode = currNode.children[pointer];
		}

		return currNode.eow == true;
	}

//---->3. LongestWordWithAllPrefix
	public static String longestWordWithAllPrefix(String words[]) {
		
		//insert words in Trie
		for(int i=0; i<words.length; i++) {
			insert(words[i]);
		}
		
		//longestWord code
//		String longestWordWithAllPrefix = "";
		Node currNode = root;
		longestWord(currNode, "");
		
		return longestWord;
	}
	
	public static String longestWord = "";
	
//---->4. longestWord
	public static void longestWord(Node currNode, String temp) {
		
		for(int i=0; i<26; i++) {
			
			if(currNode.children[i] != null && currNode.children[i].eow == true) {
					
					temp += (char)(i + 'a');
					System.out.println(temp);
					if(temp.length() > longestWord.length()) {
						longestWord = temp;
					}
					longestWord(currNode.children[i], temp);
					temp = temp.substring(0, temp.length()-1);
					
			}
		}
		
	}
	
	
//----> MAIN	
	public static void main(String[] args) {

		String words[] = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		
		String longestWordWithAllPrefix =  longestWordWithAllPrefix(words);
		System.out.println("----------------");
		System.out.println(longestWordWithAllPrefix);
		
	}

}
