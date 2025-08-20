package l28_Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class A01FractionalKnapsack {

	public static void main(String[] args) {
		
		int values[] = {60, 100, 120};
		int weight[] = {10, 20, 30};
		
		int W = 50;
		
		//in this we have to find take the things which have more value but less weight
		//eg. here we will first find the ratio
		
		double ratio2DArray[][] = new double[values.length][2];
		
		for(int i=0; i<values.length; i++) {
			ratio2DArray[i][0] = i;
			ratio2DArray[i][1] = values[i] / (double)weight[i];
		}
		
		
//		System.out.println("Printing ration 2D Array before sorting");
//		for(int i=0; i<ratio2DArray.length; i++) {
//			System.out.println(ratio2DArray[i][0] +" " +ratio2DArray[i][1] );
//		}

		Arrays.sort(ratio2DArray, Comparator.comparingDouble(o -> o[1]));
		
//		System.out.println("Printing ration 2D Array");
//		for(int i=0; i<ratio2DArray.length; i++) {
//			System.out.println(ratio2DArray[i][0] +" " +ratio2DArray[i][1] );
//		}
		
		int weightRemaining = W;
		double totalValuesEarned = 0;
		for(int i=values.length-1; i>=0; i--) {
			
			if(weight[(int)ratio2DArray[i][0]] <= weightRemaining) {
				weightRemaining -= weight[(int)ratio2DArray[i][0]];
				totalValuesEarned += values[(int)ratio2DArray[i][0]];
				System.out.println("T1" +totalValuesEarned);
			} else {
				totalValuesEarned += ratio2DArray[i][1] * weightRemaining;
				System.out.println("T2" +totalValuesEarned);
				break;
			}
		}
		
		System.out.println("Total Values earned = " +totalValuesEarned);
		
	}

}
