package l06_12_Pattern;

import java.util.Scanner;

public class Q4Pattern8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of rows: ");
		int n = sc.nextInt();
		
		for(int line=1; line<=n; line++) {

			for(int column=1; column<=n-line+1; column++) {
				
				System.out.print(column +" ");
				
			}
			System.out.println();
			
		}
		

		/*
		
		 Output:
		 
		 Enter no. of rows: 5
		
		 1 2 3 4 5 
		 1 2 3 4 
		 1 2 3 
		 1 2 
		 1 
		 
		 */
	}

}
