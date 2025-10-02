package l00Doubts;

import java.io.*;
import java.util.*;

public class LengthOfStringWithoutUsingLengthMethod {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("Enter your name: ");
		String str = br.readLine();
		System.out.println(str);
		
		//Method 1
		int count = 0;
		char ch[] = str.toCharArray();
		for(char c : ch) {
			count++;
		}
		System.out.println("Length: " +count);
		
		//Method 2
		String s[] = str.split("");
		int countx = 0;
		for(String sx : s) {
			countx++;
		}
		System.out.println("Length: " +countx);
		
	}

}
