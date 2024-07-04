package nov19;

public class D3SearchInSortedMatrix {

	public static void searchInSortedMatrix(int arr[][], int value) {
		
		int rowCursor = 0, colCursor = arr[0].length-1;
		
		while(rowCursor < arr.length && colCursor >= 0) {
			if(value == arr[rowCursor][colCursor]) {
				System.out.println(value +" found at index " +rowCursor +"," +colCursor);
				return;
			} else if(value > arr[rowCursor][colCursor]) {
				rowCursor++;
			} else if(value < arr[rowCursor][colCursor]) {
				colCursor--;
			}
		}
		System.out.println(value +" not found");
		
	}
	
	public static void print2DArray(int arr[][]) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.print(arr[i][j] +"\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		int arr[][] = {
				{10, 20, 30, 40},
				{15, 25, 35, 45},
				{27, 29, 37, 48},
				{32, 33, 39, 50}
		};
		
		print2DArray(arr);
		searchInSortedMatrix(arr, 36);
		
		
	}

}
