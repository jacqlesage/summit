package summit;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Michael Albert
 */
public class HumanPlayer implements Player {

    Scanner in = new Scanner(System.in);

    @Override
    public Action takeTurn(State s, int[] dice) {
        System.out.println("Dice: " + Arrays.toString(dice));
        System.out.println("R(oll), F(old), S(howdown)");
        String act = in.next();
        switch (act.charAt(0)) {
            case 'R':
                return Action.ROLL;
            case 'S':
                return Action.SHOWDOWN;
            case 'F':
            default:
                return Action.FOLD;
        }

    }

    @Override
    public Action actAtShowdown(State s, int[] dice) {
        System.out.println("Dice: " + Arrays.toString(dice));
        System.out.println("S(tay), E(xit)");
        String act = in.next();
        switch (act.charAt(0)) {
            case 'S':
                return Action.STAY;
            case 'E':
            default:
                return Action.EXIT;
        }
    }

}
