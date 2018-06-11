package view;

import controller.Move;
import controller.PreferencesClass;

import javax.swing.*;
import java.awt.*;

public class MainFrame {

    PreferencesClass preferencesClass = new PreferencesClass();

    private int maxDistanceOfBarrier;
    private int maxDistanceOfPlayer;
    private int timeIsOver;

    private JFrame mainFrame = new JFrame();
    private String title;
    private Dimension d;
    private Move move;
    private Image image;

    public MainFrame (String title, Dimension d, Move move, Image image, int maxDistanceOfBarrier, int maxDistanceOfPlayer,
                      int timeIsOver) {

        this.title = title;
        this.d = d;
        this.move = move;
        this.image = image;
        this.maxDistanceOfBarrier = maxDistanceOfBarrier;
        this.maxDistanceOfPlayer = maxDistanceOfPlayer;
        this.timeIsOver = timeIsOver;
        preferencesClass.clear();
    }

    public void init () {

        mainFrame.setTitle(title);
        mainFrame.setSize(d);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);

        mainFrame.add(new Map(move, this, image, maxDistanceOfBarrier, maxDistanceOfPlayer, timeIsOver));

        mainFrame.setVisible(true);
        //mainFrame.pack();
    }

    public void disposeMainFrame() {
        mainFrame.dispose();
    }

}
