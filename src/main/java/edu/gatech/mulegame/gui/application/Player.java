package application;

import javafx.scene.paint.Color;

public class Player {
    private String name;
    private int race;
    private Color color;
    private int money;
    private int numOfLand;

    public Player() {
        money = 1000;
        numOfLand = 0;
    }


    public int getScore() {
        return numOfLand * 500 + money;
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
    }

    public void claimLand(int col, int row) {
        numOfLand++;
    }
}
