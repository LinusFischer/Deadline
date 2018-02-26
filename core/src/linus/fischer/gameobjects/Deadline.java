package linus.fischer.gameobjects;

import com.badlogic.gdx.math.Rectangle;
import linus.fischer.gameWorld.GameWorld;

public class Deadline {
    float x, y, width, height;
    GameWorld gameWorld;
    private Rectangle hitbox;
    private boolean killOwnPlayer;
    boolean dead = false;


    public Deadline(float x, float y, float width, float height, GameWorld gameWorld) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gameWorld = gameWorld;
        hitbox = new Rectangle(x, y, width, height);
        killOwnPlayer = false;
    }

    public void update(float playerX, float playerY) {
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
