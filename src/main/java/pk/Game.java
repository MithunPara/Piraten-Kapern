package pk;

import java.util.Random;

public class Game {

    public void run(Player player1, Player player2, String strat1, String strat2){
        Random rand = new Random();
        player1.strategy = strat1; player2.strategy = strat2;
        int firstTurn = rand.nextInt(2); // use to randomize which player gets first turn

        while(player1.score < 6000 && player2.score < 6000){
            if(firstTurn == 0){
                player1.turn();
                player1.numSkulls = 0;
                player1.numDice = 8;
                if(player1.score >= 6000){ // once player wins, exit the loop
                    break;
                }

                player2.turn();
                player2.numSkulls = 0;
                player2.numDice = 8;
                if(player2.score >= 6000){
                    break;
                }
            }
            else{
                player2.turn();
                player2.numSkulls = 0;
                player2.numDice = 8;
                if(player2.score >= 6000){
                    break;
                }

                player1.turn();
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
