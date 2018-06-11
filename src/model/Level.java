package model;

import java.awt.*;

public class Level {

    private Image image;
    private int maxDistanceOfPlayer;
    private int timeIsOver;

    public Level(Image image, int maxDistanceOfPlayer, int timeIsOver) {
        this.image = image;
        this.maxDistanceOfPlayer = maxDistanceOfPlayer;
        this.timeIsOver = timeIsOver;
    }

    public Image getLevelImage() {
        return image;
    }

    public int getMaxDistanceOfPlayer() {
        return maxDistanceOfPlayer;
    }

    public int getTimeIsOver() {
        return timeIsOver;
    }

}
