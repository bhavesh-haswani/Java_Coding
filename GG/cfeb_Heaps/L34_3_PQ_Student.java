package cfeb_Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class L34_3_PQ_Student {

	public static class Student implements Comparable<Student> {
		
		String name;
		int rank;
		
		public Student(String name, int rank) {
			this.name = name;
			this.rank = rank;
		}

		@Override
		public int compareTo(Student s2) {
			return this.rank - s2.rank;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());
		
		pq.add(new Student("A", 6));
		pq.add(new Student("B", 1));
		pq.add(new Student("C", 4));
		pq.add(new Student("D", 3));
		
		while(!pq.isEmpty()) {
			System.out.println(pq.peek().name +" " +pq.peek().rank);
			
			pq.remove();
		}
		
	}

}
