package lld.tic_tac_toe;

import lld.tic_tac_toe.entity.Board;

public class WinStrategy1 implements iWinner{
    @Override
    public boolean checkWinner(int r, int c, Board board) {
        int n = board.getSize();
        char[][] blocks = board.getBlocks();
        boolean row=true;
        boolean col=true;
        boolean diag1=true;
        boolean diag2=true;
        for(int i=1; i<n; i++){
            if(blocks[r][i]!=blocks[r][i-1]){
                row = false;
                break;
            }
        }
        for(int i=1; i<n; i++){
            if(blocks[i][c] != blocks[i-1][c]){
                col = false;
                break;
            }
        }
        if(r-c!=0) {
            diag1 = false;
        }else{
            for(int i=1; i<n; i++){
                if(blocks[i-1][i-1] != blocks[i][i]){
                    diag1 = false;
                    break;
                }
            }
        }
        if(r+c != n-1){
            diag2 = false;
        }else{
            for(int i=1; i<n; i++){
                if(blocks[i-1][n-1-i+1] != blocks[i][n-1-i]){
                    diag2 = false;
                    break;
                }
            }
        }
        return row || col || diag1 || diag2;
    }

    public boolean checkDraw(Board board){
        int n = board.getSize();
        char[][] blocks = board.getBlocks();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(blocks[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }
}
