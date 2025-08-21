package l06_12_Pattern;

import java.util.Scanner;

public class Q1Pattern5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of rows: ");
		int n = sc.nextInt();
		
		char ch = 'A';
		for(int line=1; line<=n; line++) {
			for(int number=1; number<=line; number++, ch++) {
				System.out.print(ch +" ");
			}
			System.out.println();
		}
		
		/*
		
		 Output:
		 
		 Enter no. of rows: 4
				
		 A 
		 B C 
		 D E F 
		 G H I J 
		 
		 */
	}

}
