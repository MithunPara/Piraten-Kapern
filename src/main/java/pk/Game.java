package pk;

public class Game {
    private Player player1, player2;
    public Game(){
        player1 = new Player();
        player2 = new Player();
    }

    public void run(){
        while(player1.score < 6000 && player2.score < 6000){
            player1.turn();
            System.out.print("Player 1 scored: " + player1.score + " on this turn.");
            player1.numSkulls = 0;
            player1.numDice = 8;
            if(player1.score >= 6000){
                break;
            }
            player2.turn();
            System.out.print("Player 2 scored: " + player2.score + " on this turn.");
            player2.numSkulls = 0;
            player2.numDice = 8;
            if(player2.score >= 6000){
                break;
            }
        }

        if(player1.score >= 6000){
            System.out.println("Player 1 won with " + player1.score + "points.");
        }
        else {
            System.out.println("Player 2 won with " + player2.score + "points.");
        }
//        System.out.print("Player 1 scored: " + player1.getScore());
//        System.out.print("Player 2 scored: " + player2.getScore());
    }
}
