package classes;

import java.util.Scanner;

public class Square {
    private int x;
    private int y;
    private int value;
    private final int MAXLENGTH = 4;
    private final Square[][] values = new Square[MAXLENGTH][MAXLENGTH];
    //-------------------------------------------------------GETTER

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getValue() {
        return value;
    }
    //-----------------------------------------------------------setter

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setValue(int value) {
        this.value = value;
    }

    //--------------------------------------Constructor
    public Square(int x, int y, int value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }
    public Square() {
    }


    public void setReset() {
        for (int i = 0; i < MAXLENGTH; i++) {
            for (int j = 0; j < MAXLENGTH; j++) {
                //THIS IS TO RESET THE GAME AND PUT ALL VALUES ON 0
                values[i][j] = new Square(i,j,1);
            }
        }
    }

    public void getArray()
    {
        //THIS IS TO GET THE VALUES FROM ALL SQUARES TO CALCULATE THE SCORE
        Square square = new Square();
        square.setReset();
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values.length; j++) {
                System.out.println(values[i][j]);

            }

        }
    }
    //---------------------------------------------------


}
