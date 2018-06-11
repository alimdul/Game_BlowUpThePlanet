package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WinScreen {

    private JFrame winScreen = new JFrame();
    private String title;
    private Dimension d;

    private JPanel winPanel = new WinPanel();

    private JButton exitButton = new JButton("Exit");

    public WinScreen (String title, Dimension d) {
        this.title = title;
        this.d = d;
    }

    public void init() {

        winScreen.setTitle(title);
        winScreen.setSize(d);
        winScreen.setLayout(new BorderLayout());
        winScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        winScreen.setLocationRelativeTo(null);

        exitButton.addActionListener(new ExitButtonActionListener());

        exitButton.setBackground(Color.WHITE);
        Font font = new Font("Arial", Font.ITALIC, 30);
        exitButton.setFont(font);

        winScreen.add(exitButton, BorderLayout.SOUTH);

        winScreen.add(winPanel, BorderLayout.CENTER);

        winScreen.setVisible(true);
    }

    public class ExitButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            System.exit(0);
        }
    }

}
