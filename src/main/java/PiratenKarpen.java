import pk.Game;
import pk.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PiratenKarpen {
    private static final Logger logger = LogManager.getLogger(PiratenKarpen.class);
    public static void main(String[] args) {
        Player player1 = new Player();
        Player player2 = new Player();
        Game game = new Game();
        String strat1 = args[0];
        String strat2 = args[1];

        for(int i=0; i<42; i++){
            game.run(player1, player2, strat1, strat2);
            logger.info("Player 1's score is " + player1.score);
            logger.info("Player 2's score is " + player2.score);
            player1.score = 0;
            player2.score = 0;

        }

        float percentWinsP1 = (player1.wins/42)*100;
        float percentWinsP2 = (player2.wins/42)*100;
        System.out.println("Player 1's percentage of wins is " + percentWinsP1 + "% and Player 2's percentage of wins is " + percentWinsP2 + "%.");

//        System.out.println("Welcome to Piraten Karpen Simulator!");
//        System.out.println("That's all folks!");
    }
}
