package linus.fischer.gameWorld;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import linus.fischer.gameobjects.*;

import java.util.ArrayList;

public class GameWorld {
    private Player player1;
    private Rectangle bounds;
    private ArrayList<Deadline> deadlines;
    boolean emptyDeadlines = false;

    public GameWorld() {
        player1 = new Player(256, 256, 8, Color.ORANGE);
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


        if (!deadlines.isEmpty() && !emptyDeadlines) {
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
                if (deadlines.size()-3>=0) {
                    deadlines.get(deadlines.size()-3).setKillOwnPlayer(true);
                }
            }
            //float xDiff = player1.getX() - deadlines.get(deadlines.size() - 1).getX();
            //float yDiff = player1.getY() - deadlines.get(deadlines.size() - 1).getY();
            deadlines.get(deadlines.size()-1).update(player1.getX(), player1.getY());
        }

        if (emptyDeadlines) {
            if (!deadlines.isEmpty()) {
                deadlines.get(0).end(delta);
                if (deadlines.get(0).isDead()) {
                    deadlines.remove(0);
                }
            } else {
                emptyDeadlines = false;
            }
        }

        if (player1.getX()  < bounds.getX()) {
            player1.setX(bounds.getX()+bounds.getWidth());
            deadlines.add(new DeadlineLeft(player1, this, deadlines.get(deadlines.size()-1).getX(), deadlines.get(deadlines.size()-1).getY(), true));
            //TODO Enable Collision with own player for last Deadline(cant be added like others(bug)
            if (deadlines.size()-3>=0) {
                deadlines.get(deadlines.size()-3).setKillOwnPlayer(true);
            }
        } else {
            if (player1.getX() > bounds.getX() + bounds.getWidth()) {
                player1.setX(bounds.getX());
                deadlines.add(new DeadlineRight(player1, this, deadlines.get(deadlines.size()-1).getX(), deadlines.get(deadlines.size()-1).getY(), true));
                deadlines.get(deadlines.size()-2).setKillOwnPlayer(true);
                if (deadlines.size()-3>=0) {
                    deadlines.get(deadlines.size()-3).setKillOwnPlayer(true);
                }
            }
        }

        if (player1.getY() < bounds.getY()) {
            player1.setY(bounds.getY() + bounds.getHeight());
            deadlines.add(new DeadlineDown(player1, this, deadlines.get(deadlines.size()-1).getX(), deadlines.get(deadlines.size()-1).getY(), true));
            //TODO Enable Collision with own player for last Deadline(cant be added like others(bug)
            if (deadlines.size()-3>=0) {
                deadlines.get(deadlines.size()-3).setKillOwnPlayer(true);
            }
        } else {
            if (player1.getY() > bounds.getY() + bounds.getHeight()) {
                player1.setY(bounds.getY());
                deadlines.add(new DeadlineUp(player1, this, deadlines.get(deadlines.size()-1).getX(), deadlines.get(deadlines.size()-1).getY(),true));
                deadlines.get(deadlines.size()-2).setKillOwnPlayer(true);
                if (deadlines.size()-3>=0) {
                    deadlines.get(deadlines.size()-3).setKillOwnPlayer(true);
                }
            }
        }

        for (Deadline deadline : deadlines) {
            if (deadline.getKillOwnPlayer()) {
                if (deadline.getHitbox().overlaps(player1.getHitbox())) {
                    if (player1.isAlive()) {
                        killPlayer();
                    }
                }
            }
        }
    }


    private void killPlayer() {
        player1.setAlive(false);
        emptyDeadlines = true;
        if (deadlines.get(deadlines.size()-1).getClass() == DeadlineUp.class || deadlines.get(deadlines.size()-1).getClass() == DeadlineRight.class) {
            deadlines.get(deadlines.size()-1).finish();
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
