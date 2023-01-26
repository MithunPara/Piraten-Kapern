package pk;

public class Game {

    public void run(Player player1, Player player2){
        while(player1.score < 6000 && player2.score < 6000){
            player1.turn();
           // System.out.print("Player 1 score: " + player1.score);
            player1.numSkulls = 0;
            player1.numDice = 8;
            if(player1.score >= 6000){
                break;
            }
            player2.turn();
          //  System.out.print("Player 2 score: " + player2.score);
            player2.numSkulls = 0;
            player2.numDice = 8;
            if(player2.score >= 6000){
                break;
            }
        }

        if(player1.score >= 6000){
        //    System.out.println("Player 1 won with " + player1.score + "points.");
            player1.wins++;
        }
        else {
        //    System.out.println("Player 2 won with " + player2.score + "points.");
            player2.wins++;
        }
//        System.out.print("Player 1 scored: " + player1.getScore());
//        System.out.print("Player 2 scored: " + player2.getScore());
    }
}
