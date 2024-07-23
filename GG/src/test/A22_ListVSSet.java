package test;

import java.util.*;

public class A22_ListVSSet {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(5);
		list.add(6);
		list.add(0);
		list.add(4);
		
		System.out.println(list);
		//output: [1, 5, 6, 0, 4]
		
		
		Set<Integer> set = new HashSet<>();
		
		set.add(1);
		set.add(5);
		set.add(6);
		set.add(0);
		set.add(4);
		
		System.out.println(set);
		//output: [0, 1, 4, 5, 6]
		
		
		int arr[] = {1, 5, 6, 0, 4};
		
		System.out.println(arr);
		//output: [I@3f3afe78
				
	}

}
