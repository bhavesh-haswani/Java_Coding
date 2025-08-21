package l06_12_Pattern;

import java.util.Scanner;

public class R11Pattern15 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of rows: ");
		int n = sc.nextInt();
		
		int num=1;
		for(int line=1; line<=n; line++, num++) {
			for(int column=1; column<=n; column++) {
				
				if(column>n-line && column<n+line) {
					System.out.print(num +" ");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		
		
		/*
		 Output:
			 
		 Enter no. of rows: 5
		 
		     1
		    2 2
		   3 3 3
		  4 4 4 4 
		 5 5 5 5 5 
		 

		 */
	}

}
