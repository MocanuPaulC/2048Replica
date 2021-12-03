import classes.*;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class game2048 {
    public static void main(String[] args) {
        game2048Class game2048Class = new game2048Class();
        Board board = new Board();
        int started=0;
        final Scanner scanner = new Scanner(System.in);
        Screens screen = new Screens();

        //Board board = new Board();
        //board.initialiseSquares();
        //board.getArrayStart();
        Score score =new Score();
        score.setScore();

      /*  for (int i = 0; i < MAXLENGTH; i++) {
            for (int j = 0; j < MAXLENGTH; j++) {
                System.out.printf("[%d, %d ,%d]", values[i][j].getValue(), values[i][j].getX(), values[i][j].getY());
            }
            System.out.println();
        }
*/

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
                    screen.leaderboard();
                    break;
                case "INSTRUCTIONS":
                    screen.instructions();
                    break;
                case "RULES":
                    screen.rules();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}