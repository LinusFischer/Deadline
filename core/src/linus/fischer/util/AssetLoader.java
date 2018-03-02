package linus.fischer.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetLoader {
    public static TextureAtlas spriteSheet;
    public static Sprite player_blue;
    public static Sprite player_green;
    public static Sprite player_light_blue;
    public static Sprite player_orange;
    public static Sprite player_pink;
    public static Sprite player_purple;
    public static Sprite player_red;
    public static Sprite player_yellow;

    public static void load() {
        spriteSheet = new TextureAtlas("spritesheet.txt");
        player_blue = spriteSheet.createSprite("player_blue");
        player_green = spriteSheet.createSprite("player_green");
        player_light_blue = spriteSheet.createSprite("player_light_blue");
        player_orange = spriteSheet.createSprite("player_orange");
        player_pink = spriteSheet.createSprite("player_pink");
        player_purple = spriteSheet.createSprite("player_purple");
        player_red = spriteSheet.createSprite("player_red");
        player_yellow = spriteSheet.createSprite("player_yellow");
    }
}
