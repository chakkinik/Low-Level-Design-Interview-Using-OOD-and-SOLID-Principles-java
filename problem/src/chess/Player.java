package chess;

public class Player {
    private String name;
    private Color pieceColor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getPieceColor() {
        return pieceColor;
    }

    public void setPieceColor(Color pieceColor) {
        this.pieceColor = pieceColor;
    }

    public Player(String name, Color pieceColor) {
        this.name = name;
        this.pieceColor = pieceColor;
    }


    public Move makeMove(Cell sCell, Cell dCell) {

        Move.MoveBuilder builder = new Move.MoveBuilder();
        return builder.addPiece(sCell.getPiece()).addDestination(dCell).addSource(sCell).build();

    }
}
