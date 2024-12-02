package chess;


import java.util.Scanner;

public class Game {

    private Board board;
    private Player player1;
    private Player player2;
    Player currTurn;
    Player winner;


    Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;

        currTurn = player1;

        while (winner == null) {
            Scanner scanner = new Scanner(System.in);
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int di = scanner.nextInt();
            int dj = scanner.nextInt();
            Cell sCell = board.cells[i][j];
            Cell dCell = board.cells[di][dj];
            Move move = player1.makeMove(sCell, dCell);
            if (board.validateMove(move)) {
                board.makeMove(move);
                boolean b = board.checkMate(currTurn);
                if (b) {
                    winner = currTurn;
                }
                currTurn = currTurn.equals(player1) ? player2 : player1;
            }


        }


    }

}
