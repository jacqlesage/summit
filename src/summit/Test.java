package summit;

/**
 *
 * @author Michael Albert
 */
public class Test {

    public static void main(String[] args) {
        Player[] players = new Player[5];
//        players[0] = new HumanPlayer();
        
        players[0] = new RollPlayer();
        players[1] = new TeamJAP();
        players[2] = new RandomPlayer();
        players[3] = new RandomPlayer();
        players[4] = new RandomPlayer();
        //players[5] = new RandomPlayer();
        Round r = new Round(players);
    }
    
}
