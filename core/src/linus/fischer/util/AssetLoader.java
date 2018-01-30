package linus.fischer.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class AssetLoader {
    public static Texture orangePlayer;

    public static void load() {
        orangePlayer = new Texture(Gdx.files.internal("player.png"));
    }
}
