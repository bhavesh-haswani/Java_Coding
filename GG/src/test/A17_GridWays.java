package test;

public class A17_GridWays {
	
	public static int prinNoOfWaysInGrid(int a, int b, int m, int n) {
		
		//base case
		if(a == m-1 && b == n-1) {
			return 1;
		} else if(a == m || b == n) {
			return 0;
		}
		
		
		//recursion
		int way1 = prinNoOfWaysInGrid(a+1, b, m, n);
		int way2 = prinNoOfWaysInGrid(a, b+1, m, n);
		int res = way1 + way2;
		return res;
		
	}
	
	public static void main(String[] args) {
		
		int m = 3, n = 3;
		
		int ways = prinNoOfWaysInGrid(0, 0, m, n);		
		System.out.println("Ways = " +ways);
		
	}

}
