package chess;

public class Cell {
    private Color color;
    private Piece piece;
    private int ith;
    private int jth;

    Cell(Color color, int ith, int jth) {
        this.color = color;
        this.ith = ith;
        this.jth = jth;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
