package lld.tic_tac_toe;

import lld.tic_tac_toe.entity.*;

import java.util.Scanner;

public class PlayGame {
    GameInit game;
    Scanner scanner;

    public PlayGame(GameInit theGame){
        game = theGame;
        scanner = new Scanner(System.in);
    }

    public void changeGame(GameInit newGame){
        game = newGame;
    }

    public void startGame() throws InterruptedException {
        printWelcomeScreen();
        while(true){
            Thread.sleep(1000);
            game.board.printBoard();
            Player currPlayer = game.turnStrategy.nextTurn();
            printChooseIndex(currPlayer.getPlayer());
            int row=-1, col=-1;
            while(true){
                row = scanner.nextInt();
                col = scanner.nextInt();
                if(game.board.isValidPosition(row, col)){
                    game.board.getBlocks()[row][col] = currPlayer.getSymbol();
                    break;
                }else{
                    printInvalidPosition();
                }
            }
            if(game.winStrategy.checkWinner(row, col, game.board)){
                printWinner(currPlayer);
                Thread.sleep(1500);
                game.board.printBoard();
                break;
            }
            if(game.winStrategy.checkDraw(game.board)){
                printDraw();
                Thread.sleep(1500);
                game.board.printBoard();
                break;
            }
        }
        printEndScreen();
    }

    private void printInvalidPosition() {
        System.out.println("Invalid position chosen! Try a non-taken block.");
    }

    private void printDraw() {
        System.out.println("The game is drawn. Well Played!");
    }

    private void printWinner(Player currPlayer) {
        System.out.println("Player " + currPlayer.getPlayer() + " has won the game");
    }

    private void printChooseIndex(String name) {
        System.out.println(name + " please choose row and columns(in order): ");
    }

    private void printEndScreen() {
        System.out.println("Thanks for playing! \nSee you again!");
    }

    private void printWelcomeScreen(){
        System.out.println("WELCOME TO TIC-TAC-TOE!");
        System.out.println("sponsored by SGN members!!");
        System.out.println("Players : Symbols");
        for(int i=0;i<game.players.size(); i++){
            System.out.println(game.players.get(i).getPlayer() + " \t:\t " + game.players.get(i).getSymbol());
        }
        System.out.println("STARTING THE GAME");
    }

}
