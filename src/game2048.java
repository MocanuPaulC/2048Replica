import classes.*;

import java.lang.invoke.SwitchPoint;
import java.sql.Connection;
import java.util.Scanner;

public class game2048 {
    public static void main(String[] args) {
        String name;
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Input name:");
        name =scanner.nextLine();

        int started=0;
        Connection connection = DB_manipulator.initializeDatabase();
        game2048Class game2048Class = new game2048Class(name,connection);
        Screens screen = new Screens();

        //Board board = new Board();
        //board.initialiseSquares();
        //board.getArrayStart();
        Score score =new Score();
        score.setScore();

        screen.display_title();
        while (true) {
            System.out.println("Write button desired");
            String button = scanner.nextLine();
            switch (button.toUpperCase()) {
                case "UP":
                    game2048Class.moveSquaresup();
                    break;
                case "DOWN":
                    game2048Class.moveSquaresdown();
                    break;
                case "LEFT":
                    game2048Class.moveSquaresleft();
                    break;
                case "RIGHT":
                    game2048Class.moveSquaresRight();
                    break;
                case "START GAME":
                    if(started==0) {

                        game2048Class.setScore(0);
                        started=1;
                        int counter = 0;
                        if (counter == 0 ){
                            game2048Class.getBoard().initialiseSquares();
                            counter++;
                        }
                        screen.display_game_board(game2048Class.getBoard().getArray());
                    }
                    break;
                case "HOME":
                    started=0;
                    screen.display_title();
                    break;
                case "LEADERBOARD":
                    screen.leaderboard(connection);
                    break;
                case "INSTRUCTIONS":
                    screen.instructions();
                    break;
                case "RULES":
                    screen.rules();
                    break;
                case "INSERT":
                    DB_manipulator.insertValues(connection,123,"Paul","2021-12-03");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}