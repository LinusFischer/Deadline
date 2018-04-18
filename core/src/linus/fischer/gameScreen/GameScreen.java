package linus.fischer.gameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import linus.fischer.game.DeadlineGame;
import linus.fischer.gameWorld.GameRenderer;
import linus.fischer.gameWorld.GameWorld;
import linus.fischer.util.AssetLoader;
import linus.fischer.util.InputHandler;

public class GameScreen implements Screen {
    private DeadlineGame game;
    private GameWorld gameWorld;
    private GameRenderer gameRenderer;

    public GameScreen(DeadlineGame game) {
        this.game = game;
        gameWorld = new GameWorld();
        gameRenderer = new GameRenderer(gameWorld);
    }

    public GameWorld getGameWorld() {
        return gameWorld;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        gameWorld.update(delta);
        gameRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        gameRenderer.resize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        AssetLoader.dispose();
    }
}
