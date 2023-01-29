package pk;
import java.util.*;

public class Player {
    public int score;
    public int numSkulls;
    public int numDice;
    public float wins;
    public String strategy;
    public int numDiceReroll;
    public int numDiceKeep;
    public int diceIndex;
    Faces randomFace;
    List < Faces > diceKept;
    List < Faces > diceRolled;
    boolean winBattle; // check to see if sea battle has been won, used in checkCombos method

    public Player(){
        score = 0;
        numSkulls = 0;
        numDice = 8;
        wins = 0;
        numDiceReroll = 8;
        numDiceKeep = 0;
        diceIndex = 0;
        diceKept = new ArrayList<>();
        diceRolled = new ArrayList<>();
        strategy = "";
        winBattle = false;
    }

    Dice myDice = new Dice();
    Card card = new Card();

    public void turn(){
        int continueTurn = 1;
        int increaseScore = 0;
        this.winBattle = false;

        String fortuneCard = card.draw();

        if(Objects.equals(this.strategy, "random")){
            randomStrategy(continueTurn, increaseScore,fortuneCard);
        }
        else{
            maximizeCombos(continueTurn, increaseScore,fortuneCard);
        }
    }

    public void randomStrategy(int continueTurn, int increaseScore, String card){
        Random random = new Random();

        while(this.numSkulls < 3 && continueTurn == 1){
            for(int i=0; i<numDiceReroll; i++){
                Faces roll = myDice.roll();
                diceRolled.add(roll);
                if(roll == Faces.SKULL){
                    this.numSkulls++;
                    this.numDice--;
                }
                if(roll == Faces.DIAMOND || roll == Faces.GOLD){
                    increaseScore += 100;
                }
            }

            for(Faces roll: diceKept){
                if(roll == Faces.DIAMOND || roll == Faces.GOLD){
                    increaseScore += 100;
                }
            }

            int comboScore = checkCombos(diceRolled,diceKept,strategy,card);
            increaseScore += comboScore;

            if(this.numDice < 6){ // prevents error where multiple skulls are rolled on one turn and a bound error occurs when calculating numDiceReroll
                break;
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
            if(Objects.equals(card, "Sea Battle 1") && !winBattle){
                this.score -= 200;
            }
            else if(Objects.equals(card, "Sea Battle 2") && !winBattle){
                this.score -= 500;
            }
            else if(Objects.equals(card, "Sea Battle 3") && !winBattle){
                this.score -= 1000;
            }
            else{
                this.score += increaseScore;
            }
        }
        else{
            if(Objects.equals(card, "Sea Battle 1") && !winBattle){
                this.score -= 200;
            }
            else if(Objects.equals(card, "Sea Battle 2") && !winBattle){
                this.score -= 500;
            }
            else if(Objects.equals(card, "Sea Battle 3") && !winBattle){
                this.score -= 1000;
            }
        }
    }

    public void maximizeCombos(int continueTurn, int increaseScore, String card){
        diceKept.clear();
        diceRolled.clear(); // if the previous turn is exited because of having 2 or more skulls, these skulls must be removed

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

            for(Faces roll: diceKept){
                if(roll == Faces.DIAMOND || roll == Faces.GOLD){
                    increaseScore += 100;
                }
            }

            Iterator<Faces> itr = diceRolled.iterator(); // remove all the skulls from the rolled dice, so they cannot be kept by the player
            while (itr.hasNext()){
                Faces roll = itr.next();
                if(roll == Faces.SKULL){
                    itr.remove();
                }
            }

            int comboScore = checkCombos(diceRolled,diceKept,strategy,card);
            increaseScore += comboScore;
            numDiceReroll = this.numDice - diceKept.size();

            if(this.numDice < 6){ // prevents error where multiple skulls are rolled on one turn and a bound error occurs when calculating numDiceReroll
                break;
            }

            if(this.numSkulls == 2) { // only skip turn if you rolled 2 skulls to avoid losing points
                if ((Objects.equals(card, "Sea Battle 1") || Objects.equals(card, "Sea Battle 2") || Objects.equals(card, "Sea Battle 3")) && !winBattle){
                } // if in a sea battle and you have not won, keep rolling
                else{
                    break;
                }
            }

            diceRolled.clear();
        }
        // only increase the score if the player stops re-rolling, if they get 3 skulls, the turn does not contribute to the overall score
        if(this.numSkulls < 3){
            this.score += increaseScore;
        }
        else{
            if(Objects.equals(card, "Sea Battle 1") && !winBattle){
                this.score -= 200;
            }
            else if(Objects.equals(card, "Sea Battle 2") && !winBattle){
                this.score -= 500;
            }
            else if(Objects.equals(card, "Sea Battle 3") && !winBattle){
                this.score -= 1000;
            }
        }
    }
    public int checkCombos(List<Faces> diceRolled, List<Faces> diceKept, String strategy, String card){
        int addScore = 0;
        List<Faces> newDiceKept = new ArrayList<>();

        Map<Faces, Integer> numOccurrences = new HashMap<>();
        for(Faces roll: diceRolled){
            if(Objects.equals(card, "Monkey Business")){
                if(roll == Faces.MONKEY || roll == Faces.PARROT){
                    roll = Faces.MONKEY_PARROT;
                }
            }
            if(numOccurrences.containsKey(roll)){
                numOccurrences.put(roll, numOccurrences.get(roll)+1);
            }
            else{
                numOccurrences.put(roll, 1);
            }
        }

        for(Faces roll: diceKept){
            if(Objects.equals(card, "Monkey Business")){
                if(roll == Faces.MONKEY || roll == Faces.PARROT){
                    roll = Faces.MONKEY_PARROT;
                }
            }
            if(numOccurrences.containsKey(roll)){
                numOccurrences.put(roll, numOccurrences.get(roll)+1);
            }
            else{
                numOccurrences.put(roll, 1);
            }
        }

        for(Map.Entry<Faces, Integer> numRolls: numOccurrences.entrySet()){
            if(numRolls.getValue() == 8){
                addScore += 4000;
            }
            else if(numRolls.getValue() == 7){
                addScore += 2000;
            }
            else if(numRolls.getValue() == 6){
                addScore += 1000;
            }
            else if(numRolls.getValue() == 5){
                addScore += 500;
            }
            else if(numRolls.getValue() == 4){
                addScore += 200;
                if(numRolls.getKey() == Faces.SABER && (Objects.equals(card, "Sea Battle 3") || Objects.equals(card, "Sea Battle 2") || Objects.equals(card, "Sea Battle 1")) && !winBattle){
                    addScore += 1000;
                    this.winBattle = true;
                }
            }
            else if(numRolls.getValue() == 3){
                addScore += 100;
                if(numRolls.getKey() == Faces.SABER && (Objects.equals(card, "Sea Battle 2") || Objects.equals(card, "Sea Battle 1")) && !winBattle){
                    addScore += 500;
                    this.winBattle = true;
                }
            }
            else if(numRolls.getValue() == 2){
                if(numRolls.getKey() == Faces.SABER && Objects.equals(card, "Sea Battle 1") && !winBattle){
                    addScore += 300;
                    this.winBattle = true;
                }
            }
        }

        if(Objects.equals(strategy, "combo")){
            List<Map.Entry<Faces, Integer>> orderedFaces = new ArrayList<>(numOccurrences.entrySet());
            Collections.sort(orderedFaces, new Comparator<Map.Entry<Faces, Integer>>() {
                public int compare(Map.Entry<Faces, Integer> o1, Map.Entry<Faces, Integer> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });

            for(Map.Entry<Faces, Integer> rolls: orderedFaces){
                if(rolls.getValue() > 1){ // only add to the arraylist if the dice occurs more than once
                    for(int i=0; i<rolls.getValue(); i++)
                        if(rolls.getKey() == Faces.SABER && (Objects.equals(card, "Sea Battle 1") || Objects.equals(card, "Sea Battle 2") || Objects.equals(card, "Sea Battle 3")) && !winBattle){
                            newDiceKept.add(0,rolls.getKey());
                        }
                        else{
                            newDiceKept.add(rolls.getKey());
                        }
                }
                else{
                    if(rolls.getKey() == Faces.GOLD || rolls.getKey() == Faces.DIAMOND){
                        newDiceKept.add(rolls.getKey());
                    }
                    if(rolls.getKey() == Faces.SABER && (Objects.equals(card, "Sea Battle 1") || Objects.equals(card, "Sea Battle 2") || Objects.equals(card, "Sea Battle 3")) && !winBattle){
                        newDiceKept.add(0,rolls.getKey());
                    }
                }
            }

            if(this.numSkulls == 0){
                while(newDiceKept.size() > 6){ // when there are no skulls in the list, make sure player only keeps maximum of 6 dice (at least 2 must be re-rolled)
                    newDiceKept.remove(newDiceKept.size()-1);
                }
            }
            else if(this.numSkulls == 1){
                while(newDiceKept.size() > 5){ // when there is 1 skull in the list, make sure player only keeps maximum of 5 dice
                    newDiceKept.remove(newDiceKept.size()-1);
                }
            }
            else{
                while(newDiceKept.size() > 4){
                    newDiceKept.remove(newDiceKept.size()-1);
                }
            }

            diceKept.clear();
            diceKept.addAll(newDiceKept); // copy list with combos to the list of dice player is keeping
        }

        return addScore;
    }
}
