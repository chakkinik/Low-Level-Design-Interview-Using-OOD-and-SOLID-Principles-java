package TicToe;

import chess.Cell;
import chess.Move;

public class Player {

    private int id;
    private String playerSymbol;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayerSymbol() {
        return playerSymbol;
    }

    public void setPlayerSymbol(String playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public Player(int id, String playerSymbol) {
        this.id = id;
        this.playerSymbol = playerSymbol;
    }


    public Move makeMove(Cell sCell, Cell dCell) {
        Move.MoveBuilder moveBuilder = new Move.MoveBuilder();
        return moveBuilder.addSource(sCell).addDestination(dCell).addPiece(sCell.getPiece()).build();
    }
}
