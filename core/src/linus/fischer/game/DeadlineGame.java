package linus.fischer.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import linus.fischer.gameScreen.GameScreen;
import linus.fischer.gameScreen.MenuScreen;
import linus.fischer.gameWorld.GameRenderer;
import linus.fischer.gameWorld.GameState;
import linus.fischer.util.AssetLoader;
import linus.fischer.util.InputHandler;
import linus.fischer.util.Var;

public class DeadlineGame extends Game {
	private MenuScreen menuScreen;
	private GameScreen gameScreen;
	private InputProcessor inputProcessor1;
	private InputProcessor inputProcessor2;
	private InputMultiplexer inputMultiplexer;
	private GameRenderer renderer;
	
	@Override
	public void create () {
		AssetLoader.load();
		renderer = new GameRenderer();
		menuScreen = new MenuScreen(this, renderer.getViewport());
		setScreen(menuScreen);

		renderer.setMenuScreen(menuScreen);

		inputProcessor2 = menuScreen.getStage();
		inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(inputProcessor2);
		Gdx.input.setInputProcessor(inputMultiplexer);

		menuScreen.init();
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}

	public MenuScreen getMenuScreen() {
		return menuScreen;
	}

	@Override
	public void render () {
		super.render();
		renderer.render();
	}
	
	@Override
	public void dispose () {

	}

	public void resize(int width, int height) {
		renderer.resize(width, height);
	}

	public void setState(GameState state) {
		switch (state) {
			case MAINMENU:
				setScreen(menuScreen);
				break;
			case GAME:
				if (gameScreen == null) {
					Var.init();
					gameScreen = new GameScreen(this);
					renderer.setGameScreen(gameScreen);

					inputProcessor1 = new InputHandler(this);
					inputMultiplexer.addProcessor(inputProcessor1);
				}
				setScreen(gameScreen);
				break;
		}
		renderer.setState(state);
	}
}
