package linus.fischer.gameWorld;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import linus.fischer.gameobjects.*;

import java.util.ArrayList;

public class GameWorld {
    private Player player1;
    private Rectangle bounds;
    private ArrayList<Deadline> deadlines;

    public GameWorld() {
        player1 = new Player(256, 256, 16, Color.ORANGE);
        bounds = new Rectangle();
        bounds.width = 512;
        bounds.height = 512;
        bounds.x  = 0;
        bounds.y = 0;
        deadlines = new ArrayList<Deadline>();
        switch (player1.getDirection()) {
            case UP:
                deadlines.add(new DeadlineUp(player1, this, player1.getX(), player1.getY(), false));
                break;
            case LEFT:
                deadlines.add(new DeadlineLeft(player1, this, player1.getX(), player1.getY(), false));
                break;
            case DOWN:
                deadlines.add(new DeadlineDown(player1, this, player1.getX(), player1.getY(), false ));
                break;
            case RIGHT:
                deadlines.add(new DeadlineRight(player1, this, player1.getX(), player1.getY(), false));
                break;
        }
    }

    public void update(float delta) {
        player1.update(delta);
        if (player1.getDirectionChanged()) {
            player1.setDirectionChanged(false);
            switch (player1.getDirection()) {
                case UP:
                    deadlines.add(new DeadlineUp(player1, this, deadlines.get(deadlines.size()-1).getX(), deadlines.get(deadlines.size()-1).getY(),false));
                    break;
                case LEFT:
                    deadlines.add(new DeadlineLeft(player1, this, deadlines.get(deadlines.size()-1).getX(), deadlines.get(deadlines.size()-1).getY(), false));
                    break;
                case DOWN:
                    deadlines.add(new DeadlineDown(player1, this, deadlines.get(deadlines.size()-1).getX(), deadlines.get(deadlines.size()-1).getY(), false));
                    break;
                case RIGHT:
                    deadlines.add(new DeadlineRight(player1, this, deadlines.get(deadlines.size()-1).getX(), deadlines.get(deadlines.size()-1).getY(), false));
                    break;
            }
        }
        float xDiff = player1.getX() - deadlines.get(deadlines.size() - 1).getX();
        float yDiff = player1.getY() - deadlines.get(deadlines.size() - 1).getY();
        deadlines.get(deadlines.size()-1).update(xDiff, yDiff);

        if (player1.getX()  < bounds.getX()) {
            player1.setX(bounds.getX()+bounds.getWidth());
            deadlines.get(deadlines.size()-1).end();
            deadlines.add(new DeadlineLeft(player1, this, deadlines.get(deadlines.size()-1).getX(), deadlines.get(deadlines.size()-1).getY(), true));
        } else {
            if (player1.getX() > bounds.getX() + bounds.getWidth()) {
                player1.setX(bounds.getX());
                deadlines.get(deadlines.size()-1).end();
                deadlines.add(new DeadlineRight(player1, this, deadlines.get(deadlines.size()-1).getX(), deadlines.get(deadlines.size()-1).getY(), true));
            }
        }

        if (player1.getY() < bounds.getY()) {
            player1.setY(bounds.getY() + bounds.getHeight());
            deadlines.get(deadlines.size()-1).end();
            deadlines.add(new DeadlineDown(player1, this, deadlines.get(deadlines.size()-1).getX(), deadlines.get(deadlines.size()-1).getY(), true));
        } else {
            if (player1.getY() > bounds.getY() + bounds.getHeight()) {
                player1.setY(bounds.getY());
                deadlines.get(deadlines.size()-1).end();
                deadlines.add(new DeadlineUp(player1, this, deadlines.get(deadlines.size()-1).getX(), deadlines.get(deadlines.size()-1).getY(),true));
            }
        }

    }
    public Player getPlayer1() {
        return player1;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public ArrayList<Deadline> getDeadlines() {
        return deadlines;
    }
}
