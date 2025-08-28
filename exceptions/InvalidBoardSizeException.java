package lld.tic_tac_toe.exceptions;

public class InvalidBoardSizeException extends Exception {

    public InvalidBoardSizeException(String message){
        System.out.println("Please provide a valid board size! \nThe board size should be in range" + message);
    }
}
