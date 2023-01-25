package pk;
import java.util.Random;

public class Player {
    public int score;
    public int numSkulls;

    public Player(){
        this.score = 0;
        this.numSkulls = 0;
    }

    Dice myDice = new Dice();

    public void turn(int numDice){
        Random random = new Random();
        int continueTurn = 1;
        int increaseScore = 0;

        while(this.numSkulls < 3 && continueTurn == 1){
            for(int i=0; i<numDice; i++){
                Faces roll = myDice.roll();
//            System.out.println(roll);
                if(roll == Faces.SKULL){
                    this.numSkulls++;
                    numDice--;
                }
                if(roll == Faces.DIAMOND || roll == Faces.GOLD){
                    increaseScore += 100;
                }
            }
            continueTurn = random.nextInt(2);
        }
        // only increase the score if the player stops re-rolling, if they get 3 skulls, the turn does not contribute to the overall score
        if(continueTurn == 0){
            this.score += increaseScore;
        }
    }

    public int getScore(){
        return this.score;
    }

}
