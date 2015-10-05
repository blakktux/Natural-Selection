package application.model.actions;

import application.model.Player;
import application.model.Turn;

/**
 * Created by Mark on 10/5/2015.
 */
public abstract class Action {
    protected Player p;

    Action(Player p) {
        this.p = p;
    }

    public abstract boolean exec(Turn t);
}
