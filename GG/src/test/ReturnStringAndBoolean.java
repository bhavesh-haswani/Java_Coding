package test;

public class ReturnStringAndBoolean {

	
	public static String exists(String word) {
		
		word  = "gg";
				
		return word;
		
	}
	
	public static char[] exists(char word[]) {
		
		word = "abcdefg".toCharArray();
		return word;
		
	}
	
	public static void main(String[] args) {
		
		/*String word = "xx";
		String gg = exists(word);
		
		System.out.println(word);
		System.out.println(gg);*/
		
		String word = "ggxxggxx";
		char ch[] = word.toCharArray();
		System.out.println(ch);
		char chx[] =exists(ch);
		System.out.println(chx);
				
	}

}
