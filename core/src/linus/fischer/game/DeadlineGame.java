package linus.fischer.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import linus.fischer.gameScreen.GameScreen;
import linus.fischer.gameScreen.MenuScreen;
import linus.fischer.util.AssetLoader;
import linus.fischer.util.InputHandler;

public class DeadlineGame extends Game {
	private MenuScreen menuScreen;
	private GameScreen gameScreen;
	
	@Override
	public void create () {
		AssetLoader.load();
		menuScreen = new MenuScreen(this);
		gameScreen = new GameScreen(this);
		setScreen(menuScreen);
		Gdx.input.setInputProcessor(new InputHandler(this));
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
	}
	
	@Override
	public void dispose () {

	}
}
