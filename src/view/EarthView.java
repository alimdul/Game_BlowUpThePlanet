package view;

import model.Earth;

import javax.swing.*;
import java.awt.*;

public class EarthView {

    Earth earth;

    public EarthView(Earth earth) {
        this.earth = earth;
    }

    Image earthImage = new ImageIcon("images/earth.png").getImage();

    int width = earthImage.getWidth(null);
    int height = earthImage.getHeight(null);

    public Image getImage() {
        return earthImage;
    }

    public Rectangle getRect() {
        return new Rectangle(earth.getX(), earth.getY(), width, height);
    }

}
