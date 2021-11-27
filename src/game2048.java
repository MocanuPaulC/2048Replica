import classes.Date;
import classes.Score;
import classes.Screens;
import classes.Square;

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class game2048 {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        Screens screen = new Screens();

        Square square =new Square();
        square.getArray();
/*
        for (int i = 0; i < MAXLENGTH; i++) {
            for (int j = 0; j < MAXLENGTH; j++) {
                System.out.printf("[%d, %d ,%d]",values[i][j].getValue(),values[i][j].getX(),values[i][j].getY());
            }
            System.out.println();
        }*/




        screen.display_title();
        while (true) {
            System.out.println("Write button desired");
            String button = scanner.nextLine();
            switch (button.toUpperCase()) {
                case "START GAME":
                    screen.display_game_board();
                    break;
                case "HOME":
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