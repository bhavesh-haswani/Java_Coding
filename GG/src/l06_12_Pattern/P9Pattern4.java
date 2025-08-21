package l06_12_Pattern;

import java.util.Scanner;

public class P9Pattern4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of rows: ");
		int n = sc.nextInt();
		
		for(int line=1; line<=n; line++) {
			for(int number=1; number<=line; number++) {
				System.out.print(number +" ");
			}
			System.out.println();
		}
		
		/*
		
		 Output:
		 
		 Enter no. of rows: 4
				
		 1 
		 1 2 
		 1 2 3 
		 1 2 3 4 
		 
		 */
		
		
		
	}

}
