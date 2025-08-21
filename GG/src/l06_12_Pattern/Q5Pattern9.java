package l06_12_Pattern;

import java.util.Scanner;

public class Q5Pattern9 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of rows: ");
		int n = sc.nextInt();
		
		int number=1;
		for(int line=1; line<=n; line++) {

			for(int column=1; column<=line; column++, number++) {
				
				System.out.print(number +" ");
				
			}
			System.out.println();
			
		}
		
		/*
		
		 Output:
		 
		 Enter no. of rows: 4
		
		 1
		 2 3
		 4 5 6 
		 7 8 9 10
		 
		 */
	}

}
