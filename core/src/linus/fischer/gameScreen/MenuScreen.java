package linus.fischer.gameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.Viewport;
import linus.fischer.game.DeadlineGame;
import linus.fischer.gameWorld.GameState;
import linus.fischer.util.AssetLoader;

import java.util.ArrayList;

enum Menus {
    MAIN,
    SINGLEPLAYER,
    MULTIPLAYER
}

public class MenuScreen implements Screen {
    private DeadlineGame game;
    private Skin quantumHorizon;
    private Stage stage;
    private Table ui;
    ArrayList<TextButton> mainButtons;
    ArrayList<TextButton> multiplayerButtons;

    public MenuScreen(DeadlineGame game, Viewport viewport) {
        this.game = game;
        quantumHorizon = AssetLoader.quantumHorizon;
        stage = new Stage(viewport);
        ui = new Table();
        ui.setFillParent(true);
    }

    public void init() {
        ArrayList<String> buttonLabels = new ArrayList<>();
        ArrayList<TextButton> buttons = new ArrayList<>();
        buttonLabels.add("Singleplayer");
        buttonLabels.add("Multiplayer ");
        buttonLabels.add("  Options   ");

        //TODO add listeners to buttons
        for (String label : buttonLabels) {
            TextButton button = new TextButton(label, quantumHorizon, "default");

            ui.add(button).prefWidth(Gdx.graphics.getWidth()/3).pad(5);
            ui.row();

            buttons.add(button);
        }
        stage.addActor(ui);

        buttons.get(1).addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setState(GameState.GAME);
            }
        });
    }


    public Stage getStage() {
        return stage;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
    }

    @Override
    public void resize(int width, int height) {
        game.resize(width, height);
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

    }
}
