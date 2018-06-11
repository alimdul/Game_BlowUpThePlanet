package view;

import controller.Move;
import model.Space;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.YES_NO_OPTION;

public class BeginScreen {

    Space space = new Space();
    Move move = new Move(space);

    Image spaceImage = new ImageIcon("images/sp.jpg").getImage();

    private JFrame beginScreen = new JFrame();
    private String title;
    private Dimension d;

    private JPanel beginPanel = new BeginPanel();
    private JPanel panel = new JPanel();

    private JButton playButton = new JButton("Play");
    private JButton infButton = new JButton("Specification");
    private JButton exitButton = new JButton("Exit");

    public BeginScreen (String title, Dimension d) {
        this.title = title;
        this.d = d;
    }

    public void init () {

        //beginScreen.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        beginScreen.setTitle(title);
        beginScreen.setSize(d);
        beginScreen.setLayout(new BorderLayout());
        beginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        beginScreen.setLocationRelativeTo(null);

        playButton.addActionListener(new PlayButtonActionListener());
        infButton.addActionListener(new InfButtonActionListener());
        exitButton.addActionListener(new ExitButtonActionListener());

        panel.setLayout(new GridBagLayout());
        beginPanel.setLayout(new BorderLayout());

        playButton.setBackground(Color.WHITE);
        infButton.setBackground(Color.WHITE);
        exitButton.setBackground(Color.WHITE);
        Font font = new Font("Arial", Font.ITALIC, 30);
        playButton.setFont(font);
        infButton.setFont(font);
        exitButton.setFont(font);

        panel.add(infButton, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                        GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(playButton, new GridBagConstraints(1, 0, 1, 1, 1, 1,
                        GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));
        panel.add(exitButton, new GridBagConstraints(2, 0, 1, 1, 1, 1,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL, new Insets(2, 2, 2, 2), 0, 0));

        beginScreen.add(beginPanel, BorderLayout.CENTER);
        beginScreen.add(panel, BorderLayout.SOUTH);

        beginScreen.setVisible(true);
    }

    public class PlayButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            MainFrame mf = new MainFrame("Blow up the planet", new Dimension(1200,700), move, spaceImage,
                    2000, 3000, 6);
            mf.init();
            beginScreen.dispose();
        }
    }

    public class InfButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            JOptionPane.showMessageDialog(null, "                           << Blow up the planet >>\n\n" +
                    "* Прекрасный убийца времени\n" +
                    "* Идеальный способ расслабиться\n\n" +
                    "Ваша цель - с максимальной скоростью добраться\n" +
                    "до планеты Земля и взорвать ее.\n" +
                    "Используйте клавиши 'вправо' и 'влево'\n" +
                    "для ускорения и замедления, соответственно.\n" +
                    "Клавиши 'вверх' и 'вниз' - передвижения по пространству.\n" +
                    "Избегайте столкновений с другими космическими телами.");
        }
    }

    public class ExitButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            int response = JOptionPane.showConfirmDialog(beginScreen, "Do you really want to exit?");
            switch (response) {
                case JOptionPane.YES_OPTION:
                    System.exit(0);
                    break;
                case JOptionPane.NO_OPTION:
                    break;
                case JOptionPane.CANCEL_OPTION:
                    break;
                case JOptionPane.CLOSED_OPTION:
                    break;
            }
        }
    }

}
