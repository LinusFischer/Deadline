package linus.fischer.gameobjects;

import linus.fischer.gameWorld.GameWorld;

public class DeadlineRight extends Deadline {
    public DeadlineRight(Player player, float lastX, float lastY, boolean ported) {
        super(player, lastX, player.getY(), 0, player.getHeight());
        if (ported) {
            super.y = lastY;
            super.x = player.getX();
        }
    }

    @Override
    public void update(float playerX, float playerY) {
        width = playerX - x;
        super.update(playerX, playerY);
    }

    @Override
    public void end(float delta) {
        x += 512 * delta;
        width -= 512 * delta;
        if (width<=0) {
            dead = true;
        }
    }

    @Override
    public void finish() {
        width += player.getWidth();
    }
}
