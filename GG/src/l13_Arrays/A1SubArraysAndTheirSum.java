package l13_Arrays;

public class A1SubArraysAndTheirSum {


	
	public static void printSubArray(int arr[]) {
		
		int max = Integer.MIN_VALUE;
		for(int start=0; start<=arr.length; start++) {
			for(int end=start+1; end<=arr.length; end++) {
				int n = printArray(arr, start, end);
				max = (n>max) ? n : max;
			}
//			System.out.println();
		}
		System.out.println(max);
		
	}

	public static int printArray(int arr[], int start, int end) {
		
		int sum=0;
		for(int i=start; i<end; i++) {
			sum += arr[i];
//			System.out.print(arr[i] +" ");
		}
//		System.out.println();
//		System.out.println("\nsum=" +sum);
		return sum;	//forMaxSumOfSubArray
		
	}
	
	public static void main(String[] args) {
		
//		int arr[] = {2, 4, 6, 8, 10};
		int arr[] = {1, -2, 6, -1, 3};
		
		printSubArray(arr);
		
	}

}
