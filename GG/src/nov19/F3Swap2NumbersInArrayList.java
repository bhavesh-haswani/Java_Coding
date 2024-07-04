package nov19;

import java.util.*;

public class F3Swap2NumbersInArrayList {

	public static void swap2NumbersInArrayList(ArrayList<Integer> list, int index1, int index2) {
		
		int temp = list.get(index1);
		list.set(index1, list.get(index2));
		list.set(index2, temp);
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			list.add(i);
		}
		
		System.out.println(list);
		swap2NumbersInArrayList(list, 1, 3);
		System.out.println(list);
	}

}
