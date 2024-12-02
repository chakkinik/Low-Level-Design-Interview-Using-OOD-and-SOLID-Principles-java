package chess;

public class King extends Piece{
    @Override
    public boolean canMove(Move move) {
        return false;
    }
}
