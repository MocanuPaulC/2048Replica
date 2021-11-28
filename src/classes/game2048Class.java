package classes;

import org.w3c.dom.events.Event;

import java.awt.event.KeyEvent;

public class game2048Class {
    private final Board board = new Board();
    private Square[][] squares = board.getArray();

    public void checkSquares()
    {

    }
    public void moveSquares(KeyEvent e) {
        if (e.getKeyChar() != 'z' && e.getKeyCode() != 38) {
            if (e.getKeyChar() != 's' && e.getKeyCode() != 40) {
                if (e.getKeyChar() != 'q' && e.getKeyCode() != 37) {
                    if (e.getKeyChar() != 'd' && e.getKeyCode() != 39) {
                        if (e.getKeyCode() == 10) {

                        }
                    } else {

                    }
                } else {

                }
            } else {

            }
        } else {

        }
    }
}
