package model;

import java.util.ArrayList;
import java.util.List;

import static model.Player.MIN_V;

public class Space {

    List<Barrier> barrierList = new ArrayList<Barrier>();

    Player player = new Player();

    Earth earth = new Earth(1200, 0, MIN_V-2);

    public List<Barrier> getBarrierList() {
        return barrierList;
    }

    public void add(Barrier barrier) {
        barrierList.add(barrier);
    }

    public Player getPlayer()
    {
        return player;
    }

    public Earth getEarth()
    {
        return earth;
    }

}
