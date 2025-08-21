package l06_12_Pattern;

import java.util.Scanner;

public class Q6Pattern10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of rows: ");
		int n = sc.nextInt();
		
		boolean lineValue;
		for(int line=1; line<=n; line++) {

			if(line%2!=0) {
				lineValue = true;
			} else {
				lineValue = false;
			}
			
			for(int column=1; column<=line; column++) {
				
				if(lineValue) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
				
				lineValue = !lineValue;
			}
			System.out.println();
			
		}
		
		/*
		
		 Output:
		 
		 Enter no. of rows: 4
		
		 1			line 1
		 0 1		line 2
		 1 0 1		line 3
		 0 1 0 1	line 4
		 
		 */
	}

}
