package pk;
import java.util.Arrays;
import java.util.Random;

public class Dice {

    public Faces roll() {
        int howManyFaces = Faces.values().length;
//        System.out.println("  (DEBUG) there are " + howManyFaces + " faces");
//        System.out.println("  (DEBUG) " + Arrays.toString(Faces.values()));
        Random bag = new Random();
        Faces roll;
        roll = Faces.values()[bag.nextInt(howManyFaces)];
        while(roll == Faces.MONKEY_PARROT){ // created new enum for monkey business fortune card, but want to make sure it cannot be rolled
            roll = Faces.values()[bag.nextInt(howManyFaces)];
        }
        return roll;
    }
}
