package linus.fischer.gameobjects;

import linus.fischer.gameWorld.GameWorld;

public class DeadlineDown extends Deadline {
    private float originX;
    private float originY;

    public DeadlineDown(Player player, float lastX, float lastY, boolean ported) {
        super(player, player.getX(), lastY+player.getHeight(), player.getWidth(), 0);
        if (ported) {
            super.x = lastX;
            super.y = player.getY();
        }
        originX = x;
        originY = y;
    }

    @Override
    public void update(float playerX, float playerY) {
        y = playerY;
        height = originY - playerY;
        super.update(playerX, playerY);
    }

    @Override
    public void end(float delta) {
        height -= 512 * delta;
        if (height<=0) {
            dead = true;
        }
    }
}
