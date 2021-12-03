package classes;

public class Score {
    private int score;
    //DONT TOUCH THIS IS TO CALCULATE OUR SCORE IN THE GAME

    public void setScore() {
        Board board = new Board();
        final int MAXLENGTH = 4;
        Square[][] square = board.getArrayStart();

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                //CALCULATE TOTAL SCORE BY ADDING UP ALL THE VALUES IN EACH BOX
                this.score += square[i][j].getValue();
            }
        }
        System.out.println(this.score);
    }

    public int getScore() {
       // setScore();
        return score;
    }
}
