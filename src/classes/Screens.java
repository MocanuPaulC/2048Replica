package classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Screens {
    DB_manipulator db_manipulator = new DB_manipulator();

    public Screens() {
    }

    public void display_game_board(Square[][] square) {
        Board board = new Board(true);
        board.setBoardState(true);

        System.out.println("Wireframe <gameboard>");

        board.setRandomValues(square);
        System.out.println("Type restart to restart the game");
        System.out.println("Type save game to save the current state of the game");

        for (int i = 0; i < square.length; i++) {
            if (i == 0) {
                //TOP BAR FOR LAYOUT
                System.out.print("+-----------------------+\n" +
                        "|\t  |\t    |\t  |\t    |\n");
            }
            System.out.print("|");
            for (int j = 0; j < square.length; j++) {
                //THE NUMBER GRID
                if(j<3) {
                    System.out.printf(" %-4d|", square[i][j].getValue());
                }
                else{
                    System.out.printf("\t%-4d", square[i][j].getValue());
                }
                //LAYOUT
                if (j == 3) {
                    System.out.print("|\n");
                    if (i != 3) {

                        System.out.print("|\t  |\t    |\t  |\t    |\n");
                        System.out.print("+-----------------------+\n");
                        System.out.print("|\t  |\t    |\t  |\t    |");

                    }
                }
            }
            if (i == 3) {
                { //BAR ON THE BOTTOM FOR LAYOUT
                    System.out.print(
                            "|\t  |\t    |\t  |\t    |\n" +
                            "+-----------------------+\n");
                }
            }
            System.out.println();

        }
        System.out.println("""
                    Type up to move the boxes upward
                    Type down to move the boxes down
                    Type left to move all boxes left
                    Type right to move all boxes right""");
    }

    public void display_title() {
        System.out.println
                ("""
                        Wireframe <title page>
                        +-------------------------------------------+
                        |                                           |
                        |                    2048                   |
                        |                  THE GAME                 |
                        |                                           |
                        |                  GROUP 13                 |
                        |                                           |
                        |                                           |
                        |                                           |
                        |           START GAME  LEADERBOARD         |
                        |                  LOAD GAME                |
                        |                                           |
                        |                                           |
                        |      TYPE START GAME TO START PLAYING     |
                        |     TYPE LOAD GAME TO GO TO LOAD A GAME   |
                        |         TYPE RULES TO GO TO RULES         |
                        |  TYPE INSTRUCTIONS TO GO TO INSTRUCTIONS  |
                        |   TYPE LEADERBOARD TO GO TO LEADERBOARD   |
                        |                                           |
                        |                                           |
                        +-------------------------------------------+""");

    }

    public void leaderboard(Connection connection) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a name to search for scores(type 'a' to see all scores)");
        String input =  scanner.nextLine();
        if(input.equals("a")) {
            int score = 0;
            String name = "";
            String date = "";
            int cnt = 1;
            StringBuilder row = new StringBuilder();
            ResultSet resultSet = DB_manipulator.getScores(connection);
            try {
                System.out.println("Wireframe <leaderboard>");

                System.out.print
                        ("+-----------------------------------+\n" +
                                "|    LEADERBOARD \t                |\n" +
                                "| \t                                |\n");
                while (resultSet.next()) {

                    row.setLength(0);
                    name = resultSet.getString(1);
                    date = resultSet.getString(2);
                    score = resultSet.getInt(3);
                    row.append(cnt).append(". ").append(name).append(" ").append(score).append(" ").append(date);
                    System.out.printf("| %-34s|\n", row);
                    cnt++;
                }
                System.out.print("|                                   |\n" +
                        "|                                   |\n" +
                        "|      TYPE HOME TO GO HOME         |\n" +
                        "+-----------------------------------+\n");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else {

        }
    }


    public void rules() {
        System.out.println
                ("""
                        Wireframe <rules>
                        +----------------------------------------------------------------------------------------+
                        |                      ### The goal of the game is to reach 2048 ###                     |
                        |                                                                                        |
                        |  ### the boxes with the same value will add eachother when you swipe them together ### |
                        |  ### two boxes with different values will not be added ###                             |
                        |  ### if there are no spaces left you lose ###                                          |
                        |                                                                                        |
                        |                                                                                        |
                        |                               TYPE HOME TO GO TO HOME                                  |
                        +--------------------------------------------------------------------------------------- +
                        """);


    }

    public void instructions() {
        System.out.println
                ("""
                        Wireframe <commands>
                        +------------------------------------------------------------------------------------------+
                        |                                           COMMANDS                                       |
                        |                      ### Use arrow up to move the boxes upward ###                       |
                        |                      ### Use arrow down to move the boxes down ###                       |
                        |                    ### Use the arrow left to move all boxes left ###                     |
                        |                   ### Use the arrow right to move all boxes right ###                    |
                        |            ### Type the corresponding word in order to utilise the button ###            |
                        |                                                                                          |
                        |                                                                                          |
                        |                                    TYPE HOME TO GO TO HOME                               |
                        +------------------------------------------------------------------------------------------+
                        """);


    }
}

