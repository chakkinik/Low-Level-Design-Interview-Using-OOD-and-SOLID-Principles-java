package TicToe;

public class Board {

    Square[][] squares;

    Board() {
        squares = new Square[3][3];

      for(int i=0; i<3; i++){
          for(int j=0; j<3; j++){
              squares[i][j]= new Square(i,j);
          }
      }


    }

    public void placeSymbol(int i, int j, Player player) {
        if (i < 0 && i > 2 && j < 0 && j > 2) {
            System.out.println("place is not correct");
            return;

        }

        Square square = squares[i][j];
        square.setSymbol(player.getPlayerSymbol());
    }

    public void printBoard() {
        for(Square[] sq:squares){
            for(Square es:sq){
                System.out.print(""+es.getSymbol()+" !");
            }
            System.out.println("---------------------------------");
        }

    }

    public boolean hasWinner() {

        boolean crossFormed = true;
        // check the row..
        // check the columm
        // check the diagonal
        for (int row = 0; row < 3; row++) {
            if (squares[row][0].getSymbol().equals(squares[row][1].getSymbol()) && squares[row][1].getSymbol().equals(squares[row][2].getSymbol())) {
                return true;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (squares[0][col].equals(squares[1][col]) && squares[1][col].equals(squares[2][col])) {
                return true;
            }
        }

        //diagonal
        if (squares[0][0].getSymbol().equals(squares[1][1].getSymbol()) && squares[1][1].getSymbol().equals(squares[2][2].getSymbol())) {
            return true;
        }

        if (squares[0][2].getSymbol().equals(squares[1][2].getSymbol()) && squares[1][2].getSymbol().equals(squares[2][0].getSymbol())) {
            return true;
        }


        return false;
    }


}
