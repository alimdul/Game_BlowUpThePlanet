package view;

import javax.swing.*;
import java.awt.*;

public class WinPanel extends JPanel{

    private Image winScreenImage = new ImageIcon("images/winScreen.jpeg").getImage();

    public void paint(Graphics g) {
        g.drawImage(winScreenImage, 0, 0, null);

        Font font = new Font("Arial", Font.ITALIC, 170);
        g.setFont(font);
        g.setColor(Color.WHITE);
        g.drawString("THE END", 220, 250);
    }

}
