package test;

public class A11_FindPermutationOfTheGivenString {

	public static void printPermutation(String str, String res) {
		
		//base case
		if(str.length() == 0) {
			System.out.println(res);
			return;
		}
		
		//recursion
		for(int i=0; i<str.length(); i++) {
					
			String newString = str.substring(0, i) + str.substring(i+1);
			printPermutation(newString, res+str.charAt(i));
		}
		
	}
	
	public static void main(String[] args) {
		
		String str = "abc";
		
		printPermutation(str, "");
		
	}

}
