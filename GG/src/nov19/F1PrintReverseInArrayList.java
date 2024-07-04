package nov19;

import java.util.*;

public class F1PrintReverseInArrayList {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(3);
		list.add(5);
		list.add(7);
		list.add(9);
		
		System.out.println(list);
		
		int arr[] = {1,2,3,4,5};
		System.out.println(arr);	//prints hexadecimal representation of memory address
		
		for(int i=list.size()-1; i>=0; i--) {
			System.out.print(list.get(i) +" ");
		}
	}

}
