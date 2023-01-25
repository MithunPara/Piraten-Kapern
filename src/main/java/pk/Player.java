package pk;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    public int score;
    public int numSkulls;
    public int numDice;

    public Player(){
        this.score = 0;
        this.numSkulls = 0;
        this.numDice = 8;
    }

    Dice myDice = new Dice();

    public void turn(){
        Random random = new Random();
        int continueTurn = 1;
        int increaseScore = 0;
        int numDiceReroll = 8;
        int numDiceKeep = 0;
        int diceIndex = 0;
        Faces randomFace;
        List < Faces > diceKept = new ArrayList<>();
        List < Faces > diceRolled = new ArrayList<>();

        while(this.numSkulls < 3 && continueTurn == 1){
            for(int i=0; i<numDiceReroll; i++){
                Faces roll = myDice.roll();
                diceRolled.add(roll);
//            System.out.println(roll);
                if(roll == Faces.SKULL){
                    this.numSkulls++;
                    this.numDice--;
                }
                if(roll == Faces.DIAMOND || roll == Faces.GOLD){
                    increaseScore += 100;
                }
            }
            continueTurn = random.nextInt(2);
            numDiceReroll = random.nextInt(2,this.numDice+1); // minimum 2 dice must be re-rolled, keep anywhere from 0 to numDice-2 dice
            numDiceKeep = this.numDice - numDiceReroll;

            if(numDiceKeep>diceKept.size()){
                for(int i=diceKept.size(); i<numDiceKeep; i++){ // make sure not you do not access same reroll index twice
                    diceIndex = random.nextInt(diceRolled.size());
                    diceRolled.remove(diceIndex);
                    randomFace = diceRolled.get(diceIndex);
                    diceKept.add(randomFace);
                }
            }
            else if(numDiceKeep<diceKept.size()){
                for(int i=0; i<(diceKept.size()-numDiceKeep); i++){ // make sure not you do not access same reroll index twice
                    diceIndex = random.nextInt(diceKept.size());
                    randomFace = diceKept.get(diceIndex);
                    diceKept.remove(randomFace);
                }
            }
            diceRolled.clear();
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
