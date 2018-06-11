package view;

import javax.swing.*;
import java.awt.*;

public class EndPanel extends JPanel {

    private Image endScreenImage = new ImageIcon("images/endScreen.jpg").getImage();

    public void paint(Graphics g) {
        g.drawImage(endScreenImage, 0, 0, null);

        Font font = new Font("Arial", Font.ITALIC, 80);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("WELL-DONE", 350, 250);
    }

}
