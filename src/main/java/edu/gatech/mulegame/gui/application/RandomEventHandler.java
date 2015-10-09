package application;

import java.util.Random;
public class RandomEventHandler {


    // public static void main(String[] args) {
    //
    // }

    public static void eventHandler(Random rand, Player p, boolean lowest) {
        int eventNum = 0;
        if (lowest) {
            eventNum = rand.nextInt(5) ;
        } else {
            eventNum = rand.nextInt(10);
        }

        //print statement if lowest

        if (eventNum == 0) {
            p.changeMoney(0);
        } else if (eventNum == 1) {
            p.changeMoney(50);
        } else if (eventNum == 2) {
            p.changeMoney(100);
        } else if (eventNum == 3) {
            p.changeMoney(200);
        } else if (eventNum == 4) {
            p.changeMoney(500);
        } else if (eventNum == 5) {
            p.changeMoney(0);
        } else if (eventNum == 6) {
            p.changeMoney(-50);
        } else if (eventNum == 7) {
            p.changeMoney(-100);
        } else if (eventNum == 8) {
            p.changeMoney(-200);
        } else if (eventNum == 9) {
            p.changeMoney(-500);
        }

        //print statement on event
    }

}
