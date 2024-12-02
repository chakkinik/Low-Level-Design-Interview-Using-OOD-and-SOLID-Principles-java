package chess;

import java.util.Objects;

public class Board {

    Cell[][] cells;
    Piece queen;
    Cell queenCell;

    Board() {
        cells = new Cell[8][8];

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                if (j % 2 == 0) {
                    cells[i][j] = new Cell(Color.WHITE, i, j);
                } else {
                    cells[i][j] = new Cell(Color.WHITE, i, j);
                }
            }
        }

        placePiece();

    }

    private void placePiece() {


    }

    public boolean validateMove(Move move) {
        Piece piece = move.getPiece();
        //validation logic on the bais of piece
        if (Objects.isNull(piece)) {
            System.out.println("invalid move");
            return false;
        }

        if (!piece.canMove(move)) {
            return false;
        }

        return true;


    }

    public void makeMove(Move move) {
        Piece piece = move.getPiece();
        Cell destination = move.getDestination();
        destination.setPiece(piece);
        move.getSource().setPiece(null);
    }

    public boolean checkMate(Player currPlayer) {
        int kingX = -1, kingY = -1;

        // Find the king's position
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Piece piece = cells[x][y].getPiece();
                if (piece instanceof King && piece.pieceColor == currPlayer.getPieceColor()) {
                    kingX = x;
                    kingY = y;
                    break;
                }
            }
        }

        // Check if any opponent piece can attack the king
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Piece piece = cells[x][y].getPiece();
                if (piece != null && piece.pieceColor != currPlayer.getPieceColor() )
                //    piece.isValidMove(board, x, y, kingX, kingY)) {
                return true;
            }
        }

        return false;
    }

    // find the king position..
    // then check king is attacted by other oppnent piece


}



