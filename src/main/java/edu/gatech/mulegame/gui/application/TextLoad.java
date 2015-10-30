import java.io.*;
import java.util.*;
package application;

public class TextLoad {

    public Mule[] loadMule() {
        int rate;
        int resource;
        ArrayList<Mule> mules = new ArrayList<Mule>();
        BufferedReader saveFile = new BufferedReader(new FileReader("savemule.txt"));

        while (saveFile.readLine() != null) {

            saveFile.readLine();
            rate = Integer.parseInt(saveFile.readLine());
            resource = Integer.parseInt(saveFile.readLine());
            mules.add(new Mule(rate, resource));
        }
        saveFile.close();
        return mules.toArray();
    }

    public Player loadPlayer() {
        String name;
        int race;
        Color color;
        int money;
        int numOfLand;
        Mule boughtMule;
        Mule outfittedMule;
        int ownedMules;

        int resource;
        int rate;

        ArrayList<Player> players = new ArrayList<player>();
        ArrayList<Tile> tiles = new ArrayList<>();

        BufferedReader saveFile = new BufferedReader(new FileReader("saveplayer.txt"));

        while (saveFile.readLine() != null) {
            saveFile.readLine();
            name = saveFile.readLine();
            race = Integer.parseInt(saveFile.readLine());
            //what to do for color
            int red = Integer.parseInt(saveFile.readLine());
            int green = Integer.parseInt(saveFile.readLine());
            int blue = Integer.parseInt(saveFile.readLine());
            color = new Color(red, green, blue);
            money = Integer.parseInt(saveFile.readLine());
            numOfLand = Integer.parseInt(saveFile.readLine());
            rate = Integer.parseInt(saveFile.readLine());
            resource = Integer.parseInt(saveFile.readLine());
            boughtMule = new Mule(rate, resource);
            rate = Integer.parseInt(saveFile.readLine());
            resource = Integer.parseInt(saveFile.readLine());
            outfittedMule = new Mule(rate, resource);
            ownedMules = Integer.parseInt(saveFile.readLine());
            int size = Integer.parseInt(saveFile.readLine());
            for (int i = 0; i < size; i++) {
                rate = Integer.parseInt(saveFile.readLine());
                resource = Integer.parseInt(saveFile.readLine());
                int power = Integer.parseInt(saveFile.readLine());
                tiles.add(new Tile(rate, resource, power));
            }
            players.add(new Player(name, race, color, money, numOfLand, boughtMule, outfittedMule, ownedMules, tiles));
        }
        return players.toArray();
    }

}