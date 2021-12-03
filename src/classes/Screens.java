package classes;

public class Screens {
    public Screens() {
    }

    public void display_game_board(Square[][] square) {
        Board board = new Board(true);
        board.setBoardState(true);

        board.setRandomValues(square);
        for (int i = 0; i < square.length; i++) {
            if (i == 0) {
                //TOP BAR FOR LAYOUT
                System.out.print("+----------------------------------------------------------------------------------------------------------------+\t\t\t\t\t\t\t\n" +
                        "|\t\t\t\t\t\t\t\t                                                                       \t\t\t |\t\t\t\t\t\n");
            }
            System.out.print("|");
            for (int j = 0; j < square.length; j++) {
                //THE NUMBER GRID
                System.out.printf("\t\t\t\t\t%d", square[i][j].getValue());
                //LAYOUT
                if (j == 3) {
                    System.out.print("\t\t\t\t\t\t\t\t |\n");
                    if (i != 3) {
                        System.out.println("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t |");
                        System.out.println("|\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t |");
                    }
                }
            }
            if (i == 3) {
                { //BAR ON THE BOTTOM FOR LAYOUT
                    System.out.println("                                                                                \n" +
                            "|                                                                                                                |\n" +
                            "+----------------------------------------------------------------------------------------------------------------+\n");
                }
            }
            System.out.println();
        }
    }

    public void display_title() {
        System.out.println
                ("+-----------------------------+\n" +
                        "|                             |\n" +
                        "|            2048             |\n" +
                        "|          THE GAME           |\n" +
                        "|                             |\n" +
                        "|          GROUP 13           |\n" +
                        "|                             |\n" +
                        "|                             |\n" +
                        "|                             |\n" +
                        "|   START GAME  LEADERBOARD   |\n" +
                        "|   LOAD GAME   INSTRUCTIONS  |\n" +
                        "|                             |\n" +
                        "+-----------------------------+");

    }

    public void leaderboard() {
        System.out.println
                ("+--------------------------------+\n" +
                        "|  HOME\t                         |\n" +
                        "| \t   LEADERBOARD               |\n" +
                        "|     1. NAME 123                |\n" +
                        "|     2. NAME 456                |\n" +
                        "|     3. NAME 789                |\n" +
                        "|     4. ...                     |\n" +
                        "|     5. ...                     |\n" +
                        "|                                |\n" +
                        "|                                |\n" +
                        "|      TYPE HOME TO GO HOME      |\n" +
                        "+--------------------------------+");

    }

    public void rules() {
        System.out.println
                ("+----------------------------------------------------------------------------------------+\n" +
                        "|  HOME                ### The goal of the game is to reach 2048 ###                     |\n" +
                        "|                                                                                        |\n" +
                        "|  ### the boxes with the same value will add eachother when you swipe them together ### |\n" +
                        "|  ### two boxes with different values will not be added ###                             |\n" +
                        "|  ### if there are no spaces left you lose ###                                          |\n" +
                        "|                                                                                        |\n" +
                        "+--------------------------------------------------------------------------------------- +\n" +
                        "\n" +
                        "\n");


    }

    public void instructions() {
        System.out.println
                ("+----------------------------------------------------------------------------------------+\n" +
                        "|   HOME                                    COMMANDS                                     |\n" +
                        "|                        ### Use arrow up to move the boxes upward ###                   |\n" +
                        "|                        ### Use arrow down to move the boxes down ###                   |\n" +
                        "|                      ### Use the arrow left to move all boxes left ###                 |\n" +
                        "|                     ### Use the arrow right to move all boxes right ###                |\n" +
                        "|              ### Type the corresponding word in order to utilise the button ###        |\n" +
                        "|                                                                                        |\n" +
                        "|                                                                                        |\n" +
                        "+----------------------------------------------------------------------------------------+\n");


    }
}

