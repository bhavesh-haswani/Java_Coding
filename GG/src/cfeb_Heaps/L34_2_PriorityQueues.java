package cfeb_Heaps;

import java.util.*;

public class L34_2_PriorityQueues {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
		
		pq.add(3);
		pq.add(4);
		pq.add(1);
		pq.add(32);
		
		while(!pq.isEmpty()) {
			System.out.println(pq.peek());
			pq.remove();
		}
	}

}
