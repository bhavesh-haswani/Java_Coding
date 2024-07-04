package test;

public class PrintNQueenBoards {

	public static boolean chessRulesFollowed(char board[][], int row, int col) {
		
		//horizontal line <-
		for(int i=col; i>=0; i--) {
			if(board[row][i] == 'Q') {
				return false;
			}
		}
		
		//vertical line
		for(int i=row; i>=0; i--) {
			if(board[i][col] == 'Q') {
				return false;
			}
		}
		
		//diagonal left
		for(int i=row, j=col; i>=0 && j>=0; i--, j--) {
			if(board[i][j] == 'Q') {
				return false;
			}
		}

		//diagonal right
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
		for(int column=0; column<board.length; column++) {
			
			if(chessRulesFollowed(board, row, column)) {	
				board[row][column] = 'Q';
				nQueens(board, row+1);			
				board[row][column] = '.';
			}
		}
		
		
	}
	
	public static void printBoard(char ch[][]) {
		System.out.println("----Chess Board----");
		for(int i=0; i<ch.length; i++) {
			for(int j=0; j<ch.length; j++) {
				System.out.print( ch[i][j] +" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		int n = 5;
		char board[][] = new char[n][n];
		
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board.length; j++) {
				board[i][j] = '.';
			}
		}
		
		printBoard(board);
		nQueens(board, 0);
		
	}

}
