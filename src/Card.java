import java.util.ArrayList;
import java.util.Collections;
/**
 * This class build the deck.
 * This class has the method for building the deck following the name of image.
 * The variable deck save the deck which is shuffled randomly.
 * @author Tam Ngo Hin
 * @version 1.0
 * @since 2023-04-07
 */
public class Card {
    ArrayList<Integer> deck = new ArrayList<>();

    /**
     * This method build the deck.
     */
    public void MakeDeck(){
        for (int i = 11; i < 20; i++) {
            deck.add(i);
        }
        for (int i = 21; i < 30; i++) {
            deck.add(i);
        }
        for (int i = 31; i < 40; i++) {
            deck.add(i);
        }
        for (int i = 41; i < 50; i++) {
            deck.add(i);
        }

        for (int i = 110; i < 114; i++) {
            deck.add(i);
        }
        for (int i = 210; i < 214; i++) {
            deck.add(i);
        }
        for (int i = 310; i < 314; i++) {
            deck.add(i);
        }
        for (int i = 410; i < 414; i++) {
            deck.add(i);
        }
        Collections.shuffle(deck);
    }

    /**
     * This method remove the card in deck when drawing.
     * @return the drawed card.
     */
    public int draw(){
        return deck.remove(0);
    }
}

