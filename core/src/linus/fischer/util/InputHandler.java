package linus.fischer.util;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import linus.fischer.game.DeadlineGame;
import linus.fischer.gameScreen.GameScreen;
import linus.fischer.gameScreen.MenuScreen;
import linus.fischer.gameWorld.GameWorld;
import linus.fischer.gameobjects.Direction;

import java.util.ArrayList;

public class InputHandler implements InputProcessor {
    private DeadlineGame game;
    private GameWorld gameWorld;
    private MenuScreen menuScreen;


    public InputHandler(DeadlineGame game) {
        this.game = game;
        gameWorld = game.getGameScreen().getGameWorld();
        menuScreen = game.getMenuScreen();
    }


    @Override
    public boolean keyDown(int keycode) {
        if (game.getScreen().getClass() == GameScreen.class) {
            switch (keycode) {
                case Input.Keys.W:
                    if (!(gameWorld.getPlayers().get(0).getDirection() == Direction.DOWN)) {
                        gameWorld.getPlayers().get(0).setDirection(Direction.UP);
                    }
                    return true;
                case Input.Keys.D:
                    if (!(gameWorld.getPlayers().get(0).getDirection() == Direction.LEFT)) {
                        gameWorld.getPlayers().get(0).setDirection(Direction.RIGHT);
                    }
                    return true;
                case Input.Keys.S:
                    if (!(gameWorld.getPlayers().get(0).getDirection() == Direction.UP)) {
                        gameWorld.getPlayers().get(0).setDirection(Direction.DOWN);
                    }
                    return true;
                case Input.Keys.A:
                    if (!(gameWorld.getPlayers().get(0).getDirection() == Direction.RIGHT)) {
                        gameWorld.getPlayers().get(0).setDirection(Direction.LEFT);
                    }
                    return true;
                case Input.Keys.UP:
                    if (gameWorld.getPlayers().size()>=2) {
                        if (!(gameWorld.getPlayers().get(1).getDirection() == Direction.DOWN)) {
                            gameWorld.getPlayers().get(1).setDirection(Direction.UP);
                        }
                    }
                    return true;
                case Input.Keys.RIGHT:
                    if (gameWorld.getPlayers().size()>=2) {
                        if (!(gameWorld.getPlayers().get(1).getDirection() == Direction.LEFT)) {
                            gameWorld.getPlayers().get(1).setDirection(Direction.RIGHT);
                        }
                    }
                    return true;
                case Input.Keys.DOWN:
                    if (gameWorld.getPlayers().size()>=2) {
                        if (!(gameWorld.getPlayers().get(1).getDirection() == Direction.UP)) {
                            gameWorld.getPlayers().get(1).setDirection(Direction.DOWN);
                        }
                    }
                    return true;
                case Input.Keys.LEFT:
                    if (gameWorld.getPlayers().size()>=2) {
                        if (!(gameWorld.getPlayers().get(1).getDirection() == Direction.RIGHT)) {
                            gameWorld.getPlayers().get(1).setDirection(Direction.LEFT);
                        }
                    }
            }
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
