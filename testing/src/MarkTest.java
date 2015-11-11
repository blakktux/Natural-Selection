import application.Player;
import application.Tile;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Mark on 11/10/2015.
 */
public class MarkTest {
    public static void main(String[] args) {
        MarkTest t = new MarkTest();
    }

    @Test
    public void testReclaimLand() {
        //Make a new player
        Player p = new Player();
        Tile t = new Tile();
        p.claimLand(t);
        assertEquals(1, p.getnumOfLand());
        assertEquals(p, t.getOwner());
    }

    @Test
    public void testMule() {
        Player p = new Player();
        p.obtainMule();
        assertEquals(1, p.ownedMules);
    }
}
