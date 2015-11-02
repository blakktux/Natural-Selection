package application;
import java.io.Serializable;

public class Mule implements Serializable {
    private int resource;
    private int rate;

    public Mule() {
        rate = 0;
        resource = 0;
    }

    public Mule(int rate, int resource) {
        this.rate = rate;
        this.resource = resource;
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
    //
    // public int[] produce() {
    //     int[] ret = new int[2];
    //     ret[0] = this.resource;
    //     ret[1] = this.rate;
    //     return ret;
    // }
}
