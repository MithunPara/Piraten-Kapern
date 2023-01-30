package pk;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Card {
    public String draw(){
        Random rand = new Random();
        List<String> deck = new ArrayList<String>();
        for(int i=0; i<2; i++){ // add 2 of each sea battle card to the deck
            deck.add("Sea Battle 1");
            deck.add("Sea Battle 2");
            deck.add("Sea Battle 3");
        }
        for(int i=0; i<4; i++){
            deck.add("Monkey Business"); // add 4 monkey business cards
        }
        for(int i=0; i<25; i++) {
            deck.add("nop"); // the rest of the 35 cards are nothing
        }

        int draw = rand.nextInt(35);

        return deck.get(draw);
    }
}
