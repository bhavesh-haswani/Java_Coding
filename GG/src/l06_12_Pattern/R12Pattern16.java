package l06_12_Pattern;

import java.util.Scanner;

public class R12Pattern16 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of rows: ");
		int n = sc.nextInt();
		
		for(int line=1; line<=n; line++) {
			int varLine=line;
			for(int column=1; column<=2*n-1; column++) {
				if(column>n-line && column<n+line) {
					System.out.print(varLine +" ");
					if(column<n) {
						varLine--;
					} else {
						varLine++;
					}
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		/*
		 Output:
			 
		 Enter no. of rows: 5
		 
		         1				line 1	col 5
		       2 1 2			line 2	col 4 5 6
		     3 2 1 2 3 			line 3	col 3 4 5 6 7
		   4 3 2 1 2 3 4 		line 4	col 2 3 4 5 6 7 8
		 5 4 3 2 1 2 3 4 5 		line 5	col 1 2 3 4 5 6 7 8 9
		 
		 no. start
		 
		 n-line+1=> 5
		 
		 col>n-line && col<n+line

		 */
	}

}
