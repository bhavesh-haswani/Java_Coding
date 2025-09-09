package l00Doubts;

import java.util.Arrays;

public class Streams {

	public static void main(String[] args) {
		
		int numbers[] = {6, 7, 8, 2, 3, 4, 5};
		
		int min = Arrays.stream(numbers).min().getAsInt();
		
		System.out.println(min);
	}

}
