package l06_12_Pattern;

import java.util.Scanner;

public class R10Pattern14 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of rows: ");
		int n = sc.nextInt();
		
		
		for(int line=1; line<=2*n-1; line++) {
			for(int column=1; column<=2*n; column++) {
				if(line<=n) {
				 	if(column>n-line && column<n+line) {
				 		System.out.print("* ");
				 	} else {
				 		System.out.print("  ");
				 	}
				 } else {
					 if(column>n-(2*n-line) && column<n+(2*n-line)) {
						 System.out.print("* ");
					 } else {
						 System.out.print("  ");
					 }
				 }
			}
			System.out.println();
		}

		
		/*
		 Output:
			 
		 Enter no. of rows: 4
		 
		       * 				line 1	column 4
		     * * * 				line 2	column 3 4 5
		   * * * * * 			line 3	column 2 3 4 5 6
		 * * * * * * * 			line 4	column 1 2 3 4 5 6 7
		   * * * * * 			line 5	column 2 3 4 5 6 
		     * * * 				line 6	column 3 4 5
		       *				line 7	column`4
		 
		 
		 
		 if(line<=n) {
		 	
		 	if(column>n-line && column<n+line)
		 } else {
		 	
		 	if(column>n-(2*n-line)	||	column<n+(2*n-line)
		 }
		 

		 */
	}

}
