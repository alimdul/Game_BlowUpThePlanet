import view.BeginScreen;
import view.EndScreen;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        BeginScreen beginScreen = new BeginScreen("Blow up the planet", new Dimension(1200,700));
        beginScreen.init();
    }
}
