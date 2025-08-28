package lld.tic_tac_toe;

import lld.tic_tac_toe.entity.*;
import lld.tic_tac_toe.exceptions.EmptyPlayerException;
import lld.tic_tac_toe.exceptions.InvalidBoardSizeException;

import java.util.ArrayList;
import java.util.List;

public class GameInit {

    List<Player> players;
    Board board;
    iTurn turnStrategy;
    iWinner winStrategy;

    public GameInit(GameInitBuilder builder) {
        players =builder.players;
        board = builder.board;
        turnStrategy = builder.turnStrategy;
        winStrategy = builder.winStrategy;
    }

    public static class GameInitBuilder{
        List<Player> players;
        Board board;
        iTurn turnStrategy;
        iWinner winStrategy;

        public GameInitBuilder(int boardSize) throws InvalidBoardSizeException {
            players = new ArrayList<>();
            board = new Board(boardSize);
        }

        public GameInitBuilder addPlayer(String name){
            Player newPlayer = new Player(name);
            newPlayer.setSymbol(GameConfig.SYMBOLS[players.size()]);
            players.add(newPlayer);
            return this;
        }

        public GameInitBuilder addTurnStrategy(iTurn theTurnStrategy){
            turnStrategy = theTurnStrategy;
            return this;
        }

        public GameInitBuilder addTurnStrategy(iWinner theWinStrategy){
            winStrategy = theWinStrategy;
            return this;
        }

        public GameInit build() throws EmptyPlayerException {
            if(turnStrategy==null){
                turnStrategy = new TurnStrategy1(players);
            }
            if(winStrategy == null){
                winStrategy = new WinStrategy1();
            }
            return new GameInit(this);
        }
    }

    public iWinner getWinStrategy() {
        return winStrategy;
    }

    public void setWinStrategy(iWinner winStrategy) {
        this.winStrategy = winStrategy;
    }

    public iTurn getTurnStrategy() {
        return turnStrategy;
    }

    public void setTurnStrategy(iTurn turnStrategy) {
        this.turnStrategy = turnStrategy;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

}
