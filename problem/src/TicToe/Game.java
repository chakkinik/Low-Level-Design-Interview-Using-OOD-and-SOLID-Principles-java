package TicToe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Game {

    Board board;
    List<Player> players;
    Player curr_turn;
    boolean isMatchOver;
    Player winner;


    Game(List<Player> players) {
        board = new Board();
        this.players = players;

        Player player = players.get(0);
        curr_turn=player;


    }


    public  void startGame(){

        while(!isMatchOver){

            Player curr_player = curr_turn;
            System.out.println("curr turn--+"+curr_player.getId());
            // get the input

            System.out.println("==take input from user");

            Scanner scanner = new Scanner(System.in);
            String input = scanner.next();
            String[] split = input.split("-");
            int i = Integer.parseInt(split[0]);
            int j = Integer.parseInt(split[1]);

            board.placeSymbol(i,j,curr_player);
            board.printBoard();
            boolean b = board.hasWinner();
            if(b){
                System.out.println("curr player is winner"+ curr_player.getId());
                break;
            }
            swithTurn();


        }
        // curr player to mark the symbol board.


    }

    private void swithTurn() {

        Player player = players.get(0).equals(curr_turn) ? players.get(1) : players.get(0);
        curr_turn=player;
    }


    public static void main(String[] args) {

        String cross="cross";
        String oval ="oval";
        Player player1 = new Player(1,cross);
        Player player2 = new Player(2,oval);
        List<Player> list = Arrays.asList(player1, player2);
        Game game = new Game(list);

        game.startGame();
    }




}
