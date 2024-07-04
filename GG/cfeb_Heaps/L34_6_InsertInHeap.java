package cfeb_Heaps;

import java.util.*;

public class L34_6_InsertInHeap {
	
	public static class Heap {
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		public void add(int data) {
			
			//add at last index
			arr.add(data);
			
			//Heap should be either min-Heap or max-Heap
			//so we have to kinda sort the heap with added data
			
			int x = arr.size()-1;	//child index
			int par = (x-1)/2;		//parent index
			
			while(arr.get(x) < arr.get(par)) {
				
				int temp = arr.get(x);
				arr.set(x, arr.get(par));
				arr.set(par, temp);
				
				x = par;
				par = (x-1)/2;
				
			}
			

		}
		
		
		public void print() {
			System.out.println(arr.toString());
		}
		
		public int peek() {			//L34_7
			return arr.get(0);
		}
				
	}
	
	public static void main(String[] args) {
		
		Heap h = new Heap();
		
		h.add(5);
		h.add(2);
		h.add(6);
		h.add(10);
		h.add(9);
		h.add(1);
		h.add(0);
		
		h.print();
		
		System.out.println(h.peek());
		
	}

}
