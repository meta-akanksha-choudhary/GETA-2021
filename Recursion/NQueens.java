
public class NQueens {
	int N;
	/**
	 * Print the n-queen solution
	 * @param 2-d array solution of n-queen problem
	 */
	void print(int board[][]){
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++)
				System.out.println(" "+board[i][j]+" ");
			System.out.println();
		}
	}
	/**
	 * Check if queen can be placed at this position or not
	 * @param 2-d array of n-queen problem
	 * @param current row and column
	 * @return true if queen can be placed else false
	 */
	boolean isSafe(int board[][],int row,int col){
		int i,j;
		for(i=0;i<col;i++){
			if(board[row][i]==1)
				return false;
		}
		for(i=row,j=col;i>=0 && j>=0;i--,j--){
			if(board[i][j]==1)
				return false;
		}
		for(i=row,j=col;j>=0 && i<N;i++,j--){
			if(board[i][j]==1)
				return false;
		}
		return true;
	}
	/**
	 * Solve n queen problem recursively
	 * @param 2-d array of n-queen problem and current column
	 * @return true if queen can be placed else false
	 */
	boolean solveNQUtil(int board[][],int col){
		if(col>=N)
			return true;
		for(int i=0;i<N;i++){
			if(isSafe(board,i,col)){
				board[i][col]=1;
			if(solveNQUtil(board,col+1)==true)
				return true;
			board[i][col]=0;
			}
			
		}
		return false;
	}
	boolean solveNQ(int n){
		N=n;
		int board[][]=new int[N][N];
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++)
				board[i][j]=0;
		}
		if(solveNQUtil(board,0)==false){
			System.out.println("Solution doesn't exist");
			return false;
		}
		print(board);
		return true;
	}
	public static void main(String args[]){
		NQueens queen=new NQueens();
		System.out.println(queen.solveNQ(4));
	}

}
