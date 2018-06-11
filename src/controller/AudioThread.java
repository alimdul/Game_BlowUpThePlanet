package controller;

import javazoom.jl.decoder.JavaLayerException;
import view.Map;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class AudioThread implements Runnable, ActionListener {

    private javazoom.jl.player.Player player1 = null;
    private javazoom.jl.player.Player player2 = null;
    private javazoom.jl.player.Player player3 = null;
    private javazoom.jl.player.Player player4 = null;

    private Timer timer = new Timer(30, this);

    private Map map;

    public AudioThread(Map map) {

        this.map = map;
        timer.start();
    }


    @Override
    public void run() {

        FileInputStream f1 = null;
        try {
            f1 = new FileInputStream("audio/space.mp3");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Невозможно воспризвести аудиозапись!");
            e.printStackTrace();
        }
        try {
            player1 = new javazoom.jl.player.Player(f1);
        } catch (JavaLayerException e) {
            JOptionPane.showMessageDialog(null, "Невозможно воспризвести аудиозапись!");
            e.printStackTrace();
        }
        try {
            player1.play();
        } catch (JavaLayerException e) {
            JOptionPane.showMessageDialog(null, "Невозможно воспризвести аудиозапись!");
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e){

        if (map.checkOnWin()) {

            player1.close();

            FileInputStream f2 = null;
            try {
                f2 = new FileInputStream("audio/bang.mp3");
            } catch (FileNotFoundException e1) {
                JOptionPane.showMessageDialog(null, "Невозможно воспризвести аудиозапись!");
                e1.printStackTrace();
            }
            try {
                player2 = new javazoom.jl.player.Player(f2);
            } catch (JavaLayerException e1) {
                JOptionPane.showMessageDialog(null, "Невозможно воспризвести аудиозапись!");
                e1.printStackTrace();
            }
            try {
                player2.play();
            } catch (JavaLayerException e1) {
                JOptionPane.showMessageDialog(null, "Невозможно воспризвести аудиозапись!");
                e1.printStackTrace();
            }
            timer.stop();
        }

        if (map.checkCollisions()) {

            player1.close();

            FileInputStream f3 = null;
            try {
                f3 = new FileInputStream("audio/hit.mp3");
            } catch (FileNotFoundException e1) {
                JOptionPane.showMessageDialog(null, "Невозможно воспризвести аудиозапись!");
                e1.printStackTrace();
            }
            try {
                player3 = new javazoom.jl.player.Player(f3);
            } catch (JavaLayerException e1) {
                JOptionPane.showMessageDialog(null, "Невозможно воспризвести аудиозапись!");
                e1.printStackTrace();
            }
            try {
                player3.play();
            } catch (JavaLayerException e1) {
                JOptionPane.showMessageDialog(null, "Невозможно воспризвести аудиозапись!");
                e1.printStackTrace();
            }
            timer.stop();
        }

        if(map.chekOnTimeIsOver()) {

            player1.close();

            FileInputStream f4 = null;
            try {
                f4 = new FileInputStream("audio/timeOut.mp3");
            } catch (FileNotFoundException e1) {
                JOptionPane.showMessageDialog(null, "Невозможно воспризвести аудиозапись!");
                e1.printStackTrace();
            }
            try {
                player4 = new javazoom.jl.player.Player(f4);
            } catch (JavaLayerException e1) {
                JOptionPane.showMessageDialog(null, "Невозможно воспризвести аудиозапись!");
                e1.printStackTrace();
            }
            try {
                player4.play();
            } catch (JavaLayerException e1) {
                JOptionPane.showMessageDialog(null, "Невозможно воспризвести аудиозапись!");
                e1.printStackTrace();
            }
            timer.stop();
        }

    }

}

