package linus.fischer.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import linus.fischer.util.AssetLoader;

public class GameRenderer {
    private GameWorld gameWorld;
    private OrthographicCamera cam;
    private Viewport viewport;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;

    public GameRenderer(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        cam = new OrthographicCamera();
        viewport = new ExtendViewport(512, 512, cam);
        viewport.setWorldSize(512, 512);
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(cam.combined);
        shapeRenderer.setProjectionMatrix(cam.combined);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        renderPlayers();
        shapeRenderer.end();
    }

    private void renderPlayers() {
        shapeRenderer.setColor(gameWorld.getPlayer1().getColor());
        shapeRenderer.rect(gameWorld.getPlayer1().getX() + ((viewport.getWorldWidth() - 512) / 2),
                 gameWorld.getPlayer1().getY() + ((viewport.getWorldHeight() - 512) / 2), gameWorld.getPlayer1().getWidth(),
                    gameWorld.getPlayer1().getHeight());
    }

    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

}


