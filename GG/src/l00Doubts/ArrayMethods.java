package l00Doubts;

import java.util.Arrays;

public class ArrayMethods {

	public static void main(String[] args) {
		
//		int arr[][] = new int[5][5];
		int arr[][] = {{1,2}, {3,4}};
		
		System.out.println(arr);	//[[I@65b3120a

		System.out.println(Arrays.toString(arr));	//[[I@6f539caf, [I@79fc0f2f]
		
		System.out.println(Arrays.deepToString(arr));	//[[1, 2], [3, 4]]
		
		System.out.println();
	}

}
