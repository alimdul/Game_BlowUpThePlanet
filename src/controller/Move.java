package controller;

import model.Barrier;
import model.Earth;
import model.Player;
import model.Space;

import java.util.List;

import static model.Player.*;


public class Move {

    Space space;

    public Move(Space base) {
        this.space = base;
    }

    public Space getSpace() {
        return space;
    }

    public List<Barrier> getBarrierList() {
        return space.getBarrierList();
    }

    public void add(Barrier barrier) {
        space.add(barrier);
    }

    public model.Player getPlayer()
    {
        return space.getPlayer();
    }

    public Earth getEarth() {
        return space.getEarth();
    }

    public void moveBarrier(Barrier barrier) {
        barrier.setX((int) (barrier.getX() - (int)getPlayer().getV() + barrier.getV()));
    }

    public void moveEarth() {
        space.getEarth().setX((int) (space.getEarth().getX() - (int)getPlayer().getV() + space.getEarth().getV()));
    }

    public void movePlayer() {
        Player player = space.getPlayer();
        player.setS(player.getS() + player.getV());
        player.setV(player.getV() + player.getDv());

        if (player.getV() <= MIN_V) {
            player.setV(MIN_V);
        }
        if (player.getV() >= MAX_V) {
            player.setV(MAX_V);
        }

        player.setY((int) (player.getY() - player.getDy()));

        if (player.getY() <= MAX_UP) {
            player.setY(MAX_UP);
        }
        if (player.getY() >= MAX_DOWN) {
            player.setY(MAX_DOWN);
        }
        if (player.getLayer2() - player.getV() <= NULL) {
            player.setLayer1(NULL);
            player.setLayer2(LAYER_WIDTH);
        }
        else {
            player.setLayer1((int) (player.getLayer1() - player.getV()));
            player.setLayer2((int) (player.getLayer2() - player.getV()));
        }
    }

}
