package linus.fischer.gameWorld;

import com.badlogic.gdx.graphics.Color;
import linus.fischer.gameobjects.Player;

public class GameWorld {
    private Player player1;

    public GameWorld() {
        player1 = new Player(256, 256, 10, Color.ORANGE);
    }

    public void update(float delta) {
        player1.update(delta);
    }

    public Player getPlayer1() {
        return player1;
    }
}
