package linus.fischer.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;

public class Player {
    private float x, y, width, height;
    private static final int VELOCITY = 100;
    private Direction direction;
    private Color color;
    private boolean directionChanged;
    private boolean alive;

    private Rectangle hitbox;


    public Player(float x, float y, float size, Color color) {
        this.x = x;
        this.y = y;
        width = size;
        height = size;
        this.color = color;
        alive = true;
        setDirectionRandom();
        hitbox = new Rectangle(x, y, width, height);
    }

    public void update(float delta) {
        if (alive) {
            switch (direction) {
                case UP:
                    y += VELOCITY*delta;
                    break;
                case RIGHT:
                    x += VELOCITY * delta;
                    break;
                case DOWN:
                    y -= VELOCITY * delta;
                    break;
                case LEFT:
                    x -= VELOCITY * delta;
                    break;
            }
        }
        hitbox.set(x, y, width, height);
    }


    private void setDirectionRandom() {
        int r = (int) Math.round(Math.random() * 3);
        switch (r) {
            case 0:
                direction = Direction.UP;
                break;
            case 1:
                direction = Direction.RIGHT;
                break;
            case 2:
                direction = Direction.DOWN;
                break;
            case 3:
                direction = Direction.LEFT;
                break;
        }
    }

    public boolean getDirectionChanged() {
        return  directionChanged;
    }

    public void setDirectionChanged(boolean b) {
        directionChanged = b;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return  width;
    }

    public float getHeight() {
        return height;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        if (this.direction != direction) {
            this.direction = direction;
            directionChanged = true;
        }
    }


    public Color getColor() {
        return color;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isAlive() {
        return alive;
    }

    public Rectangle getHitbox() {
        return hitbox;
    }
}
