package lld.tic_tac_toe;

import lld.tic_tac_toe.entity.Board;

public interface iWinner {

    boolean checkWinner(int r, int c, Board board);
    boolean checkDraw(Board board);
}
