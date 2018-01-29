package linus.fischer.util;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import linus.fischer.gameWorld.GameWorld;
import linus.fischer.gameobjects.Direction;

public class InputHandler implements InputProcessor {
    private GameWorld gameWorld;

    public InputHandler(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W :
                if (!(gameWorld.getPlayer1().getDirection() == Direction.DOWN)) {
                    gameWorld.getPlayer1().setDirection(Direction.UP);
                }
                break;
            case Input.Keys.D :
                if (!(gameWorld.getPlayer1().getDirection() == Direction.LEFT)) {
                    gameWorld.getPlayer1().setDirection(Direction.RIGHT);
                }
                break;
            case Input.Keys.S :
                if (!(gameWorld.getPlayer1().getDirection() == Direction.UP)) {
                    gameWorld.getPlayer1().setDirection(Direction.DOWN);
                }
                break;
            case Input.Keys.A :
                if (!(gameWorld.getPlayer1().getDirection() == Direction.RIGHT)) {
                    gameWorld.getPlayer1().setDirection(Direction.LEFT);
                }
                break;
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
