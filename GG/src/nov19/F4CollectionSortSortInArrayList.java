package nov19;

import java.util.*;

public class F4CollectionSortSortInArrayList {
	
//	public static void sortArrayList(ArrayList<Integer> list) {
//		
//	}

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		Random rand = new Random();
		for(int i=0; i<10; i++) {
//			list.add(rand.nextInt());
//			output: [-1548641828, 1387039630, -661594166, 750956130, 1694029020, 1886092756, 2072136067, 1162361500, 1388382261, 1110895418]
			list.add(rand.nextInt(10));
		}
		
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
	}

}
