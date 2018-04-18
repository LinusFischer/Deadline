package linus.fischer.gameScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import linus.fischer.game.DeadlineGame;
import linus.fischer.util.AssetLoader;

import java.util.ArrayList;


public class MenuScreen implements Screen {
    private DeadlineGame game;
    private SpriteBatch batch;
    private Skin neon;
    private Stage stage;
    private ArrayList<TextButton> buttons;

    public MenuScreen(DeadlineGame game) {
        this.game = game;
        batch = new SpriteBatch();
        neon = AssetLoader.neon;
        stage = new Stage();
        buttons = new ArrayList<>();
        initButtons();
    }

    private void initButtons() {
        ArrayList<String> buttonLabels = new ArrayList<>();
        buttonLabels.add("Singleplayer");
        buttonLabels.add("Multiplayer");
        buttonLabels.add("Options");

        float gap = Gdx.graphics.getWidth()/24;
        float positionY = Gdx.graphics.getWidth()/12*buttonLabels.size() + gap * (buttonLabels.size() -1);
        positionY += (Gdx.graphics.getHeight() - positionY)/2;
        float positionX = Gdx.graphics.getWidth()/3;

        for (String label : buttonLabels) {
            TextButton button = new TextButton(label, neon, "default");
            button.setWidth(Gdx.graphics.getWidth()/3);
            button.setHeight(Gdx.graphics.getWidth()/12);
            button.setPosition(positionX, positionY);
            positionY = positionY - button.getHeight();
            buttons.add(button);
            stage.addActor(button);
        }
    }

    public ArrayList<TextButton> getButtons() {
        return buttons;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        stage.draw();
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

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
