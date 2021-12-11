package classes;

public class Score {
    private int score;
    //DONT TOUCH THIS IS TO CALCULATE OUR SCORE IN THE GAME


    public Score() {
    }

    public void setScore(Square[][] squares) {
        this.score=0;
        final int MAXLENGTH = 4;

        for (int i = 0; i < MAXLENGTH; i++) {
            for (int j = 0; j < MAXLENGTH; j++) {
                //CALCULATE TOTAL SCORE BY ADDING UP ALL THE VALUES IN EACH BOX
                this.score += squares[i][j].getValue();
            }
        }
        System.out.println("Score: " +this.score);
    }

    public int getScore() {
       // setScore();
        return score;
    }
}
