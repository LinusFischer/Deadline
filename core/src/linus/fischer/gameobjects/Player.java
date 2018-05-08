package linus.fischer.gameobjects;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import linus.fischer.util.Var;

import java.util.ArrayList;

public class Player {
    private float x, y, width, height;
    private Direction direction;
    private Color color;
    private boolean directionChanged;
    private boolean alive;
    private ArrayList<Deadline> deadlines;
    private Rectangle hitbox;
    private boolean emptyDeadlines;


    public Player(Vector2 coords, float size, Color color) {
        this.x = coords.x;
        this.y = coords.y;
        width = size;
        height = size;
        this.color = color;
        alive = true;
        setDirectionRandom();
        hitbox = new Rectangle(x, y, width, height);
        deadlines = new ArrayList<>();
        emptyDeadlines = false;

        switch (direction) {
            case UP:
                deadlines.add(new DeadlineUp(this,  x, y, false));
                break;
            case LEFT:
                deadlines.add(new DeadlineLeft(this, x, y, false));
                break;
            case DOWN:
                deadlines.add(new DeadlineDown(this, x, y, false ));
                break;
            case RIGHT:
                deadlines.add(new DeadlineRight(this, x, y, false));
                break;
        }
    }

    public void update(float delta) {
        if (alive) {
            switch (direction) {
                case UP:
                    y += Var.velocity*delta;
                    break;
                case RIGHT:
                    x += Var.velocity * delta;
                    break;
                case DOWN:
                    y -= Var.velocity * delta;
                    break;
                case LEFT:
                    x -= Var.velocity * delta;
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

    public void addDeadline(boolean ported) {
        switch (direction) {
            case UP:
                deadlines.add(new DeadlineUp(this, deadlines.get(deadlines.size()-1).getX(), deadlines.get(deadlines.size()-1).getY(), ported));
                break;
            case RIGHT:
                deadlines.add(new DeadlineRight(this, deadlines.get(deadlines.size()-1).getX(), deadlines.get(deadlines.size()-1).getY(), ported));
                break;
            case DOWN:
                deadlines.add(new DeadlineDown(this, deadlines.get(deadlines.size()-1).getX(), deadlines.get(deadlines.size()-1).getY(), ported));
                break;
            case LEFT:
                deadlines.add(new DeadlineLeft(this, deadlines.get(deadlines.size()-1).getX(), deadlines.get(deadlines.size()-1).getY(), ported));
                break;
        }
    }

    public void updateDeadline() {
        deadlines.get(deadlines.size()-1).update();
    }

    public boolean emptyDeadlines(float delta) {
        if (!deadlines.isEmpty()) {
            deadlines.get(0).end(delta);
            if (deadlines.get(0).isDead()) {
                deadlines.remove(0);
            }
        } else {
            return false;
        }
        return true;
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

    public ArrayList<Deadline> getDeadlines() {
        return deadlines;
    }

    public void setEmptyDeadlines(boolean emptyDeadlines) {
        this.emptyDeadlines = emptyDeadlines;
    }

    public boolean getEmptyDeadlines() {
        return emptyDeadlines;
    }

    public Color getColor() {
        return color;
    }
}
