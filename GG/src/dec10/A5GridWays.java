package dec10;

public class A5GridWays {

	public static int gridWays(int i, int j, int m, int n) {
		
		//base case
		if(i == m-1 && j == m-1) {
			return 1;
		} else if(i == m || j == n) {
			return 0;
		}
		
		
		//recursion
		int w1 = gridWays(i+1, j, m, n);
		int w2 = gridWays(i, j+1, m, n);
		return w1 + w2;
		
	}
	
	public static void main(String[] args) {
		
		int m, n;
		m = n = 2;
		
		int ways = gridWays(0, 0, m, n);	
		System.out.println(ways);
		
	}

}
