package linus.fischer.gameobjects;

import linus.fischer.gameWorld.GameWorld;

public class DeadlineUp extends Deadline {
    public DeadlineUp(Player player, GameWorld gameWorld, float lastX, float lastY, boolean ported) {
        super(player.getX(), lastY, player.getWidth(), 0, gameWorld);
        if (ported) {
            super.x = lastX;
            super.y = player.getY();
        }
    }

    @Override
    public void update(float playerX, float playerY) {
        height = playerY - y;
        super.update(playerX, playerY);
    }

    @Override
    public void end(float delta) {
        y += 512 * delta;
        height -= 512 * delta;
        if (height<=0) {
            dead = true;
        }
    }

    @Override
    public void finish() {
        height += gameWorld.getPlayer1().getHeight();
    }
}
