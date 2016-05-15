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

    @Override
    public Action takeTurn(State s, int[] dice) {
        int temp = 0;
        int count = 0;
        int roundsComplete =0;
        char x = ' ';
        boolean allRollsLess = false;
        System.out.println("Dice: " + Arrays.toString(dice));
        
//         System.out.println("+++++++++++ "+s.getCurrentPlayer());
        //get the total value of the dice
        for (int i = 0; i < dice.length; i++) {
            temp += dice[i];
        }

        //dealing with bad dice
        if (temp <= 14 && s.betRequired() == 0) {
            //Call bluff
            x = 'S';
        }
        if (temp <= 14 && s.betRequired() > 0) {
            //for(int i =0; i < State)
            ArrayList<Integer> rolls = s.getRolls(0);
    
        }

                //end of dealing with bad dice
        //Deal with average and above average dice
        if (temp > 17 && s.betRequired() == 0 && temp < 22) {
            //call a showdown as the risk of letting in 
            //other players becomes worse - so S
            x = 'S';

        } 
        
         if (temp > 22 && s.betRequired() == 0) {
            //Roll as we figure that are sure of a victory - we might need
            //to be carefull on how long this "rolling" goes on for ???
            x = 'R';
        
        }else{
             
             x='R';
         }
        //dealing with average dice where we are not betting first
        //and less that great dice
        if (temp > 17 && s.betRequired() > 0 && temp < 22) {
            //If all others have rolled and their rolled die is lower than our lowest ‘S’ 
            //otherwise if we are above average roll
            for(int i = 0; i < s.getPlayersRemaining().size(); i++){
                for(int j =0; j < s.getRolls(i).size();j++){
                    if(Integer.parseInt(String.valueOf(s.getRolls(j))) > dice[0]){
                        x = 'F';
                    }else{
                        x='S';
                    }
                }
            }
            
                        
        }
        
         if (temp > 22 ) {
             x = 'R';
         }
      

    

    
      

    

//        System.out.println(temp);
//         Scanner in = new Scanner(System.in);
//        System.out.println("R(oll), F(old), S(howdown)");
//        String act = in.next();
    switch (x) {
            case 'R':
                System.out.println("R(oll)");
                return Action.ROLL;
            case 'S':
                System.out.println(" S(howdown)");
                return Action.SHOWDOWN;
            case 'F':
            default:
                System.out.println("F(old)");
                return Action.FOLD;
        }
    }

    @Override
        public Action actAtShowdown(State s, int[] dice) {
        int temp = 0;
        for (int i = 0; i < dice.length; i++) {
            temp += dice[i];

        }
        System.out.println(temp + "&&&&");
        if (temp <= 14) {
            return Action.FOLD;
        }

        return Action.STAY;
    }

}
