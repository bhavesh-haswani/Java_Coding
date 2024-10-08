package l36Tries;

public class A36_7_PrefixProblem {

	static class Node {

		Node children[] = new Node[26];
		boolean eow;
		int letterInUse;

		Node() {

			for (int i = 0; i < children.length; i++) {
				children[i] = null;
			}

			eow = false;
			letterInUse = 0;
		}
	}

	static Node root = new Node();

//1. Insert ---->
	public static void insert(String word) {

		Node currNode = root;
		char letters[] = word.toCharArray();

		for (int i = 0; i < letters.length; i++) {
			int pointer = letters[i] - 'a';

			if (currNode.children[pointer] == null) {
				currNode.children[pointer] = new Node();
			}
			currNode = currNode.children[pointer];
			currNode.letterInUse++;
			System.out.println("pointer=" + pointer);
			System.out.println("letterInUser=" + currNode.letterInUse);

		}

		currNode.eow = true;

	}

//2. Search ---->	
	public static boolean search(String key) {

		Node currNode = root;
		char letters[] = key.toCharArray();

		for (int i = 0; i < letters.length; i++) {
			int pointer = letters[i] - 'a';

			if (currNode.children[pointer] == null) {
				return false;
			}
			currNode = currNode.children[pointer];
		}

		if (currNode.eow == true) {
			return true;
		}
		return false;
	}

//3. Prefix Algo ---->	
	public static String[] prefixAlgo(String words[]) {

		for (int i = 0; i < words.length; i++) {
			insert(words[i]);
		}

		String allResults[] = new String[words.length];

		for (int i = 0; i < words.length; i++) {
			String result = prefixSearch(words[i]);
			allResults[i] = result;
		}

		return allResults;

	}

//4. Prefix Search	
	public static String prefixSearch(String key) {

		String result = "";

		Node currNode = root;
		char letters[] = key.toCharArray();

		for (int i = 0; i < letters.length; i++) {
			int pointer = letters[i] - 'a';

			if (currNode.children[pointer] == null) {
				return null;
			}
			currNode = currNode.children[pointer];

			result = result + Character.toString((char) pointer + 'a');

			if (currNode.letterInUse == 1) {
				return result;
			}
		}

		return result;
	}

	public static void main(String[] args) {

		String arr[] = { "zebra", "dog", "duck", "dove" };

		/*
		 * for(int i=0; i<arr.length; i++) { insert(arr[i]); }
		 */
//		
//		for(int i=0; i<arr.length; i++) {
//			System.out.println(search(arr[i]));
//		}

		String unique[] = prefixAlgo(arr);
		System.out.println(unique);
		for (int i = 0; i < unique.length; i++) {
			System.out.println(unique[i]);
		}

		System.out.println("---------------------");
		String result = prefixSearch("dog");
		System.out.println(result);
		System.out.println(prefixSearch("dove"));
		System.out.println(prefixSearch("zebra"));
		System.out.println(prefixSearch("duck"));

	}

}
