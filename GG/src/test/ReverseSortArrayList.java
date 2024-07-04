package test;

import java.util.*;

public class ReverseSortArrayList {

	public static void main(String[] args) {
		
		ArrayList<Integer> al = new ArrayList<>();
		
		al.add(3);
		al.add(1);
		al.add(2);
		al.add(4);
		
		System.out.println(al);
		
		Collections.sort(al);
		System.out.println(al);
		
		Collections.reverse(al);
		System.out.println(al);
		
		System.out.println();
		Collections.binarySearch(al, null);
		
		
		
	}

}
