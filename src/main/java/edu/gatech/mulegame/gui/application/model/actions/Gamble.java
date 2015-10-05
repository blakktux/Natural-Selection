package application.model.actions;

import application.model.Player;
import application.model.Turn;

import java.util.Random;

/**
 * Created by Mark on 10/5/2015.
 */
public class Gamble extends Action {
    Gamble(Player p) {
        super(p);
    }

    @Override
    public boolean exec(Turn t) {
        p.addMoney(new Random().nextInt((int) (t.getTime() / 1000)));
        return true;
    }
}
