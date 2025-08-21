package l06_12_Pattern;

import java.util.Scanner;

public class Q8Pattern12 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of rows: ");
		int n = sc.nextInt();
		
		
		for(int row=1; row<=n; row++) {
			
			for(int column=1; column<=2*n-1; column++) {
				
				if(column>=n-row+1 && column<=2*n-row) {
					System.out.print("*  ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		
		
		/*
		 Output:
			 
		 Enter no. of rows: 5
		 
		         * * * * * 		line 1 col 5 6 7 8 9 
		       * * * * *		line 2 col 4 5 6 7 8
		     * * * * * 
		   * * * * * 
		 * * * * * 

		formula for column= n*2=> 10	c>=n-line+1	=> 5-1+1=5
													   5-2+1=4
													   this was lower limit
													   
		 what is upper limit of rhombus
		 
		 9		&& c<=2*n-line
		 8
		 7
		 

		 */
	}

}
