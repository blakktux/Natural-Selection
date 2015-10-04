package application;

public class Mule {
    private int resource;
    private int rate;

    public Mule() {
        rate = 0;
        resource = 0;
    }

    public int getRate() {
        return rate;
    }

    public int getResource() {
        return resource;
    }

    public void outfit(int resource, int rate) {
        this.rate = rate;
        this.resource = resource;
    }

    public int[] produce() {
        int[] ret = new int[2];
        ret[0] = this.resource;
        ret[1] = this.rate;
        return ret;
    }
}
