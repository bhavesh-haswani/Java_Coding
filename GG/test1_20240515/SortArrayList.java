package test1_20240515;

import java.util.*;

public class SortArrayList {

	public static void main(String[] args) {
		
		ArrayList<Integer> al = new ArrayList<>();
		
		al.add(10);
		al.add(3);
		al.add(5);
		al.add(1);
		
		System.out.println(al);
		
		Collections.reverse(al);
		System.out.println(al);
		
		Collections.sort(al);
		System.out.println(al);
		
	}

}