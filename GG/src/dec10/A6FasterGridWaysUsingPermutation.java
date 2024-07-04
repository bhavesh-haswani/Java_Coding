package dec10;

public class A6FasterGridWaysUsingPermutation {

	public static int factorial(int num) {
		
		if(num == 1) {
			return 1;
		}
		
		return num * factorial(num-1);
		
	}
	
	public static void gridWaysUsingPermutation(int m, int n) {
		
		int numeratorNoob = m-1 + n-1;
		int numeratorFinal = factorial(numeratorNoob);
		int denominatorFinal = factorial(m-1) * factorial(n-1);
		
		System.out.println(numeratorFinal / denominatorFinal);
		
	}
	
	public static void main(String[] args) {
		
		int m = 4, n = 4;
		
		gridWaysUsingPermutation(m, n);
		
	}

}
