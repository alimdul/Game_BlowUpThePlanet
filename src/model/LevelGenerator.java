package model;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LevelGenerator {

    private Image level2Image = new ImageIcon("images/level2.jpg").getImage();
    private Image level3Image = new ImageIcon("images/level3.jpg").getImage();
    private Image level4Image = new ImageIcon("images/level4.jpg").getImage();
    private Image level5Image = new ImageIcon("images/level5.jpg").getImage();
    private Image level6Image = new ImageIcon("images/level6.jpg").getImage();
    private Image level7Image = new ImageIcon("images/level7.jpg").getImage();
    private Image level8Image = new ImageIcon("images/level8.jpg").getImage();
    private Image level9Image = new ImageIcon("images/level9.jpg").getImage();
    private Image level10Image = new ImageIcon("images/level10.jpg").getImage();

    private Image images[] = {level2Image, level3Image, level4Image, level5Image, level6Image, level7Image,
            level8Image, level9Image, level10Image};

    public List<Level> generate(int levelCount ){

        Random random = new Random();
        int k = 2;

        List<Level> levels = new ArrayList<>();
        for (int i = 0; i < levelCount; i++) {
            Level lvl = new Level(images[random.nextInt(images.length)], 3000 * k, 6 * k);
            levels.add(lvl);
            k++;
        }
        return levels;
    }

}
