package pk;


public class Player {
    public int score;

    public Player(){
        this.score = 0;
    }

    Dice myDice = new Dice();

    public void turn(int numDice){
        for(int i=0; i<numDice; i++){
            Faces roll = myDice.roll();
            System.out.println(roll);
            if(roll == Faces.DIAMOND || roll == Faces.GOLD){
                this.score += 100;
            }
        }
    }

    public int getScore(){
        return this.score;
    }

}
