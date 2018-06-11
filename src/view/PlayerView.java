package view;

import model.Player;

import javax.swing.*;
import java.awt.*;

public class PlayerView {

    Player player;

    public PlayerView(Player player) {
        this.player = player;
    }

    Image playerImage = new ImageIcon("images/meteor.png").getImage();

    int width = playerImage.getWidth(null);
    int height = playerImage.getHeight(null);

    public Image getImage() {
        return playerImage;
    }

    public Rectangle getRect() {
        return new Rectangle(player.getX(), player.getY(), width, height);
    }

}
