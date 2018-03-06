package linus.fischer.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class AssetLoader {
    public static Texture player;

    public static void load() {
        player = new Texture(Gdx.files.internal("player.png"));
    }

    public static void dispose() {
        player.dispose();
    }
}
