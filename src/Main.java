import classes.*;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Input name:");
        name =scanner.nextLine();
        Player player = new Player(name);


        Connection connection = DB_manipulator.initializeDatabase();

        game2048 game2048 = new game2048(player.getName(),connection);

        Screens screen = new Screens();
        game2048.getBoard().setBoardState(false);

        screen.display_title();
        while (true) {
            System.out.println("Write button desired");
            String button = scanner.nextLine();
            switch (button.toUpperCase()) {
                case "UP":
                    if(game2048.getBoard().isBoardState()){
                        game2048.moveSquaresup();
                    }
                    break;
                case "DOWN":
                    if(game2048.getBoard().isBoardState()){
                        game2048.moveSquaresdown();
                    }
                    break;
                case "LEFT":
                    if(game2048.getBoard().isBoardState()){
                        game2048.moveSquaresleft();
                    }
                    break;
                case "RIGHT":
                    if(game2048.getBoard().isBoardState()){
                        game2048.moveSquaresRight();
                    }
                    break;
                case "START GAME":
                    if(!game2048.getBoard().isBoardState()) {


                        game2048.getBoard().initialiseSquares();
                        game2048.getBoard().setBoardState(true);

                        screen.display_game_board(game2048.getBoard().getArray());
                    }
                    break;
                case "HOME":
                    if(!game2048.getBoard().isBoardState()){
                        screen.display_title();
                    }
                    break;
                case "LEADERBOARD":
                    if(!game2048.getBoard().isBoardState()){
                        screen.leaderboard(connection);
                    }
                    break;
                case "INSTRUCTIONS":
                    if(!game2048.getBoard().isBoardState()){
                        screen.instructions();
                    }
                    break;
                case "RULES":
                    if(!game2048.getBoard().isBoardState()){
                        screen.rules();
                    }
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}