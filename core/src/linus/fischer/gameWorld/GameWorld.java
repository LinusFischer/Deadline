package linus.fischer.gameWorld;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import linus.fischer.gameobjects.*;
import linus.fischer.util.Var;

import java.util.ArrayList;

public class GameWorld {
    private ArrayList<Player> players;
    private Rectangle bounds;

    public GameWorld(int numberOfPlayers) {
        players = new ArrayList<>();
        for (int i=0; i<numberOfPlayers; i++) {
            Player player = new Player(generateCoords(),16, Var.colors.get(i));
            players.add(player);
        }

        bounds = new Rectangle();
        bounds.width = Var.viewportWidth;
        bounds.height = Var.viewportHeight;
        bounds.x  = 0;
        bounds.y = 0;
    }

    public void update(float delta) {
        for (Player player: players) {
            //update player
            player.update(delta);

            //update deadlines
            if (!player.getDeadlines().isEmpty() && !player.getEmptyDeadlines()) {
                if (player.getDirectionChanged()) {
                    player.setDirectionChanged(false);
                    player.addDeadline(false);
                    if (player.getDeadlines().size()-3>=0) {
                        player.getDeadlines().get(player.getDeadlines().size()-3).setKillOwnPlayer(true);
                    }
                }
                player.updateDeadline();
            }

            //empty deadlines
            if (player.getEmptyDeadlines()) {
                player.setEmptyDeadlines(player.emptyDeadlines(delta));
            }

            //port player if out of bounds
            if (player.getX()  < bounds.getX()) {
                player.setX(bounds.getX()+bounds.getWidth());
                player.addDeadline(true);
                if (player.getDeadlines().size()-3>=0) {
                    player.getDeadlines().get(player.getDeadlines().size()-3).setKillOwnPlayer(true);
                }
                player.getDeadlines().get(player.getDeadlines().size()-2).finish();
            } else {
                if (player.getX() > bounds.getX() + bounds.getWidth()) {
                    player.setX(bounds.getX());
                    player.addDeadline(true);
                    player.getDeadlines().get(player.getDeadlines().size()-2).setKillOwnPlayer(true);
                    if (player.getDeadlines().size()-3>=0) {
                        player.getDeadlines().get(player.getDeadlines().size()-3).setKillOwnPlayer(true);
                    }
                }
            }

            if (player.getY() < bounds.getY()) {
                player.setY(bounds.getY() + bounds.getHeight());
                player.addDeadline(true);
                if (player.getDeadlines().size()-3>=0) {
                    player.getDeadlines().get(player.getDeadlines().size()-3).setKillOwnPlayer(true);
                }
                player.getDeadlines().get(player.getDeadlines().size()-2).finish();
            } else {
                if (player.getY() > bounds.getY() + bounds.getHeight()) {
                    player.setY(bounds.getY());
                    player.addDeadline(true);
                    player.getDeadlines().get(player.getDeadlines().size()-2).setKillOwnPlayer(true);
                    if (player.getDeadlines().size()-3>=0) {
                        player.getDeadlines().get(player.getDeadlines().size()-3).setKillOwnPlayer(true);
                    }
                }
            }
        }

        //check collision
        for (Player player1: players) {
            for (Player player2: players) {
                for (Deadline deadline : player2.getDeadlines()) {
                    if (deadline.getKillOwnPlayer() || !player1.equals(player2)) {
                        if (deadline.getHitbox().overlaps(player1.getHitbox())) {
                            if (player1.isAlive()) {
                                player1.setAlive(false);
                                player1.setEmptyDeadlines(true);
                                player1.getDeadlines().get(player1.getDeadlines().size()-1).finish();
                            }
                        }
                    }
                }
            }
        }
    }


    private Vector2 generateCoords() {
        Vector2 v = new Vector2();
        v.x = (float) (Math.random()*462) + 20;
        v.y = (float) (Math.random()*462) + 20;
        return v;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    Rectangle getBounds() {
        return bounds;
    }

}
