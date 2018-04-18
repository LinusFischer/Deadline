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
                case Input.Keys.W :
                    if (!(gameWorld.getPlayer1().getDirection() == Direction.DOWN)) {
                        gameWorld.getPlayer1().setDirection(Direction.UP);
                    }
                    return true;
                case Input.Keys.D :
                    if (!(gameWorld.getPlayer1().getDirection() == Direction.LEFT)) {
                        gameWorld.getPlayer1().setDirection(Direction.RIGHT);
                    }
                    return true;
                case Input.Keys.S :
                    if (!(gameWorld.getPlayer1().getDirection() == Direction.UP)) {
                        gameWorld.getPlayer1().setDirection(Direction.DOWN);
                    }
                    return true;
                case Input.Keys.A :
                    if (!(gameWorld.getPlayer1().getDirection() == Direction.RIGHT)) {
                        gameWorld.getPlayer1().setDirection(Direction.LEFT);
                    }
                    return true;
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
        /*ArrayList<TextButton>  buttons = menuScreen.getButtons();
        for (int i=0; i<buttons.size(); i++) {
           float buttonX = buttons.get(i).getX();
           float buttonY = buttons.get(i).getY();
           float buttonWidth = buttons.get(i).getWidth();
           float buttonHeight = buttons.get(i).getHeight();
           if (buttonX < screenX && (buttonX + buttonWidth) > screenX && buttonY < screenY && (buttonY + buttonHeight) > screenY) {

               buttons.get(i).setStyle();
           }
        }*/
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
