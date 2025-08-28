package lld.tic_tac_toe.entity;

import lld.tic_tac_toe.GameInit;
import lld.tic_tac_toe.PlayGame;
import lld.tic_tac_toe.exceptions.EmptyPlayerException;
import lld.tic_tac_toe.exceptions.InvalidBoardSizeException;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        GameInit game = null;
        GameInit.GameInitBuilder builder = null;
        PlayGame playGame = null;
        System.out.println("Give the size of the Board!");
        while(true){
            try {
                int size = scanner.nextInt();
                scanner.nextLine();
                builder = new GameInit.GameInitBuilder(size);
                break;
            } catch (InvalidBoardSizeException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("How many players are playing?");
        int n = scanner.nextInt();
        scanner.nextLine();
        for(int i=0; i<n; i++){
            System.out.println("Enter player name: ");
            String name = scanner.nextLine();
            builder.addPlayer(name);
        }

        try {
            game = builder.build();
        } catch (EmptyPlayerException e) {
            throw new RuntimeException(e);
        }
        playGame = new PlayGame(game);
        playGame.startGame();
    }
}
