package lld.tic_tac_toe;

import lld.tic_tac_toe.entity.Player;
import lld.tic_tac_toe.exceptions.EmptyPlayerException;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TurnStrategy1 implements iTurn{
    Queue<Player> playerQueue;

    public TurnStrategy1(List<Player> thePlayers) throws EmptyPlayerException {
        if(thePlayers!=null){
            playerQueue = new LinkedList<>();
            playerQueue.addAll(thePlayers);
        }else{
            throw new EmptyPlayerException();
        }
    }

    @Override
    public Player nextTurn() {
        Player currentPlayer = null;
        if(!playerQueue.isEmpty()){
            currentPlayer = playerQueue.poll();
            playerQueue.add(currentPlayer);
        }
        return currentPlayer;
    }
}
