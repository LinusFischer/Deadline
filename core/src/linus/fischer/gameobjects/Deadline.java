package linus.fischer.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import linus.fischer.gameWorld.GameWorld;

public class Deadline {
    float x, y, width, height;
    private Rectangle hitbox;
    private boolean killOwnPlayer;
    boolean dead = false;
    Player player;


    public Deadline(Player player, float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.player = player;
        hitbox = new Rectangle(x, y, width, height);
        killOwnPlayer = false;
    }

    public void update() {
        hitbox.set(x, y, width, height);
    }

    public void end(float delta) {

    }

    public void finish() {

    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }

    public float getY() {
        return y;
    }

    public float getX() {
        return x;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }

    public void setKillOwnPlayer(boolean killOwnPlayer) {
        this.killOwnPlayer = killOwnPlayer;
    }

    public boolean getKillOwnPlayer() {
        return killOwnPlayer;
    }

    public boolean isDead() {
        return dead;
    }
}
