package controller;
import model.Barrier;

import java.util.Random;

public class BarrierThread implements Runnable{

    Move move;

    public BarrierThread(Move move) {
        this.move = move;
    }

    @Override
    public void run() {
        while (true) {
            Random random = new Random();
            try {
                Thread.sleep(random.nextInt(1500));
                move.getBarrierList().add(new Barrier(1300, random.nextInt(700),
                        random.nextInt(30)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
