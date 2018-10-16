

class TicTacToe {

    // Variables to be used
    int[] rowC;
    int[] columnC;
    int diagLeft;
    int diagRight;
    int count;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rowC = new int[n];
        columnC = new int[n];
        diagLeft = 0;
        diagRight = 0;
        count = n;
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        /** Count +1 for player 1 and -1 for player 2
         If a row or a column or a diagonal totals to number of rows (or column, they are equal anyways)
         It's a win for that player */
        
        // Get the player number and assign 1 or -1
        int move = player == 1 ? 1 : -1;
        
        // Add to the row number and column numer
        
        rowC[row] += move;
        columnC[col] += move;
        
        // if move is on left diagonal 
        if(row == col ) diagLeft += move;
        
        // if move is on right diagonal
        if(col == count - row - 1) diagRight += move;
        
        // If the any row or diagonal or column equals to +length of row/column it's player 1
        if(rowC[row] == count || columnC[col] == count || diagLeft == count || diagRight == count) return 1;
        
        // If it's negative, it's player 2
        else if(rowC[row] == -count || columnC[col] == -count || diagLeft == -count || diagRight == -count) return 2;
        
        // else no one
        else return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
