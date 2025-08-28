package lld.tic_tac_toe.exceptions;

public class EmptyPlayerException extends Throwable {

    public EmptyPlayerException(){
        System.out.println("No players provided. Please provide atleast 2 players.");
    }
}
