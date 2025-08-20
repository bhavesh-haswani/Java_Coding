package l22_Backtracking;

public class A4FindPermutations {

	public static void findPermutations(String str, String ans) {
		/**
		//base case
		if(ans.length() == str.length()) {
			System.out.println(ans);
			return;
		}
		
		//recursion
		findPermutations(str, ans+str.charAt(0));
		findPermutations(str, ans+str.charAt(1));
		findPermutations(str, ans+str.charAt(2));
		**/
		
		//base case
		if(str.length() == 0) {
			System.out.println(ans);
			return;
		}
		
		//recursion
		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			String newStr = str.substring(0, i) +str.substring(i+1);
			findPermutations(newStr, ans+ch);
		}
		
	}
	
	public static void main(String[] args) {
		
		String str = "abc";
		
		findPermutations(str, "");

	}

}
