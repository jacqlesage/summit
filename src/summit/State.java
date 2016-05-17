package summit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A container class that represents the state of a Summit game in progress. The
 * players are represented by indices 0, 1, 2, ... corresponding to their
 * initial bets (so player 0 leads the action). When players leave the game the
 * other players' indices are unchanged.
 *
 * @author Michael Albert
 */
public class State {

    int pot; // Amount in the pot
    int maxBet; // The current maximum bet
    ArrayList<Integer> playersRemaining; // The indices of the remaining players
    int[] bets; // The bets of  all the players. Players who have folded will
    // have negative (or zero) bets indicating the amount they added to the pot.
    ArrayList<Turn> log; // The game to this point
    int currentPlayer;

  

    public State() {

    }

    public State(State s) {
        this.pot = s.pot;
        this.maxBet = s.maxBet;
        this.playersRemaining = (ArrayList<Integer>) s.playersRemaining.clone();
        this.bets = Arrays.copyOf(bets, bets.length);
        this.log = (ArrayList<Turn>) log.clone();
        this.currentPlayer = s.currentPlayer;
    }

    /**
     * The log of play to this point.
     *
     * @return the log
     */
    public ArrayList<Turn> getLog() {
        return log;
    }

    /**
     * The bet required from the current player to stay in.
     *
     * @return the amount the current player must bet (total) to stay in the
     * round.
     */
    public int betRequired() {
        return maxBet + 1;
    }
    
    /**
     * Get the players remaining (in order of play).
     * @return Indices of players remaining 
     */
    public ArrayList<Integer> getPlayersRemaining() {
        return playersRemaining;
    }

    /**
     * The rolls of one of the remaining players. These are represented as
     * positive integers for rolls accepted, and negative ones for rolls
     * rejected.
     *
     * @param i the index of a player
     * @return the rolls that player accepted or rejected in order
     */
    ArrayList<Integer> getRolls(int i) {
        ArrayList<Integer> result = new ArrayList<>();
        for (Turn t : log) {
            if (t.playerIndex == i && t.a == Action.ROLL) {
                result.add(t.roll);
            }
        }
        return result;
    }

    /**
     * The current bet of a particular player.
     *
     * @param i the index of the player
     * @return the current bet of that player
     */
    int getBet(int i) {
        return bets[i];
    }
    
    /**
     * The current bets of all players (negative or zero bets indicate players
     * no longer active in this round)
     * @return the array of bets
     */
    int[] getBets() {
        return bets;
    }
//    
//      public int getCurrentPlayer() {
//        return currentPlayer;
//    }

}
