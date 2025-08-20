package l34_Heaps;

import java.util.*;

public class L34_ToDeleteInAHeap {
	
	public static class Heap {
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		public void add(int data) {
			
			arr.add(data);
			
			int curridx = arr.size()-1;
			int paridx = (curridx-1)/2;
			
			while(arr.get(curridx) < arr.get(paridx)) {
				
				int temp = arr.get(curridx);
				arr.set(curridx, arr.get(paridx));
				arr.set(paridx, temp);
				
				curridx = paridx;
				paridx = (curridx-1)/2;
				
			}
			
			
		}
		
		public void print() {
			System.out.println(arr.toString());
		}
		
		//this method removes root i.e. min element from the tree
		public int remove() {
			
			//swap root with leaf node
			int data = arr.get(0);
			
			int temp = data;
			arr.set(0, arr.get(arr.size()-1));
			arr.set(arr.size()-1, temp);
			
			//remove leaf node
			arr.remove(arr.size()-1);
			
			//since now root is swapped and now the tree is not min-heap nor max heap
			//we will heapify
			heapify(0);
			
			//return Removed data
			return data;
		}
		
		public void heapify(int idx) {
			
			if(idx > arr.size()-1) {
				return;
			}
			
			int lNode = 2*idx + 1;
			int rNode = 2*idx + 2;
			int minNode = idx;
			
			if(lNode < arr.size() && arr.get(lNode) < arr.get(minNode)) {
				minNode = lNode;
			}
			
			if(rNode < arr.size() && arr.get(rNode) < arr.get(minNode)) {
				minNode = rNode;
			}
			
			//swap root with min child node
			if(arr.get(idx) != arr.get(minNode)) {
				int temp = arr.get(idx);
				arr.set(idx, arr.get(minNode));
				arr.set(minNode, temp);				

				heapify(minNode);
			}
			
//			heapify(lNode);
//			heapify(rNode);
			
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
		
		System.out.println(h.remove());
		h.print();
		
	}

}
