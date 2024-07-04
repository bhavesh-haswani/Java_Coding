package dec10;

public class A3FindSubsets {

	public static void findSubsets(String str, String ans, int pointer) {
		
		//base case
		if(pointer == str.length()) {
			System.out.println(ans);
			return;
		}
		
		//recursion
		findSubsets(str, ans+str.charAt(pointer), pointer+1);	//yes
		findSubsets(str, ans, pointer+1);	//yes
		
	}
	
	public static void main(String[] args) {
		
		String str = "abc";
		findSubsets(str, "",0);		
		
	}

}
