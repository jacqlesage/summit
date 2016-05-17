/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package summit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author James
 */
public class TeamJAP implements Player {

    private final int averageDice = 17;
    private final int bestDice = 22;
    private final int greatDice = 27;

    @Override
    public Action takeTurn(State s, int[] dice) {
        int ourRoll = 0;
        char x = ' ';
        int playerIndex = s.currentPlayer;
        int playerBet = s.getBet(s.currentPlayer);
        
//        System.out.println("Our bet: " + playerBet);
//        System.out.println("Dice: " + Arrays.toString(dice));

//         System.out.println("+++++++++++ "+s.getCurrentPlayer());
        //get the total value of the dice
        for (int i = 0; i < dice.length; i++) {
            ourRoll += dice[i];
        }
//         System.out.println("Total Dice: " + ourRoll);

        //dealing with bad dice
        if (ourRoll < averageDice && playerBet == 0) {
            //Call bluff
            x = 'S';
        }
        if (ourRoll < averageDice && playerBet > 0) {
            //for(int i =0; i < State)
            x = 'F';

        }

        //end of dealing with bad dice
        //Deal with average and above average dice
        if (ourRoll > averageDice && playerBet == 0 && ourRoll < bestDice) {
            //call a showdown as the risk of letting in 
            //other players becomes worse - so S
            x = 'S';

        }

        if (ourRoll > bestDice && playerBet == 0) {
            //Roll as we figure that are sure of a victory - we might need
            //to be carefull on how long this "rolling" goes on for ???
            x = 'R';

        } else {

            x = 'R';
        }
        //dealing with average dice where we are not betting first
        //and less that great dice
       
        if (ourRoll > averageDice && playerBet > 0 && ourRoll < bestDice) {
            //If all others have rolled and their rolled die is lower than our lowest ‘S’ 
            //otherwise if we are above average roll
            for (int i = 0; i < s.getPlayersRemaining().size(); i++) {
                for (int j = 0; j < s.getRolls(i).size(); j++) {
                    ArrayList a = s.getRolls(i);
                    if (Integer.parseInt(String.valueOf(a.get(j))) > dice[0]) {
//                        System.out.println("ljklkj");
                        x = 'F';
                    } else {
                        x = 'S';
                    }
                }
            }

        }

        if (ourRoll > bestDice) {
            x = 'R';
        }
        //had to put a closing case in as I did run into the problem of it repeating with no end. 
        if (ourRoll > greatDice) {
            x = 'S';
        }


        switch (x) {
            case 'R':
//                System.out.println("R(oll)");
                return Action.ROLL;
            case 'S':
//                System.out.println(" S(howdown)");
                return Action.SHOWDOWN;
            case 'F':
            default:
//                System.out.println("F(old)");
                return Action.FOLD;
        }
    }

    @Override
    public Action actAtShowdown(State s, int[] dice) {
        int ourRoll = 0;
        for (int i = 0; i < dice.length; i++) {
            ourRoll += dice[i];

        }
//        System.out.println(ourRoll + "&&&&");
        if (ourRoll <= 19) {
            return Action.EXIT;
        }else if( ourRoll >= 20 ){
        return Action.STAY;
        }
        
        return Action.EXIT;
    }

}
