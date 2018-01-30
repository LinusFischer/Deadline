package linus.fischer.gameWorld;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import linus.fischer.gameobjects.Player;

public class GameWorld {
    private Player player1;
    private Rectangle bounds;

    public GameWorld() {
        player1 = new Player(256, 256, 10, Color.ORANGE);
        bounds = new Rectangle();
        bounds.width = 512;
        bounds.height = 512;
        bounds.x  = 0;
        bounds.y = 0;
    }

    public void update(float delta) {
        player1.update(delta);
        if (player1.getX()  < bounds.getX()) {
            player1.setX(bounds.getX()+bounds.getWidth()-player1.getWidth());
        }

        if (player1.getY() < bounds.getY()) {
            player1.setY(bounds.getY() + bounds.getHeight()-player1.getHeight());
        }

        if (player1.getX() + player1.getWidth() > bounds.getX() + bounds.getWidth()) {
            player1.setX(bounds.getX());
        }

        if (player1.getY() + player1.getHeight() > bounds.getY() + bounds.getHeight()) {
            player1.setY(bounds.getY());
        }
    }
    public Player getPlayer1() {
        return player1;
    }

    public Rectangle getBounds() {
        return bounds;
    }


}
