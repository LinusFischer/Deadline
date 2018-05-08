package linus.fischer.util;

import com.badlogic.gdx.graphics.Color;

import java.util.ArrayList;

public class Var {
    public static final float viewportWidth = 1024;
    public static final float viewportHeight = 1024;
    public static int velocity = 200;
    public static ArrayList<Color> colors;

    public static void init() {
        colors = new ArrayList<>();
        colors.add(new Color(255/255.0f, 51/255.0f, 0/255.0f, 1)); //orange
        colors.add(new Color(57/255.0f, 255/255.0f, 20/255.0f,1)); //green
        colors.add(new Color(0/255.0f, 51/255.0f, 255/255.0f, 1)); //blue
        colors.add(new Color(110/255.0f, 13/255.0f, 208/255.0f, 1)); //purple
        colors.add(new Color(242/255.0f, 234/255.0f, 2/255.0f, 1)); //yellow
        colors.add(new Color(0/255.0f, 153/255.0f, 255/255.0f, 1)); //light blue
        colors.add(new Color(255/255.0f, 0/255.0f, 0/255.0f, 1)); //red
        colors.add(new Color(255/255.0f, 0/255.0f, 255/255.0f, 1)); //pink
    }
}
