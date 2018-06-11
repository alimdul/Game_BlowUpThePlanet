package model;

public class Earth {

    int x;
    int y;
    int v;

    public Earth(int x, int y, int v) {
        this.x = x;
        this.y = y;
        this.v = v;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getV() {
        return v;
    }

}
