package view;

import controller.AudioThread;
import controller.BarrierThread;
import controller.Move;
import model.Barrier;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Map extends JPanel implements ActionListener {

    private int maxDistanceOfBarrier;
    private int maxDistanceOfPlayer;
    private int timeIsOver;

    MainFrame mainFrame;

    private long start;
    private Timer moveTime;
    private String timeLable = "";
    private long timeValue = 0;

    Image image;
    Image fire = new ImageIcon("images/fire.jpg").getImage();

    Timer timer = new Timer(30, this);

    AudioThread audioThread = new AudioThread(Map.this);
    BarrierThread barrierThread;

    Move move;
    PlayerView playerView;
    EarthView earthView;

    BarrierView barrierView;
    Barrier barrier;

    public Map(Move move, MainFrame mainFrame, Image image, int maxDistanceOfBarrier, int maxDistanceOfPlayer,
               int timeIsOver) {

        this.maxDistanceOfBarrier = maxDistanceOfBarrier;
        this.maxDistanceOfPlayer = maxDistanceOfPlayer;
        this.timeIsOver = timeIsOver;

        this.move = move;
        this.mainFrame = mainFrame;
        this.image = image;
        timer.start();

        moveTime = new Timer(100, time);
        start = Calendar.getInstance().getTimeInMillis();
        moveTime.start();

        playerView = new PlayerView(move.getPlayer());
        earthView = new EarthView(move.getEarth());

        new Thread(audioThread).start();
        barrierThread = new BarrierThread(move);
        new Thread(barrierThread).start();

        addKeyListener(new MyKeyAdapter());
        setFocusable(true);
    }

    ActionListener time = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateTime();
        }
    };

    public void updateTime() {
        long temp = Calendar.getInstance().getTimeInMillis();
        timeLable = "Your time: " + (temp - start)/1000;
        timeValue = (temp - start)/1000;
    }

    public void paint (Graphics g) {
        g = (Graphics2D) g;
        g.drawImage(image, move.getPlayer().getLayer1(), 0, null);
        g.drawImage(image, move.getPlayer().getLayer2(), 0, null);
        g.drawImage(playerView.getImage(), move.getPlayer().getX(), move.getPlayer().getY(), null);

        Iterator<Barrier> i = move.getBarrierList().iterator();
        while (i.hasNext()) {
            boolean isDrawImage = false;
            synchronized (i) {
                barrier = i.next();
                barrierView = new BarrierView(barrier);
                if (barrier.getX() >= maxDistanceOfBarrier || barrier.getX() <= -maxDistanceOfBarrier) {
                    i.remove();
                }
                else {
                    isDrawImage = true;
                }
            }
            if(isDrawImage) {
                g.drawImage(barrierView.getImage(), barrier.getX(), barrier.getY(), null);
            }
        }

        if (checkOnDistance()) {
            g.drawImage(earthView.getImage(), move.getEarth().getX(),
                    move.getSpace().getEarth().getY(), null);
        }

        Font font = new Font("Arial", Font.ITALIC, 50);
        g.setFont(font);

        g.setColor(Color.WHITE);

        if(timeValue >= timeIsOver) {
            g.drawString("YOUR TIME IS UP", 400, 300);
        }

        g.setColor(Color.BLACK);

        if (checkOnWin()) {
            g.drawImage(fire, 0, 0, null);
            g.drawString("WELL DONE! YOU BLEW IT UP!", 250, 350);
        }

        g.setColor(Color.WHITE);

        Iterator<Barrier> j = move.getBarrierList().iterator();
        while (j.hasNext()) {
            barrier = j.next();
            barrierView = new BarrierView(barrier);
            if (playerView.getRect().intersects(barrierView.getRect())) {
                g.drawString("GAME OVER", 400, 300);
            }
        }
        g.drawString(timeLable, 50, 50);
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

        move.movePlayer();

        Iterator<Barrier> i = move.getBarrierList().iterator();
        while (i.hasNext()) {
            Barrier barrier = i.next();
            move.moveBarrier(barrier);
        }

        if (checkOnWin()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            timer.stop();
            EndScreen endScreen = new EndScreen("Blow up the planet", new Dimension(1200, 700));
            endScreen.init();
            mainFrame.disposeMainFrame();
        }

        if (checkOnDistance()) {
            move.moveEarth();
        }

        if(checkCollisions()) {
            timer.stop();
            BeginScreen beginScreen = new BeginScreen("Blow up the planet", new Dimension(1200,700));
            beginScreen.init();
            mainFrame.disposeMainFrame();
        }

        if (chekOnTimeIsOver()){
            timer.stop();
            BeginScreen beginScreen = new BeginScreen("Blow up the planet", new Dimension(1200,700));
            beginScreen.init();
            mainFrame.disposeMainFrame();
        }

        repaint();
    }

    public boolean checkOnDistance() {
        if (move.getPlayer().getS() >= maxDistanceOfPlayer) {
            return true;
        }
        return false;
    }

    public boolean checkOnWin() {
        EarthView earthView = new EarthView(move.getEarth());
        if (playerView.getRect().intersects(earthView.getRect())) {
            return true;
        }
        return false;
    }

    public boolean chekOnTimeIsOver() {
        if (timeValue > timeIsOver) {
            return true;
        }
        return false;
    }

    public boolean checkCollisions() {

        Iterator<Barrier> i = move.getBarrierList().iterator();
        while (i.hasNext()) {
            Barrier barrier = i.next();
            BarrierView barrierView = new BarrierView(barrier);
            if (playerView.getRect().intersects(barrierView.getRect())) {
                return true;
            }
        }
        return false;

    }

    private class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_RIGHT) {
                move.getPlayer().setDv(0.3);
            }
            if (key == KeyEvent.VK_LEFT) {
                move.getPlayer().setDv(-0.3);
            }
            if (key == KeyEvent.VK_UP) {
                move.getPlayer().setDy(10);
            }
            if (key == KeyEvent.VK_DOWN) {
                move.getPlayer().setDy(-10);
            }
        }

        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT) {
                move.getPlayer().setDv(0);
            }
            if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN) {
                move.getPlayer().setDy(0);
            }
        }
    }


}
