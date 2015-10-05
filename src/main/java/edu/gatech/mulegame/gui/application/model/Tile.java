package application.model;

public class Tile {
    private Mule mule;
    private Player owner;


    public Tile() {
        this.mule = null;
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

    public Player getOwner() {
        return owner;
    }

    public int produce() {
        if (this.mule != null) {
            //System.out.println(this.mule.produce()[1]);
            return this.mule.produce()[1];
        }
        return 0;
    }
}
