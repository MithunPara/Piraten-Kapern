package pk;

import java.util.Random;

public class Game {

    public void run(Player player1, Player player2, String strat1, String strat2){
        Random rand = new Random();
        player1.strategy = strat1; player2.strategy = strat2;
        int firstTurn = rand.nextInt(2);

        while(player1.score < 6000 && player2.score < 6000){
            if(firstTurn == 0){
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
            else{
                player2.turn();
                //  System.out.print("Player 2 score: " + player2.score);
                player2.numSkulls = 0;
                player2.numDice = 8;
                if(player2.score >= 6000){
                    break;
                }

                player1.turn();
                // System.out.print("Player 1 score: " + player1.score);
                player1.numSkulls = 0;
                player1.numDice = 8;
                if(player1.score >= 6000){
                    break;
                }
            }
        }

        if(player1.score >= 6000){
            player1.wins++;
        }
        else {
            player2.wins++;
        }
    }
}
