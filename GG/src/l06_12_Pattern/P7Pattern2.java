package l06_12_Pattern;

import java.util.Scanner;

public class P7Pattern2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of rows: ");
		int n = sc.nextInt();
		
		for(int line=1; line<=n; line++) {
			for(int star=1; star<=line; star++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		
		/*
		
		 Output:
		 
		 Enter no. of rows: 4
				
		 * 
		 * * 
		 * * * 
		 * * * *  

		 */
	}

}
