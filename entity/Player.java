package lld.tic_tac_toe.entity;

public class Player {
    private final String player;


    private Character symbol;

    public Player(String name){
        this.player = name;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    public Character getSymbol() {
        return symbol;
    }

    public String getPlayer() {
        return player;
    }
}
