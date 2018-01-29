package linus.fischer.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import linus.fischer.util.AssetLoader;

public class GameRenderer {
    private GameWorld gameWorld;
    private OrthographicCamera cam;
    private Viewport viewport;
    private SpriteBatch batch;

    public GameRenderer(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        cam = new OrthographicCamera();
        viewport = new ExtendViewport(512, 512, cam);
        viewport.setWorldSize(480, 480);
        batch = new SpriteBatch();
    }

    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        batch.draw(AssetLoader.badlogic, viewport.getWorldWidth() / 2 -128, viewport.getWorldHeight() / 2 - 128 , 256, 256);
        batch.end();
    }

    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }
}
