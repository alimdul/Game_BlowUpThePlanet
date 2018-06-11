package view;

import model.Barrier;

import javax.swing.*;
import java.awt.*;

public class BarrierView {

    Barrier barrier;

    public BarrierView (Barrier barrier) {
        this.barrier = barrier;
    }

    Image barrierImage = new ImageIcon("images/aster.png").getImage();

    int width = barrierImage.getWidth(null);
    int height = barrierImage.getHeight(null);

    public Image getImage() {
        return barrierImage;
    }

    public Rectangle getRect() {
        return new Rectangle(barrier.getX(), barrier.getY(), width, height);
    }

}
