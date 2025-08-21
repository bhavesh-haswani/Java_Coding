package l06_12_Pattern;

import java.util.Scanner;

public class Q3Pattern7 {

	public static void main(String[] args) {
		//Bottom Right Triangle
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of rows: ");
		int n = sc.nextInt();
		
		for(int line=1; line<=n; line++) {

			for(int column=1; column<=n; column++) {
				
//				if(column>=n-line+1 && column<=n) {		//important
				if(column>=n-line+1) {		//important
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
				
			}
			System.out.println();
			
		}
		
		/*
		
		 Output:
		 
		 Enter no. of rows: 4
		
		       * 	line 1 column 4
		     * * 	line 2 column 3, 4
		   * * * 	line 3 column 2, 3, 4
		 * * * *	line 4 column 1, 2, 3, 4
		 
		 */
	}

}
