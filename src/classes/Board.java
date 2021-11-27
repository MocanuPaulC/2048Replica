package classes;

public class Board {
    private boolean boardState;

    public boolean isBoardState() {
        return boardState;
    }

    public void setBoardState(boolean boardState) {
        this.boardState = boardState;
    }

    public Board(boolean boardState) {
        setBoardState(boardState);
    }
}
