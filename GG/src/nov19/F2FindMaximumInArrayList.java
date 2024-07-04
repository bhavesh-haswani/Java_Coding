package nov19;

import java.util.*;

public class F2FindMaximumInArrayList {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(9);
		list.add(7);
		list.add(10);
		list.add(3);
		list.add(1);
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<list.size()-1; i++) {
//			if(list.get(i) > max) {
//				max = list.get(i);
//			}
			max = Math.max(max, list.get(i));
		}
		
		System.out.println("Max is " +max);
		
	}

}
