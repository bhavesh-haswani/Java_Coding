package test;

public class FindSubsetsOfTheGivenString {

	public static void printSubsets(String str, String res, int pointer) {
		
		//base case
		if(pointer == str.length()) {
			System.out.println(res);
			return;
		}
		
		
		//recursion
		printSubsets(str, res+str.charAt(pointer), pointer+1);	//Y
		printSubsets(str, res, pointer+1);	//N
		
	}
	
	
	public static void main(String[] args) {
		
		String str = "abc";
		
		printSubsets(str, "", 0);
		
	}

}
