package pk;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Card {

//    public int sabers;
//    public int bonusScore;
    public String draw(){
        Random rand = new Random();
        List<String> deck = new ArrayList<String>();
        for(int i=0; i<2; i++){
            deck.add("Sea Battle 1");
            deck.add("Sea Battle 2");
            deck.add("Sea Battle 3");
        }
        for(int i=0; i<29; i++) {
            deck.add("nop");
        }

        int draw = rand.nextInt(35);

//        if(Objects.equals(deck.get(draw), "Sea Battle 1")){
//            this.sabers = 2;
//            this.bonusScore = 300;
//        }
//        else if(Objects.equals(deck.get(draw), "Sea Battle 2")){
//            this.sabers = 3;
//            this.bonusScore = 500;
//        }
//        else if(Objects.equals(deck.get(draw), "Sea Battle 3")){
//            this.sabers = 4;
//            this.bonusScore = 1000;
//        }

        return deck.get(draw);
    }
}
