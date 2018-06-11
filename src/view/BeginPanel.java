package view;

import javax.swing.*;
import java.awt.*;

public class BeginPanel extends JPanel {

    private Image beginScreenImage = new ImageIcon("images/beginScreen.jpg").getImage();

    public void paint(Graphics g) {
        g.drawImage(beginScreenImage, 0, 0, null);

        Font font = new Font("Arial", Font.ITALIC, 80);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("BLOW UP THE PLANET", 170, 250);
    }

}
