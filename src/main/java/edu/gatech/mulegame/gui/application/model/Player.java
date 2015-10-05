package application.model;

import javafx.scene.paint.Color;
import java.util.ArrayList;

public class Player implements Comparable{
    private int playerNum;
    private String name;
    private int race;
    private Color color;
    private int money;
    private int numOfLand;
    private Mule boughtMule;
    private Mule outfittedMule;
    private ArrayList<Tile> ownedTiles;
    private int ownedMules = 0;

    public Player(int playerNum) {
        this.playerNum = playerNum;
        money = 1000;
        numOfLand = 0;
        ownedTiles = new ArrayList<>();
        boughtMule = null;
        outfittedMule = null;
    }

    public int getPlayerNum() {
        return playerNum;
    }

    public int getScore() {
        return numOfLand * 500 + money + ownedMules * 500;
    }

    public int getnumOfLand() {
        return numOfLand;
    }

    public int getRace() {
        return race;
    }

    public Color getColor() {
        return color;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public void addMoney(int d) {
        money += d;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRace(int race) {
        this.race = race;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void claimLand(int i, int j) {
        numOfLand++;
    }

    public void claimLand(Tile tile) {
        numOfLand++;
        ownedTiles.add(tile);
        tile.setOwner(this);
    }

    public void obtainMule() {
        System.out.println("bought mule");
        boughtMule = new Mule();
        ownedMules++;
    }

    public boolean outfitMule(int resource, int rate) {
        if (boughtMule != null) {
            boughtMule.outfit(resource, rate);
            outfittedMule = boughtMule;
            boughtMule = null;
            return true;
        } else {
            System.out.println("outfitFail");
        }
        return false;
    }

    public boolean installMule(Tile tile) {
        if (outfittedMule != null) {
            System.out.println(outfittedMule.produce());
            tile.installMule(outfittedMule);
            outfittedMule = null;
            return true;
        } else {
            System.out.println("installFail");
        }
        return false;
    }

    public void lostMule() {
        ownedMules--;
        if (outfittedMule != null) {
            outfittedMule = null;
        }
    }

    public boolean canBuyMule() {
        return (boughtMule == null && outfittedMule == null);
    }

    public void produce() {
        for (Tile i : ownedTiles) {
            this.money += i.produce() * 100;
            System.out.println(i.produce());
        }
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Player) {
            return (this.getScore() - ((Player) o).getScore());
        }
        throw new ClassCastException("Object o is not of type player");
    }
}
