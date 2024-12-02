package chess;

public class Move {
    private Piece piece;
    private Cell source;
    private Cell destination;


    public Piece getPiece() {
        return piece;
    }

    public Move(MoveBuilder builder) {
        this.piece = builder.piece;
        this.source = builder.source;
        this.destination = builder.destination;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Cell getSource() {
        return source;
    }

    public void setSource(Cell source) {
        this.source = source;
    }

    public Cell getDestination() {
        return destination;
    }

    public void setDestination(Cell destination) {
        this.destination = destination;
    }

    private Move(Piece piece, Cell source, Cell destination) {
        this.piece = piece;
        this.source = source;
        this.destination = destination;
    }

    public static class MoveBuilder {

        MoveBuilder builder;
        private Piece piece;
        private Cell source;
        private Cell destination;

        public MoveBuilder() {
            this.builder = new MoveBuilder();
        }

        public MoveBuilder addPiece(Piece piece) {
            this.piece = piece;
            return this;

        }

        public MoveBuilder addSource(Cell src) {
            this.source = src;
            return this;
        }

        public MoveBuilder addDestination(Cell dest) {
            this.destination = dest;
            return this;
        }

        public Move build() {
            return new Move(this);
        }


    }


}


