import classes.Screens;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Screens screen = new Screens();
        screen.display_title();
        while (true) {
            System.out.println("Write button desired");
            String button = scanner.nextLine();
            switch (button) {
                case "START GAME":
                    screen.display_game_board();
                    break;
                case "HOME":
                    screen.display_title();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }

    }
}