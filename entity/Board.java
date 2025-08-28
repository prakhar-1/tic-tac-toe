package lld.tic_tac_toe.entity;

import lld.tic_tac_toe.GameConfig;
import lld.tic_tac_toe.exceptions.InvalidBoardSizeException;

public class Board {

    private final int size;
    private char[][] blocks;
    private final int max_capacity = GameConfig.BOARD_MAX_CAPACITY;
    private final int min_capacity = GameConfig.BOARD_MIN_CAPACITY;

    public Board(int n) throws InvalidBoardSizeException {
        this.size = n;
        if(!validateBoardSize(n)){
            throw new InvalidBoardSizeException(min_capacity + " : " + max_capacity);
        }
        blocks = new char[n][n];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                blocks[i][j] = ' ';
            }
        }
    }

    public void printBoard(){
        for(int i=0; i<size; i++){
            System.out.print("| ");
            for(int j=0; j<size; j++){
                System.out.print(blocks[i][j] + " |");
            }
            System.out.println();
        }
    }

    public int getSize() {
        return size;
    }

    public char[][] getBlocks() {
        return blocks;
    }

    public boolean validateBoardSize(int n){
        return n>= min_capacity && n<=max_capacity;
    }

    public boolean isValidPosition(int r, int c){
        if(r<0 || r>= size || c<0 || c>=size) return false;
        if(blocks[r][c] != ' ') return false;
        return true;
    }
}
