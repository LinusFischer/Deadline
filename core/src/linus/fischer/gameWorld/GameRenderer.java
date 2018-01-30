package linus.fischer.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
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
        renderBounds();
        shapeRenderer.end();
        batch.begin();
        renderPlayers();
        batch.end();
    }

    private void renderPlayers() {
        batch.draw(AssetLoader.orangePlayer, ((viewport.getWorldWidth() - 512) / 2) + gameWorld.getPlayer1().getX(),
                ((viewport.getWorldHeight() - 512) / 2) + gameWorld.getPlayer1().getY(), gameWorld.getPlayer1().getWidth(),
                    gameWorld.getPlayer1().getHeight());
    }

    private void renderBounds() {
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.rect(gameWorld.getBounds().getX() + ((viewport.getWorldWidth() -512) / 2), gameWorld.getBounds().getY() + ((viewport.getWorldHeight() - 512)  /2), gameWorld.getBounds().getWidth(), gameWorld.getBounds().getHeight());
    }

    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }

    public float getWorldWidth() {
        return viewport.getWorldWidth();
    }

    public float getWorldHeight() {
        return viewport.getWorldHeight();
    }
}


