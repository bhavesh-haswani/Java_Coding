package l22_Backtracking;

public class A12NQueensAllWaysWithCheck {

	public static boolean isValid(char board[][], int row, int col) {
		
		//vertical up
		for(int i=row; i>=0; i--) {
			if(board[i][col] == 'Q') {
				return false;
			}
		}
		
		//diagonal top left
		for(int i=row, j=col; i>=0 && j>=0; i--, j--) {
			if(board[i][j] == 'Q') {
				return false;
			}
		}
		
		//diagonal top right
		for(int i=row, j=col; i>=0 && j<board.length; i--, j++) {
			if(board[i][j] == 'Q') {
				return false;
			}
		}
		
		return true;
	}

	public static void nQueens(char board[][], int row) {
		
		//base case
		if(row == board.length) {
			printBoard(board);
			return;
		}
		
		//recursion
		for(int col=0; col<board.length; col++) {
			
			if(isValid(board, row, col)) {
				board[row][col] = 'Q';
				nQueens(board, row+1);
				board[row][col] = '.';
			}
			
			if(row == board.length-1 && col == board.length-1) { 
				nQueens(board, row+1);
			}
		}
//		printBoard(board);
		
	}	
	
	public static void printBoard(char board[][]) {
		
		System.out.println("----Chess Board----");
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				System.out.print(board[i][j] +" ");
			}
			System.out.println();
		}
		
	}
	
	public static void main(String[] args) {
		
		int n = 4;
		char board[][] = new char[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = '.';				
			}
		}
		
		printBoard(board);
		nQueens(board, 0);
		
	}

}
