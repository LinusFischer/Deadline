package linus.fischer.gameobjects;

import linus.fischer.gameWorld.GameWorld;

public class DeadlineLeft extends Deadline {
    private float originX;
    private float originY;

    public DeadlineLeft(Player player, GameWorld gameWorld, float lastX, float lastY, boolean ported) {
        super(lastX+player.getWidth(), player.getY(), 0, player.getHeight(), gameWorld);
        if (ported) {
            super.y = lastY;
            super.x = player.getX();
        }
        originX = x;
        originY = y;
    }

    @Override
    public void update(float playerX, float playerY) {
        x = playerX;
        width = originX - playerX;
        super.update(playerX, playerY);
    }

    @Override
    public void end(float delta) {
        width -= 512 * delta;
        if (width<=0) {
            dead = true;
        }
    }
}
