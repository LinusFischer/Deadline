package linus.fischer.gameWorld;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import linus.fischer.gameobjects.*;

public class GameWorld {
    private Player player1;
    private Rectangle bounds;

    public GameWorld() {
        player1 = new Player(256, 256, 8, Color.ORANGE);
        bounds = new Rectangle();
        bounds.width = 512;
        bounds.height = 512;
        bounds.x  = 0;
        bounds.y = 0;
    }

    public void update(float delta) {
        player1.update(delta);


        if (!player1.getDeadlines().isEmpty() && !player1.getEmptyDeadlines()) {
            if (player1.getDirectionChanged()) {
                player1.setDirectionChanged(false);
                player1.addDeadline(false);
                if (player1.getDeadlines().size()-3>=0) {
                    player1.getDeadlines().get(player1.getDeadlines().size()-3).setKillOwnPlayer(true);
                }
            }
            player1.updateDeadline();
        }

        if (player1.getEmptyDeadlines()) {
            player1.setEmptyDeadlines(player1.emptyDeadlines(delta));
        }

        if (player1.getX()  < bounds.getX()) {
            player1.setX(bounds.getX()+bounds.getWidth());
            player1.addDeadline(true);
            //TODO Enable Collision with own player for last Deadline(cant be added like others(bug)
            if (player1.getDeadlines().size()-3>=0) {
                player1.getDeadlines().get(player1.getDeadlines().size()-3).setKillOwnPlayer(true);
            }
        } else {
            if (player1.getX() > bounds.getX() + bounds.getWidth()) {
                player1.setX(bounds.getX());
                player1.addDeadline(true);
                player1.getDeadlines().get(player1.getDeadlines().size()-2).setKillOwnPlayer(true);
                if (player1.getDeadlines().size()-3>=0) {
                    player1.getDeadlines().get(player1.getDeadlines().size()-3).setKillOwnPlayer(true);
                }
            }
        }

        if (player1.getY() < bounds.getY()) {
            player1.setY(bounds.getY() + bounds.getHeight());
            player1.addDeadline(true);
            //TODO Enable Collision with own player for last Deadline(cant be added like others(bug)
            if (player1.getDeadlines().size()-3>=0) {
                player1.getDeadlines().get(player1.getDeadlines().size()-3).setKillOwnPlayer(true);
            }
        } else {
            if (player1.getY() > bounds.getY() + bounds.getHeight()) {
                player1.setY(bounds.getY());
                player1.addDeadline(true);
                player1.getDeadlines().get(player1.getDeadlines().size()-2).setKillOwnPlayer(true);
                if (player1.getDeadlines().size()-3>=0) {
                    player1.getDeadlines().get(player1.getDeadlines().size()-3).setKillOwnPlayer(true);
                }
            }
        }

        for (Deadline deadline : player1.getDeadlines()) {
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
        player1.setEmptyDeadlines(true);
        if (player1.getDeadlines().get(player1.getDeadlines().size()-1).getClass() == DeadlineUp.class || player1.getDeadlines().get(player1.getDeadlines().size()-1).getClass() == DeadlineRight.class) {
            player1.getDeadlines().get(player1.getDeadlines().size()-1).finish();
        }
    }
    public Player getPlayer1() {
        return player1;
    }

    public Rectangle getBounds() {
        return bounds;
    }

}
