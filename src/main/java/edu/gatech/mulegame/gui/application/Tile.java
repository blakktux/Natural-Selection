package application;

public class Tile {
    private Mule mule;
    private Player owner;
    private int power;


    public Tile() {
        this.mule = null;
        this.power = 10;
    }

    public Mule installMule(Mule mule) {
        Mule ret = this.mule;
        this.mule = mule;
        if (ret != null) {
            owner.lostMule();
        }
        return ret;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void increasePower(int rate) {
        this.power += rate;
    }

    public Player getOwner() {
        return owner;
    }

    public void produce() {
        if (mule != null) {
            //System.out.println(this.mule.produce()[1]);
            if (power >= 5) {
                power -= 5;
                owner.changeResource(mule.getResource(), mule.getRate());
            }
        }
    }
}
