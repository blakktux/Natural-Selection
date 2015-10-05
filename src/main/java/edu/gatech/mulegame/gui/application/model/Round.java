package application.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mark on 10/5/2015.
 */
public class Round {
    private Game g;
    private int currentTurn;
    public Round (Game g) {
        this.g = g;
        currentTurn = 0;
    }

    public List<Player> getTurnOrder() {
        List playersSorted = new ArrayList(g.getPlayers().size());
        Collections.copy(playersSorted, g.getPlayers());
        return playersSorted;
    }

    public boolean isOver() {
        return currentTurn >= g.getPlayers().size() - 1;
    }
}
