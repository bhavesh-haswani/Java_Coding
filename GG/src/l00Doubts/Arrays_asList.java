package l00Doubts;

import java.util.*;
import com.google.common.primitives.Ints;	//need to import

public class Arrays_asList {

	public static void main(String[] args) {
		
		int arr[] = {1, 2, 3, 4};
		
		System.out.println(arr); 	//[I@65b3120a
		System.out.println(Arrays.toString(arr)); 	//[1, 2, 3, 4]
		
		List<Integer> list = Arrays.asList(1, 2);
		System.out.println(list); 	//[1, 2]
		
		List<int[]> list2 = Arrays.asList(arr);
		System.out.println(list2);	//[[I@65b3120a]
				
		
	}

}
