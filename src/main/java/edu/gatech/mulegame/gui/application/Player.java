package application;

import javafx.scene.paint.Color;
import java.util.ArrayList;
import java.io.Serializable;

public class Player implements Serializable {
    private int[] resource;
    private String name;
    private int race;
    private transient Color color; //need to be set
    private double red;
    private double green;
    private double blue;
    private int money;
    private int numOfLand;
    private Mule boughtMule;
    private Mule outfittedMule;
    private transient ArrayList<Tile> ownedTiles; //need to be set
    private int ownedMules = 0;

    public Player() {
        money = 1000;
        numOfLand = 0;
        ownedTiles = new ArrayList<>();
        boughtMule = null;
        outfittedMule = null;
        resource = new int[4];
    }

    public Player(String name, int race, Color color, int money, int numOfLand, Mule boughtMule, Mule outfittedMule, int ownedMules, ArrayList<Tile> tiles) {
        this.name = name;
        this.race = race;
        this.color = color;
        this.money = money;
        this.numOfLand = numOfLand;
        this.boughtMule = boughtMule;
        this.outfittedMule = outfittedMule;
        this.ownedMules = ownedMules;
        ownedTiles = tiles;
    }

    public void changeResource(int type, int amount) { //0 is food, 1 is energy, 2 is smithore
        resource[type] += amount;
    }

    public int getResource(int type) {
        return resource[type];
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

    public void changeMoney(int d) {
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
        this.red = color.getRed();
        this.green = color.getGreen();
        this.blue = color.getBlue();
    }

    public void loadColor() {
        System.out.println(this.red);
        System.out.println(this.green);
        System.out.println(this.blue);
        this.color = Color.color((float)this.red, (float)this.green, (float)this.blue);
    }

    public void claimLand(int i, int j) {
        numOfLand++;
    }

    public void claimLand(Tile tile) {
        numOfLand++;
        ownedTiles.add(tile);
        tile.setOwner(this);
    }

    public void reclaimLand(Tile tile) {
        if (ownedTiles == null) {
            ownedTiles = new ArrayList<>();
        }
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
            //System.out.println(outfittedMule.produce());
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
            i.produce();
            //System.out.println(i.produce());
        }
    }

}
