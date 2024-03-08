/**
 * This class record the number of replacing card.
 * This class has the method for recording the number of replacing card and getting the replaced card.
 * The variable time is to record the number of time for replacing a card.
 * @author Tam Ngo Hin
 * @version 1.0
 * @since 2023-04-07
 */
public class Check {
    int time =0;

    /**
     * This is a method for recording the times of replacing card.
     */
    public void replaced(){
        time++;
    }

    /**
     * This method reset the replacedtime when called.
     */
    public void reset_replacedtime(){
        time = 0;
    }

    /**
     * This method is a getter for getting the number of replacing card.
     * @return the name of the character.
     */
    public int get_replacedtime(){
        return time;
    }

}
