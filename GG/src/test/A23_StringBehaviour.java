package test;

public class A23_StringBehaviour {

	public static void main(String[] args) {
		
		String str1 = "John";
		
		String str2 = "John";
		
		String str3 = new String("John");
		System.out.println(str3);
		
		
		if(str1 == str2) {
			System.out.println("true");
		}
		
		if(str1 == str3) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
				
		
		
	}

}
