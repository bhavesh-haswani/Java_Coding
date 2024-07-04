package nov19;

public class D2DiagonalSum {

	public static void printDiagonalSum(int arr[][]) {
		
		//top-left to bottom-right
//		System.out.println("gg");
		int i=0, j=0, sum=0;
		while(i == j && i<arr.length) {
			sum += arr[i][j];
			i++;
			j++;
		}
		System.out.println("1st diagonal sum=" +sum);
		//top-right to bottom-left
		i=0;
		j=arr[0].length-1;
		int sum2 = 0;
		while(i<arr.length && j<arr.length && i>=0 && j>=0) {
			if(i!=j) {
				sum2 += arr[i][j];
			}
			i++;
			j--;
		}
		
		System.out.println("Diagonal sum2= " +sum2);
		System.out.println("Diagonal sum= " +((int)sum+sum2));
		
	}
	
	public static void print2DArray(int arr[][]) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j] +"\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
//		int arr[][] = new int[4][4];
		int arr[][] = new int[5][5];
		
		int num=0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				arr[i][j] = ++num;
			}
		}
		
		print2DArray(arr);
		printDiagonalSum(arr);
		
	}

}
