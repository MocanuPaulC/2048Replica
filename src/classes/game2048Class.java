package classes;

import org.w3c.dom.events.Event;

import java.awt.event.KeyEvent;

public class game2048Class {
    private final Board board = new Board();
    private Square[][] squares = board.getArray();
    private final int FIRST = 0;
    private final int SECOND = 1;
    private final int THIRD = 2;
    private final int FOURTH = 3;


    public void checkSquares() {

    }

    public void moveSquares(KeyEvent e) {
        if (e.getKeyChar() != 'z' && e.getKeyCode() != 38)
        {
            for (int i = 0; i < squares.length;i++){
                for (int j = 0; j < squares.length; j++) {
                            //GET X is used for to check if it is already at the top, id so dont execute the code
                    if(squares[i][j].getX() > 0 && squares[FIRST][j].getValue() != 0)
                    {
                        squares[i][j]
                    }
                    if(squares[i][j].getX() > 0 && squares[SECOND][j].getValue() != 0)
                    {

                    }
                    if(squares[i][j].getX() > 0 && squares[THIRD][j].getValue() != 0)
                    {

                    }
                    if(squares[i][j].getX() > 0 && squares[FOURTH][j].getValue() != 0)
                    {

                    }
                }
            }

            squares[][]
        }
        if (e.getKeyChar() != 's' && e.getKeyCode() != 40)
        {

        }
        if (e.getKeyChar() != 'q' && e.getKeyCode() != 37)
        {

        }
        if (e.getKeyChar() != 'd' && e.getKeyCode() != 39)
        {

        }

    }
}
