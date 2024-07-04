package dec10;

public class SudokuAgain {

	public static boolean isNumberValid(int sudoku[][], int num, int i, int j) {
		
		//same row
		for(int a=0; a<sudoku.length; a++) {
			if(sudoku[i][a] == num) {
				return false;
			}
		}
		
		//same col
		for(int a=0; a<sudoku.length; a++) {
			if(sudoku[a][j] == num) {
				return false;
			}
		}
		
		//same 3 x 3 cube
		
		//finding 3x3 cube
		int rangex = i/3; //i/3;
		int rangey = j/3;
		
		int startx = 3*rangex;
		int starty = 3*rangey;
		
		int endx = startx+3;
		int endy = starty+3;
		
		for(int a=startx; a<endx; a++) {		
			for(int b=starty; b<endy; b++) {
				if(sudoku[a][b] == num) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static boolean solveSudoku(int sudoku[][], int row, int col) {
		
		//base case
		/**if(row == sudoku.length-1 && col == sudoku.length-1) {
			printSudoku(sudoku);
			return;
		} else if(row >= sudoku.length || col >= sudoku.length) {
			return;
		}**/
		if(row == sudoku.length && col == 0 ) {
			//printSudoku(sudoku);
			System.out.println("gg");
			return true;
		} 
		
		//recursion
		int nextRow = row, nextCol = col+1;
		if(nextCol == sudoku.length) {
			nextRow = row+1;
			nextCol = 0;
		}
		
		if(sudoku[row][col] !=0) {
			return solveSudoku(sudoku, nextRow, nextCol);
		}
		
		for(int digit=1; digit<=9; digit++) {
			
//			if(sudoku[row][col] == 0) {
				if(isNumberValid(sudoku, digit, row, col)) {
					sudoku[row][col] = digit;
					if(solveSudoku(sudoku, nextRow, nextCol)) {
						return true;
					}
					sudoku[row][col] = 0;
				}
//			} 
		}
		
//		printSudoku(sudoku);/
		return false;
		
	}
	
	public static void printSudoku(int sudoku[][]) {
		
		for(int i=0; i<sudoku.length; i++) {
			for(int j=0; j<sudoku.length; j++) {
				System.out.print(sudoku[i][j] +" ");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		
		int sudoku [][] = {
				{0,0,8,0,0,0,0,0,0},
				{4,9,0,1,5,7,0,0,2},
				{0,0,3,0,0,4,1,9,0},				
				{1,8,5,0,6,0,0,2,0},
				{0,0,0,0,2,0,0,6,0},
				{9,6,0,4,0,5,3,0,0},				
				{0,3,0,0,7,2,0,0,4},
				{0,4,9,0,3,0,0,5,7},
				{8,2,7,0,0,9,0,1,3},
		};
		
		System.out.println("------SUDOKU------");
		printSudoku(sudoku);
		System.out.println();
		System.out.println("------ANSWER------");
		if(solveSudoku(sudoku, 0, 0)) {
			printSudoku(sudoku);
		}
	}

}
