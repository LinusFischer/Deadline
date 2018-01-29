package linus.fischer.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class AssetLoader {
    public static Texture badlogic;

    public static void load() {
        badlogic = new Texture(Gdx.files.internal("badlogic.jpg"));
    }
}
