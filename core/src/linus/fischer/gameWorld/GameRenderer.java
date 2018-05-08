package linus.fischer.gameWorld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import linus.fischer.gameScreen.GameScreen;
import linus.fischer.gameScreen.MenuScreen;
import linus.fischer.gameobjects.Deadline;
import linus.fischer.gameobjects.Player;
import linus.fischer.util.AssetLoader;
import linus.fischer.util.Var;

import java.awt.*;

public class GameRenderer {
    private MenuScreen menuScreen;
    private GameScreen gameScreen;
    private GameWorld gameWorld;
    private OrthographicCamera cam;
    private Viewport viewport;
    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;
    private GameState state;

    public GameRenderer() {
        cam = new OrthographicCamera();
        viewport = new ExtendViewport(Var.viewportWidth, Var.viewportHeight, cam);
        viewport.setWorldSize(Var.viewportWidth, Var.viewportHeight);
        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        state = GameState.MAINMENU;
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.setProjectionMatrix(cam.combined);
        shapeRenderer.setProjectionMatrix(cam.combined);

        switch (state) {
            case MAINMENU:
                if (menuScreen != null) {
                    batch.begin();
                    menuScreen.getStage().draw();
                    batch.end();
                }
                break;
            case GAME:
                if (gameScreen !=null) {
                    renderBounds();
                    renderDeadlines();
                    shapeRenderer.end();
                    renderPlayers();
                }
                break;
        }
    }

    private void renderPlayers() {
        for (Player player: gameWorld.getPlayers())
        if (player.isAlive()) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(player.getColor());
            shapeRenderer.rect(((viewport.getWorldWidth()-Var.viewportWidth) /2)+player.getX()+(player.getWidth()/10), ((viewport.getWorldHeight() - Var.viewportHeight) / 2)+player.getY()+(player.getHeight()/10),
                    player.getWidth()-player.getWidth()/5, player.getHeight()-player.getHeight()/5);
            shapeRenderer.end();
            batch.begin();
            batch.draw(AssetLoader.player, ((viewport.getWorldWidth() - Var.viewportWidth) / 2) + player.getX(),
                    ((viewport.getWorldHeight() - Var.viewportHeight) / 2) + player.getY(), player.getWidth(),
                    player.getHeight());
            batch.end();
        }
    }

    private void renderBounds() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rect(gameWorld.getBounds().getX() + ((viewport.getWorldWidth() - Var.viewportWidth) / 2), gameWorld.getBounds().getY() + ((viewport.getWorldHeight() - Var.viewportHeight)  /2), gameWorld.getBounds().getWidth(), gameWorld.getBounds().getHeight());
    }

    private void renderDeadlines() {
        for (Player player : gameWorld.getPlayers()) {
            for (Deadline deadline : player.getDeadlines()) {
                shapeRenderer.setColor(player.getColor());
                shapeRenderer.rect(deadline.getX() + ((viewport.getWorldWidth() - Var.viewportWidth) / 2), deadline.getY() + ((viewport.getWorldHeight() - Var.viewportHeight) / 2), deadline.getWidth(), deadline.getHeight());
            }
        }
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

    public void setMenuScreen(MenuScreen menuScreen) {
        this.menuScreen = menuScreen;
    }

    public void setGameScreen(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
        gameWorld = gameScreen.getGameWorld();
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setState(GameState state) {
        this.state = state;
    }
}


