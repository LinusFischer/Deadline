package linus.fischer.gameobjects;

import linus.fischer.gameWorld.GameWorld;

public class Deadline {
    float x, y, width, height;
    GameWorld gameWorld;

    public Deadline(float x, float y, float width, float height, GameWorld gameWorld) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.gameWorld = gameWorld;
    }

    public void update( float xDiff, float yDiff) {

    }

    public void end() {

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
}
