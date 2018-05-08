package linus.fischer.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class AssetLoader {
    public static Texture player;
    public static Skin quantumHorizon;

    public static void load() {
        player = new Texture(Gdx.files.internal("player.png"));
        quantumHorizon = new Skin(Gdx.files.internal("skins/quantum-horizon/skin/quantum-horizon-ui.json"));
    }

    public static void dispose() {
        player.dispose();
        quantumHorizon.dispose();
    }
}
