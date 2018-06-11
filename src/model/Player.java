package model;

public class Player {

    public static final int NULL = 0;
    public static final int MIN_V = 8;
    public static final int MAX_V = 30;
    public static final int MAX_UP = 10;
    public static final int MAX_DOWN = 600;
    public static final int LAYER_WIDTH = 1920;

    double v = MIN_V;
    double dv = NULL;
    double s = NULL;

    int x = 300;
    int y = 300;
    double dy = NULL;

    int layer1 = NULL;
    int layer2 = LAYER_WIDTH;

    public Player() {

    }

    public int getLayer1() {
        return layer1;
    }

    public int getLayer2() {
        return layer2;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getS() {
        return s;
    }

    public double getV() {
        return v;
    }

    public double getDv() {
        return dv;
    }

    public double getDy() {
        return dy;
    }

    public void setDv(double dv) {
        this.dv = dv;
    }

    public void setDy(double dy) {
        this.dy = dy;
    }

    public void setS(double s) {
        this.s = s;
    }

    public void setV(double v) {
        this.v = v;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setLayer1(int layer1) {
        this.layer1 = layer1;
    }

    public void setLayer2(int layer2) {
        this.layer2 = layer2;
    }


}
