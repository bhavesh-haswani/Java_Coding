package l31_BinaryTrees_3;

import java.util.*;

public class ArrayLIstTest {

	public static void main(String[] args) {
		
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		
		list1.add(1);
		list2 = list1;
		list2.add(2);
		
		System.out.println("list1=" +list1);
		System.out.println("list2=" +list2);
		
	}

}
