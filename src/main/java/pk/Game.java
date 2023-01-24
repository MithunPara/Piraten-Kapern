package pk;

public class Game {
    private Player player1, player2;
    public int numDice;
    public Game(){
        player1 = new Player();
        player2 = new Player();
        numDice = 8;
    }

    public void run(){
        player1.turn(numDice);
        System.out.print("Player 1 scored: " + player1.getScore());
        player2.turn(numDice);
        System.out.print("Player 2 scored: " + player2.getScore());
    }
}
