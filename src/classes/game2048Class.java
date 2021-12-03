package classes;

import org.w3c.dom.events.Event;

import java.awt.event.KeyEvent;

public class game2048Class {
    private Screens screen = new Screens();
    private final Board board = new Board();
    private final int FIRST = 0;
    private final int SECOND = 1;
    private final int THIRD = 2;
    private final int FOURTH = 3;

    public Board getBoard() {
        return board;
    }

    public void checkSquares() {

    }
    //moving squares up
    public void moveSquaresup() {
        Square[][] squares=board.getArray();
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
        }


    //move squares down
    public void moveSquaresdown(){
        Square[][] squares=board.getArray();
        for(int i = 2 ; i >= 0;i--){
            for(int j = 0 ; j< board.getMAXLENGTH();j++){
                if(squares[i][j].getValue()!=0){
                    for(int k = i; k<board.getMAXLENGTH()-1;k++){
                        if(squares[k][j].getValue()==squares[k+1][j].getValue()){
                            squares[k+1][j].setValue(squares[k][j].getValue()*2);
                            squares[k][j].setValue(0);

                        }
                        if(squares[k+1][j].getValue()==0){
                            squares[k+1][j].setValue(squares[k][j].getValue());
                            squares[k][j].setValue(0);
                        }
                    }

                }
            }
        }
        screen.display_game_board(board.getArray());
    }

    // move squares left
    public void moveSquaresleft(){
        Square[][] squares=board.getArray();
        for( int j = 1 ; j < board.getMAXLENGTH();j++){
            for(int i = 0;i<board.getMAXLENGTH();i++){
                if(squares[i][j].getValue()!=0){
                    for(int k = j ; k >0 ; k--){
                        if(squares[i][k].getValue()==squares[i][k-1].getValue()){
                            squares[i][k-1].setValue(squares[i][k-1].getValue()*2);
                            squares[i][k].setValue(0);

                        }
                        if(squares[i][k-1].getValue()==0){
                            squares[i][k-1].setValue(squares[i][k].getValue());
                            squares[i][k].setValue(0);
                        }
                    }
                }
            }
    }
        screen.display_game_board(board.getArray());
    }

    // move squares right
    public void moveSquaresRight() {
        Square[][] squares=board.getArray();
        for (int j = 2; j >= 0; j--) {
            for (int i = 0; i < board.getMAXLENGTH(); i++) {
                if (squares[i][j].getValue() != 0) {
                    for (int k = j; k < board.getMAXLENGTH()-1; k++) {
                        if(squares[i][k].getValue()==squares[i][k+1].getValue()){
                            squares[i][k+1].setValue(squares[i][k+1].getValue()*2);
                            squares[i][k].setValue(0);

                        }
                        if(squares[i][k+1].getValue()==0){
                            squares[i][k+1].setValue(squares[i][k].getValue());
                            squares[i][k].setValue(0);
                        }
                    }
                }
            }
        }
        screen.display_game_board(board.getArray());
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
