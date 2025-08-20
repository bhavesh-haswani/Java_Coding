package l28_Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class F1ChocolaProblem {

	public static void main(String[] args) {
		//here, we are given a choclate with 4 rows and 6 cols
		//and below is the cost for each cut resp.
		
		int rows = 4, cols = 6;
		
		Integer verticalCost[] = {2, 1, 3, 1, 4};
		Integer horizontalCost[] = {4, 1, 2};
		
		Arrays.sort(verticalCost, Comparator.reverseOrder());
		Arrays.sort(horizontalCost, Comparator.reverseOrder());
		
		int horizontalCounter = 0, verticalCounter = 0;
		int horizontalPieces = 1, verticalPieces = 1;
		int cost = 0;
		
		while(horizontalCounter<horizontalCost.length && verticalCounter<verticalCost.length) {
			if(horizontalCost[horizontalCounter] > verticalCost[verticalCounter]) {
				cost = cost + horizontalCost[horizontalCounter] * verticalPieces;
				horizontalCounter++;
				horizontalPieces++;
			} else {
				cost = cost + verticalCost[verticalCounter] * horizontalPieces;
				verticalCounter++;
				verticalPieces++;
			}
		}
		
		while(horizontalCounter<horizontalCost.length) {
			cost = cost + horizontalCost[horizontalCounter] * verticalPieces;
			horizontalCounter++;
			horizontalPieces++;
		}
		
		while(verticalCounter<verticalCost.length) {
			cost = cost + verticalCost[verticalCounter] * horizontalPieces;
			verticalCounter++;
			verticalPieces++;
		}
		
		System.out.println("Total cost = " +cost);
		
	}

}
