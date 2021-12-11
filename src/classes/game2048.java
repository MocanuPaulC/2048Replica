package classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class game2048 {
    Connection connection;
    private final Screens screen = new Screens();
    private final Board board = new Board();
    private Score score = new Score();
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public game2048(String name, Connection connection) {
        this.name = name;
        this.connection = connection;
    }


    public Board getBoard() {
        return board;
    }

    //this function checks if the game is over
    public void checkEndGame() {
        score.setScore(board.getArray());
        Square[][] squares = board.getArray();
        for (int i = 0; i < board.getMAXLENGTH(); i++) {
            for (int j = 0; j < board.getMAXLENGTH(); j++) {
                if (squares[i][j].getValue() != 0) {
                    if (i == 0) {
                        if (j == 0) {
                            if (squares[i][j].getValue() == squares[i + 1][j].getValue() || squares[i][j].getValue() == squares[i][j + 1].getValue()) {
                                return;
                            }
                        } else if (j == 3) {
                            if (squares[i][j].getValue() == squares[i + 1][j].getValue() || squares[i][j].getValue() == squares[i][j - 1].getValue()) {
                                return;
                            }
                        } else {
                            if (squares[i][j].getValue() == squares[i + 1][j].getValue() || squares[i][j].getValue() == squares[i][j + 1].getValue() || squares[i][j].getValue() == squares[i][j - 1].getValue()) {
                                return;
                            }
                        }

                    }
                    else if(i==3){
                        if (j == 0) {
                            if (squares[i][j].getValue() == squares[i - 1][j].getValue() || squares[i][j].getValue() == squares[i][j + 1].getValue()) {
                                return;
                            }
                        } else if (j == 3) {
                            if (squares[i][j].getValue() == squares[i - 1][j].getValue() || squares[i][j].getValue() == squares[i][j - 1].getValue()) {
                                return;
                            }
                        } else {
                            if (squares[i][j].getValue() == squares[i - 1][j].getValue() || squares[i][j].getValue() == squares[i][j + 1].getValue() || squares[i][j].getValue() == squares[i][j - 1].getValue()) {
                                return;
                            }
                        }
                    }
                    else {
                        if (j == 0) {
                            if (squares[i][j].getValue() == squares[i - 1][j].getValue() || squares[i][j].getValue() == squares[i+1][j].getValue() || squares[i][j].getValue() == squares[i][j + 1].getValue()) {
                                return;
                            }
                        } else if (j == 3) {
                            if (squares[i][j].getValue() == squares[i - 1][j].getValue() ||squares[i][j].getValue() == squares[i + 1][j].getValue() || squares[i][j].getValue() == squares[i][j - 1].getValue()) {
                                return;
                            }
                        } else {
                            if (squares[i][j].getValue() == squares[i - 1][j].getValue() || squares[i][j].getValue() == squares[i][j + 1].getValue() || squares[i][j].getValue() == squares[i][j - 1].getValue()|| squares[i][j].getValue() == squares[i+1][j].getValue()) {
                                return;
                            }
                        }
                    }
                }
                else {
                    return;
                }
            }

        }
        endGame(this.connection);
    }

    //moving squares up
    public void moveSquaresup() {
        Square[][] squares = board.getArray();
        for (int i = 1; i < board.getMAXLENGTH(); i++) {
            for (int j = 0; j < board.getMAXLENGTH(); j++) {
                if (squares[i][j].getValue() != 0) {
                    for (int k = i; k > 0; k--) {
                        if (squares[k][j].getValue() == squares[k - 1][j].getValue()) {
                            squares[k - 1][j].setValue(squares[k][j].getValue() * 2);
                            squares[k][j].setValue(0);

                        }
                        if (squares[k - 1][j].getValue() == 0) {
                            squares[k - 1][j].setValue(squares[k][j].getValue());
                            squares[k][j].setValue(0);
                        }
                    }

                }
            }
        }
        screen.display_game_board(board.getArray());
        checkEndGame();
    }


    //move squares down
    public void moveSquaresdown() {
        Square[][] squares = board.getArray();
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < board.getMAXLENGTH(); j++) {
                if (squares[i][j].getValue() != 0) {
                    for (int k = i; k < board.getMAXLENGTH() - 1; k++) {
                        if (squares[k][j].getValue() == squares[k + 1][j].getValue()) {
                            squares[k + 1][j].setValue(squares[k][j].getValue() * 2);
                            squares[k][j].setValue(0);

                        }
                        if (squares[k + 1][j].getValue() == 0) {
                            squares[k + 1][j].setValue(squares[k][j].getValue());
                            squares[k][j].setValue(0);
                        }
                    }

                }
            }
        }
        screen.display_game_board(board.getArray());
        checkEndGame();
    }

    // move squares left
    public void moveSquaresleft() {
        Square[][] squares = board.getArray();
        for (int j = 1; j < board.getMAXLENGTH(); j++) {
            for (int i = 0; i < board.getMAXLENGTH(); i++) {
                if (squares[i][j].getValue() != 0) {
                    for (int k = j; k > 0; k--) {
                        if (squares[i][k].getValue() == squares[i][k - 1].getValue()) {
                            squares[i][k - 1].setValue(squares[i][k - 1].getValue() * 2);
                            squares[i][k].setValue(0);

                        }
                        if (squares[i][k - 1].getValue() == 0) {
                            squares[i][k - 1].setValue(squares[i][k].getValue());
                            squares[i][k].setValue(0);
                        }
                    }
                }
            }
        }
        screen.display_game_board(board.getArray());
        checkEndGame();
    }

    // move squares right
    public void moveSquaresRight() {
        Square[][] squares = board.getArray();
        for (int j = 2; j >= 0; j--) {
            for (int i = 0; i < board.getMAXLENGTH(); i++) {
                if (squares[i][j].getValue() != 0) {
                    for (int k = j; k < board.getMAXLENGTH() - 1; k++) {
                        if (squares[i][k].getValue() == squares[i][k + 1].getValue()) {
                            squares[i][k + 1].setValue(squares[i][k + 1].getValue() * 2);
                            squares[i][k].setValue(0);

                        }
                        if (squares[i][k + 1].getValue() == 0) {
                            squares[i][k + 1].setValue(squares[i][k].getValue());
                            squares[i][k].setValue(0);
                        }
                    }
                }
            }
        }
        screen.display_game_board(board.getArray());
        checkEndGame();
    }

    public void endGame(Connection connection) {
        DB_manipulator.insertValues(connection, score.getScore(), getName());
        System.out.printf("Game over score: %d name: %s \n", score.getScore(),getName());
        ResultSet resultSet = DB_manipulator.getScores(connection);
        try {
            while (resultSet.next()) {
                System.out.println("High score:" + resultSet.getString(1) +" "+ resultSet.getString(2) +" "+ resultSet.getInt(3));
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
        board.setBoardState(false);
    }


//    public void moveSquares(KeyEvent e) {
//        if (e.getKeyChar() != 'z' && e.getKeyCode() != 38)
//        {
//            for (int i = 0; i < squares.length;i++){
//                for (int j = 0; j < squares.length; j++) {
//                            //GET X is used for to check if it is already at the top, id so dont execute the code
//                    if(squares[i][j].getX() > 0 && squares[FIRST][j].getValue() != 0)
//                    {
//                        squares[i][j]
//                    }
//                    if(squares[i][j].getX() > 0 && squares[SECOND][j].getValue() != 0)
//                    {
//
//                    }
//                    if(squares[i][j].getX() > 0 && squares[THIRD][j].getValue() != 0)
//                    {
//
//                    }
//                    if(squares[i][j].getX() > 0 && squares[FOURTH][j].getValue() != 0)
//                    {
//
//                    }
//                }
//            }
//
//            squares[][]
//        }
//        if (e.getKeyChar() != 's' && e.getKeyCode() != 40)
//        {
//
//        }
//        if (e.getKeyChar() != 'q' && e.getKeyCode() != 37)
//        {
//
//        }
//        if (e.getKeyChar() != 'd' && e.getKeyCode() != 39)
//        {
//
//        }
//
//    }
}
