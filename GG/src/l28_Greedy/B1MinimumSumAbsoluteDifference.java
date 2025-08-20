package l28_Greedy;

import java.util.Arrays;

public class B1MinimumSumAbsoluteDifference {
	
	public static void main(String args[]) {
		
		int arr1[] = {9, 2, 3};
		int arr2[] = {2, 9, 10};
		
		Arrays.sort(arr1);		
		Arrays.sort(arr2);
		
		int minAbsSum = 0;
		
		for(int i=0; i<arr1.length; i++) {
			minAbsSum += Math.abs(arr1[i] - arr2[i]);
		}
		
		System.out.println("Minimum Absolute Sum = " +minAbsSum);
	}
}
