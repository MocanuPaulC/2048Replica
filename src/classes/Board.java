package classes;

import java.util.Random;

public class Board {
    private boolean boardState;
    private final int MAXLENGTH = 4;
    private Square[][] values = new Square[MAXLENGTH][MAXLENGTH];
    private final Random random = new Random();

    public int getMAXLENGTH() {
        return MAXLENGTH;
    }

    public boolean isBoardState() {
        return boardState;
    }

    public void setBoardState(boolean boardState) {
        this.boardState = boardState;
    }

    public Board(boolean boardState) {
        setBoardState(boardState);
    }

    public Board() {

    }

    public void initialiseSquares() {
        for (int i = 0; i < MAXLENGTH; i++) {
            for (int j = 0; j < MAXLENGTH; j++) {
                //THIS IS TO RESET THE GAME AND PUT ALL VALUES ON 0

                values[i][j] = new Square(i, j, 0);

            }
        }
    }

    public void setRandomValues(Square[][] square) {
        //THIS IS TO RESET THE GAME AND PUT ALL VALUES ON 0
        values=square;
        int x;
        int y;
        final int origin = 0;
        final int bound = 4;

        System.out.println("here works1");
        for (int i = 0; i < 2; i++) {
            while (true) {
                x = random.nextInt(origin, bound);
                y = random.nextInt(origin, bound);
                if (values[x][y].getValue() == 0) {
                    //sets value to random choice of 2 or 4
                        if (random.nextInt(1, 3) == 1) {
                            System.out.println("here works2");
                            values[x][y].setValue(2);
                            System.out.println(values[x][y].getValue());

                        } else {
                            values[x][y].setValue(4);
                            System.out.println("here Staworks3");
                        }
                    System.out.println("here works4");
                    break;
                }
            }
        }

    }

    public void setReset() {
        for (int i = 0; i < MAXLENGTH; i++) {
            for (int j = 0; j < MAXLENGTH; j++) {
                //THIS IS TO RESET THE GAME AND PUT ALL VALUES ON 0
                values[i][j].setValue(0);
            }
        }
    }


    public Square[][] getArrayStart() {
        //THIS IS TO GET THE VALUES FROM ALL SQUARES TO CALCULATE THE SCORE AND INITIALISE THE GAME
        initialiseSquares();
        return values;
    }
    public Square[][] getArray() {
        //THIS IS TO GET THE VALUES FROM ALL SQUARES TO CALCULATE THE SCORE

        return values;
    }


}
