package classes;

import org.w3c.dom.events.Event;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class game2048Class {
    Connection connection;
    private Screens screen = new Screens();
    private final Board board = new Board();
    private String date;
    private int score = 0;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public game2048Class(String name, Connection connection) {
        this.name = name;
        this.connection = connection;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Board getBoard() {
        return board;
    }

    //this function checks if the game is over
    public void checkSquares() {
        int cnt = 0;
        setScore(0);
        Square[][] squares = board.getArray();
        for (int i = 0; i < board.getMAXLENGTH(); i++) {
            for (int j = 0; j < board.getMAXLENGTH(); j++) {
                if (squares[i][j].getValue() != 0) {
                    cnt++;
                    int scoreToSet=getScore()+squares[i][j].getValue();
                    setScore(scoreToSet);
                }
            }
        }
        if (cnt == 15) {
            endGame(this.connection);
        }
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
        checkSquares();
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
        checkSquares();
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
        checkSquares();
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
        checkSquares();
    }

    public void endGame(Connection connection) {
        Date date = new Date();
        date.setDate("");
        String datevalue = date.getDate();
        System.out.println("values not inserted");
        DB_manipulator.insertValues(connection, getScore(), getName(), datevalue);
        System.out.println("values inserted");
        System.out.printf("Game over score: %d name: %s \n", this.getScore(),getName());
        ResultSet resultSet = DB_manipulator.getScores(connection);
        try {
            while (resultSet.next()) {
                System.out.println("High score:\n" + resultSet.getString(1) +" "+ resultSet.getString(2) +" "+ resultSet.getInt(3));
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
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
