import java.util.ArrayList;
import java.util.Collections;

/**
 * This class has the method for setting and getting dealerdeck and playerdeck, replacing the player card and getting the result.
 * Variable dealer and player save the dealerdeck and playerdeck respectively.
 * @author Tam Ngo Hin
 * @version 1.0
 * @since 2023-04-07
 */
public class Player {
    ArrayList <Integer> dealer = new ArrayList<>();
    ArrayList <Integer> player = new ArrayList<>();

    /**
     * This method is a setter for setter the card of the dealer
     * @param card the card to be added.
     */
    public void setDealerdeck(int card){
        dealer.add(card);
    }
    /**
     * This method is a setter for setter the card of the player
     * @param card the card to be added.
     */
    public void setPlayerdeck(int card){
        player.add(card);
    }

    /**
     * This method is a getter for getting the card of the player according to the index.
     * @param idx the index of required card.
     * @return the card of the player according to the index.
     */
    public int getPlayerdeck(int idx){
        return player.get(idx);
    }

    /**
     * This method is a getter for getting the card of the dealer according to the index.
     * @param idx the index of required card.
     * @return the card of the dealer according to the index.
     */
    public int getDealerdeck(int idx){
        return dealer.get(idx);
    }

    /**
     * This method replace the card of the player in deck according to the index.
     * @param  idx the index of card for replacing.
     * @param card the index of card for replacing.
     */
    public void replace(int idx, int card){
        player.remove(idx);
        player.add(idx,card);
    }

    /**
     * This method determine whether player or dealer win according to the rule.
     * @return true if player wins.
     * @return false if dealer wins.
     */
    public boolean result(){
        Collections.sort(player);
        Collections.sort(dealer);
        int player_special =0; int dealer_special =0;
        int player_face =0;        int dealer_face =0;

        for (int i=0; i <3; i++){
            int player_card = player.get(i);
            int dealer_card = dealer.get(i);
            if(player_card > 99){
                if (player_card%10!=0){
                    player_special++;}

            }
            else{
                player_face += player_card;

            }
            if(dealer_card > 99){
                if (dealer_card%10!=0){
                    dealer_special++;}

            }
            else{
                dealer_face += dealer_card;
            }
        }

        player.clear();
        dealer.clear();

        player_face= player_face%10;
        dealer_face= dealer_face%10;
        if (dealer_special > player_special){return false;}
        else if (dealer_special < player_special){return true;}
        else{
            if(player_face > dealer_face){return true;}
            else {return false;}
        }

    }

}

// if /10 ==1 club
// if /10 ==2 spade
// if /10 ==3 diamond
// if /10 ==4 heart
