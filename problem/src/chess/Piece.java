package chess;

public abstract class Piece {
    protected Color pieceColor;

    public abstract boolean canMove(Move move);

}
