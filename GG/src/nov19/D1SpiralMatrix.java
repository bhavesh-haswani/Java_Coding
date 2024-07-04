package nov19;

public class D1SpiralMatrix {
	
	public static void printSpiralMatrix(int arr[][]) {
		
		int startRow = 0;
		int endRow = arr.length-1;
		int startColumn = 0;
		int endColumn = arr[0].length-1;
		int cursorRow = 0, cursorColumn = 0;
		
		while(endRow > startRow && endColumn > startColumn) {
		//left to right
			for(int j=cursorColumn; j<=endColumn; j++) {
				System.out.print(arr[cursorRow][cursorColumn] +" ");
				cursorColumn++;
			}
			cursorColumn--;
			cursorRow++;
			System.out.println("cursorRow=" +cursorRow +" cursorColumn=" +cursorColumn);
			//top to bottom
			for(int i=cursorRow; i<=endRow; i++) {
				System.out.print(arr[cursorRow][cursorColumn] +" ");
				cursorRow++;
			}
			cursorRow--;
			cursorColumn--;
			System.out.println("cursorRow=" +cursorRow +" cursorColumn=" +cursorColumn);
			
			//right to left
			for(int j=cursorColumn; j>=startColumn; j--) {
				System.out.print(arr[cursorRow][cursorColumn] +" ");
				cursorColumn--;
			}
			cursorColumn++;
			cursorRow--;
			System.out.println("cursorRow=" +cursorRow +" cursorColumn=" +cursorColumn);
			
			//bottom to top
			for(int i=cursorRow; i>startRow; i--) {
				System.out.print(arr[cursorRow][cursorColumn] +" ");
				cursorRow--;
			}
			cursorRow++;
			cursorColumn++;
			System.out.println("cursorRow=" +cursorRow +" cursorColumn=" +cursorColumn);
			
			startRow++;
			endRow--;
			startColumn++;
			endColumn--;
		}
	}
	
	
	
	public static void print2DArr(int arr[][]) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[i][j] +"\t");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		int arr[][] = new int[4][4];
		
		System.out.println("arr.length=" +arr.length);
		
		int num = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				arr[i][j] = ++num;
			}
		}
		
		print2DArr(arr);
		
		//expected output:1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
		printSpiralMatrix(arr);
		
		
		

	}

}
