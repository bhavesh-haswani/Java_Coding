package l06_12_Pattern;

import java.util.Scanner;

public class Q7Pattern11 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter no. of rows: ");
		int n = sc.nextInt();
		
//		for(int line=1; line<=n*2; line++) {
//			
//			for(int column=1; column<=n*2; column++) {
//
//				System.out.print("*");
//			}
//			System.out.println();
//			
//		}
		
		//part1
		for(int line=1; line<=n; line++) {
			for(int column=1; column<=line; column++){
				
				System.out.print("* ");
			}
			System.out.println();
		}
		
		//part2
		for(int line=n; line>=1; line--) {
			for(int column=line; column>=1; column--){
				
				System.out.print("* ");
			}
			System.out.println();
		}
		

		//part3
		System.out.println("\n\n");
		for(int line=1; line<=n; line++) {
			for(int column=1; column<=n; column++) {
				if(column>=n-line+1) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		
		
		//part4
		System.out.println("\n\n");
		for(int line=n; line>=1; line--) {
			for(int column=1; column<=n; column++) {
				if(column>n-line) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		
		/*


		 	      * 	line 1		column 4		column>n-line
		 	    * *		line 2		column 3,4
		 	  * * *		line 3		column 2,3,4
		 	* * * *		line 4
		 	
		 */
		
		
		//part5
		System.out.println("\n\nPART-5\n\n\n");
		for(int line=1; line<=n*2; line++) {
			for(int column=1; column<=n*2; column++) {
				if(line<=n) {							//part1-top-left
					if(column<=n) {
						if(column<=line) {
							System.out.print("* ");
						} else {
							System.out.print("  ");
						}
					} else if(column>n) {				//part2-top-right
//						if(column-n>=n-line+1) {
						if(column>=n*2-line+1) {
							System.out.print("* ");
						} else {
							System.out.print("  ");
						}
					}
				} else if(line>n) {
					if(column<=n) {						//part3-bottom-left
						if(column<=n*2-line+1) {
							System.out.print("* ");
						} else {
							System.out.print("  ");
						}
					} else if(column>n){				//part4-bottom-right
						if(column>=n*2-(n*2-line)) {
							//is se acha line hee likh leta 
							//me bhi na kuch bhi karta hu
							System.out.print("* ");
						} else {
							System.out.print("  ");
						}
					}
					
				}
			}
			System.out.println();
		}
		

		
		
		
		//part3-bottom-left
		/*
		 	* * * * 		l=5 c=1 2 3 4		c<=(8-5+1)=4
		 	* * *   		l=6 c=1 2 3			c<=(8-6+1)=3
		 	* *     		l=7 c=1 2					  =2
		 	*       		l=8 c=1 					  =1
		 
		 
		 	line>n will cover bottom portion	c<=n wiil cover left portion	i.e. bottom left
		 	
		 	formula for c will be
		 	if(c<=n && c<=(n*2-line+1))
		 	
		 	
		 //part4-bottom-right	
		 	
		 	
		 	* * * * 		l=5		c=5 6 7 8	c>(8-5+1)=4
		 	  * * * 		l=6		c=6 7 8		c>(8-6+1)=5
		 	    * * 		l=7		c=7 8 				c>6
		 	      * 		l=8		c=8					c>7
		 	
		 	
		 	line>n will cover bottom portion	c>n will cover right portion
		 	
		 	formula for c will be
		 	
		 	if(c>n &&	c>n*2=>8-(n*2-line) => 8-3 => 5
		 										8-2 =>6
		 
		 	
		 */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		 Output:
			 
		 Enter no. of rows: 4
		
		 *             *	line 1		column 1 and column 8
		 * *         * *	line 2		column 1,2 and column 7,8
		 * * *     * * *	line 3
		 * * * * * * * *	line 4
		 * * * * * * * *	line 5		c=1 2 3 4	c<=n
		 * * *     * * *	line 6		c=1 2 3 	
		 * *         * *	line 7		c=1 2
		 *             *	line 8


		 */
	}

}
