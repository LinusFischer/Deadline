package linus.fischer.gameobjects;

import com.badlogic.gdx.graphics.Color;

public enum BasicColors {
    ORANGE(new Color(225/225.0f, 51/255.0f, 0/255.0f, 1)),
    GREEN(new Color(57/255.0f, 255/255.0f, 20/255.0f, 1)),
    BLUE(new Color(0/255.0f, 51/255.0f, 255/255.0f, 1)),
    PURPEL(new Color(110/255.0f, 13/255.0f, 208/255.0f, 1)),
    YELLOW(new Color(242/255.0f, 234/255.0f, 2/255.0f, 1)),
    LIGHT_BLUE(new Color(0/255.0f, 153/255.0f, 255/255.0f, 1)),
    RED(new Color(255/255.0f, 0/255.0f, 0/255.0f, 1)),
    PINK(new Color(255/255.0f, 0/255.0f, 255/255.0f, 1));

    private final Color color;
    BasicColors(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
