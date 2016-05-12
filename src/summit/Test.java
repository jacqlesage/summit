package summit;

/**
 *
 * @author Michael Albert
 */
public class Test {

    public static void main(String[] args) {
        Player[] players = new Player[4];
        players[0] = new HumanPlayer();
        players[1] = new TeamJAP();
        players[2] = new RollPlayer();
        players[3] = new RandomPlayer();
//        players[4] = new RollPlayer();
//        players[5] = new HumanPlayer();
        Round r = new Round(players);
    }
    
}
