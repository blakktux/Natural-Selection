package application.model;

import application.model.actions.Action;

/**
 * Created by Mark on 10/5/2015.
 */
public class Turn {
    private Player p;
    private Game g;
    private long startTime;

    public Turn(Player p, Game g) {
        this.p = p;
        this.g = g;
        startTime = System.currentTimeMillis();
    }

    /**
     * Gets the remaining time for the player
      * @return the remaining time, calculated from score and start time
     */
    public long getTime() {
        return System.currentTimeMillis() - (startTime + p.getScore());
    }

    public boolean endTurn(Action a) {
        return a.exec(this);
    }
}
