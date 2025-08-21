package l06_12_Pattern;

import java.util.Scanner;

public class Q2Pattern6 {

	public static void main(String[] args) {
		//Hollow Square
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of rows: ");
		int n = sc.nextInt();
		
		for(int line=1; line<=n; line++) {

			for(int number=1; number<=n; number++) {
				
				if(line==1 || line==n) {
					System.out.print("* ");
				} else {
					if(number==1 || number==n) {
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
		
		 * * * * 
		 *     * 
		 *     * 
		 * * * *
		 
		 */
		
		
	}

}
