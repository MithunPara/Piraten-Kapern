package pk;

public class Game {
    private Player player1, player2;
    public Game(){
        player1 = new Player();
        player2 = new Player();
    }

    public void run(){
        player1.turn();
//        System.out.print("Player 1 scored: " + player1.getScore());
        player2.turn();
//        System.out.print("Player 2 scored: " + player2.getScore());
    }
}
