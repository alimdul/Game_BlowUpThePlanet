package view;

import controller.Move;
import controller.PreferencesClass;
import model.Level;
import model.LevelGenerator;
import model.Space;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndScreen {

    public static final int LEVEL_COUNT = 4;

    List<Level> levelList = new ArrayList<>();
    LevelGenerator levelGenerator = new LevelGenerator();

    int temp;
    PreferencesClass preferencesClass = new PreferencesClass();

    Space space = new Space();
    Move move = new Move(space);

    private JFrame endScreen = new JFrame();
    private String title;
    private Dimension d;

    private JPanel endPanel = new EndPanel();

    private JButton nextButton = new JButton("Next");

    public EndScreen (String title, Dimension d) {
        this.title = title;
        this.d = d;

        levelList = levelGenerator.generate(LEVEL_COUNT);
    }

    public void init() {

        endScreen.setTitle(title);
        endScreen.setSize(d);
        endScreen.setLayout(new BorderLayout());
        endScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        endScreen.setLocationRelativeTo(null);

        nextButton.addActionListener(new NextButtonActionListener());

        nextButton.setBackground(Color.WHITE);
        Font font = new Font("Arial", Font.ITALIC, 30);
        nextButton.setFont(font);

        endScreen.add(nextButton, BorderLayout.SOUTH);

        endScreen.add(endPanel, BorderLayout.CENTER);

        endScreen.setVisible(true);
    }

    public class NextButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {

            temp = preferencesClass.getLevel();

            if (temp < LEVEL_COUNT) {

                Level next = levelList.get(temp);
                MainFrame mf = new MainFrame("Blow up the planet", new Dimension(1200, 700), move,
                        next.getLevelImage(),2000, next.getMaxDistanceOfPlayer(), next.getTimeIsOver());
                mf.init();
                preferencesClass.setLevel(temp + 1);
            }

            else {
                WinScreen winScreen = new WinScreen("Blow up the planet", new Dimension(1200, 700));
                winScreen.init();
            }
            endScreen.dispose();
        }
    }

}
