package pk;
import java.util.ArrayList;
import java.util.Iterator;
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
//*********
            for(Faces roll: diceKept) {
                System.out.print(roll + " ");
            }
  //          *************

            for(Faces roll: diceKept){
                if(roll == Faces.DIAMOND || roll == Faces.GOLD){
                    increaseScore += 100;
                }
            }
            continueTurn = random.nextInt(2);
            numDiceReroll = random.nextInt(2,this.numDice+1); // minimum 2 dice must be re-rolled, keep anywhere from 0 to numDice-2 dice
            numDiceKeep = this.numDice - numDiceReroll;

            Iterator<Faces> itr = diceRolled.iterator(); // remove all the skulls from the rolled dice, so they cannot be kept by the player
            while (itr.hasNext()){
                Faces roll = itr.next();
                if(roll == Faces.SKULL){
                    itr.remove();
                }
            }

            if(numDiceKeep>diceKept.size()){ // if the number of dice player wishes to keep is greater than previous amount, program will keep a dice that was rolled on the current turn
                for(int i=diceKept.size(); i<numDiceKeep; i++){
                    diceIndex = random.nextInt(diceRolled.size());
                    randomFace = diceRolled.get(diceIndex);
                    diceRolled.remove(diceIndex);
                    diceKept.add(randomFace);
                }
            }
            else if(numDiceKeep<diceKept.size()){
                for(int i=0; i<(diceKept.size()-numDiceKeep); i++){
                    diceIndex = random.nextInt(diceKept.size());
                    randomFace = diceKept.get(diceIndex);
                    diceKept.remove(randomFace);
                }
            }
            diceRolled.clear();
        }
        // only increase the score if the player stops re-rolling, if they get 3 skulls, the turn does not contribute to the overall score
        if(this.numSkulls < 3){
            this.score += increaseScore;
        }
    }
}
