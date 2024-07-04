package jan2024_Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

public class C1MaxLengthChainOfPairs {

	public static void main(String[] args) {
		
		int pairs[][] = {{5,24}, {39,60}, {5,28}, {27,40}, {50,90}};
		
		//form the max chain where A pair (c, d) come after the pair (a, b) if b < c
		
//		System.out.println(pairs.length);

		int the2DSortedArray[][] = new int[pairs.length][3];
		
		for(int i=0; i<pairs.length; i++) {
			the2DSortedArray[i][0] = i;
			the2DSortedArray[i][1] = pairs[i][0];
			the2DSortedArray[i][2] = pairs[i][1];
		}
		
		Arrays.sort(the2DSortedArray, Comparator.comparingInt(o -> o[2]));
		
		for(int i=0; i<pairs.length; i++) {
			System.out.println(the2DSortedArray[i][0] +" " +the2DSortedArray[i][1] +" " +the2DSortedArray[i][2]);
		}
		
		ArrayList<Integer> arrList = new ArrayList<>();
		arrList.add(the2DSortedArray[0][0]);
		
		int lastEnd = the2DSortedArray[0][2];
		for(int i=1; i<pairs.length; i++) {
			if(the2DSortedArray[i][1] > lastEnd) {
				lastEnd = the2DSortedArray[i][2];
				arrList.add(the2DSortedArray[i][0]);
			}
			
		}
		
		System.out.println(arrList);
		
		
		
	}

}
