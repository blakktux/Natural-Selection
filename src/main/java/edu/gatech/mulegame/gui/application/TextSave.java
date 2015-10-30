import java.io.*;
package application;

public class TextSave {

    public void savePlayer(Player[] players) {
        FileWriter saveFile = new FileWriter("saveplayer.txt");
        for (int i = 0; i < players.length; i++) {
            Player player = players[i];
            String name = player.getName();
            int race = player.getRace();
            Color color = player.getColor();
            int money = player.getMoney();
            int numOfLand = player.getnumOfLand();
            Mule boughtMule = player.getboughtMule();
            Mule outfittedMule = player.getoutfittedMule();
            int ownedMules = player.getownedMules();
            ArrayList<Tile> tiles = player.getOwnedTiles();

            saveFile.write("\n");
            saveFile.write(name + "\n");
            saveFile.write(race + "\n");
            saveFile.write(color.getRed() + "\n"); //check what to do for this later
            saveFile.write(color.getGreen() + "\n");
            saveFile.write(color.getBlue() + "\n");
            saveFile.write(money + "\n");
            saveFile.write(numOfLand + "\n");

            int rate, resource;

            if (boughtMule != null) {
                rate = boughtMule.getRate();
                resource = boughtMule.getResource();

                saveFile.write(rate + "\n");
                saveFile.write(resource + "\n");
            }

            if (outfittedMule != null) {
                rate = outfittedMule.getRate();
                resource = outfittedMule.getResource();

                saveFile.write(rate + "\n");
                saveFile.write(resource + "\n");
            }
            saveFile.write(ownedMules + "\n");
            saveFile.write(tiles.size() + "\n");
            for (Tile tile: tiles) {
                rate = tile.getMule().getRate();
                resource = tile.getMule().getResource();
                int power = tile.getPower();

                saveFile.write(rate + "\n");
                saveFile.write(resource + "\n");
                saveFile.write(power + "\n");
            }

        }
        saveFile.close();
    }

    public void saveMule(Mule[] mules) {
        FileWriter saveFile = new FileWriter("savemule.txt");
        for (int i = 0; i < mules.length; i++) {
            Mule mule = mules[i];
            int rate = mule.getRate();
            int resource = mule.getResource();

            saveFile.write("\n");
            saveFile.write(rate + "\n");
            saveFile.write(resource + "\n");
        }
        saveFile.close();
    }
}