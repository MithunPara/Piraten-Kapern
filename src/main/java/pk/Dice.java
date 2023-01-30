package pk;
import java.util.Arrays;
import java.util.Random;

public class Dice {

    public Faces roll() {
        int howManyFaces = Faces.values().length;
        Random bag = new Random();
        Faces roll;
        roll = Faces.values()[bag.nextInt(howManyFaces)];
        while(roll == Faces.MONKEY_PARROT){ // created new enum for monkey business fortune card, but want to make sure the enum cannot be rolled
            roll = Faces.values()[bag.nextInt(howManyFaces)];
        }
        return roll;
    }
}
