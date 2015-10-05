package application.model;

import java.util.List;

/**
 * Created by Mark on 10/5/2015.
 */
public class Game {
    private List<Player> players;
    private int round;
    private Turn currentTurn;


    public List<Player> getPlayers() {
        return players;
    }
}
