package linus.fischer.gameobjects;

import linus.fischer.gameWorld.GameWorld;

public class DeadlineRight extends Deadline {
    public DeadlineRight(Player player, GameWorld gameWorld, float lastX, float lastY, boolean ported) {
        super(lastX, player.getY(), 0, player.getHeight(), gameWorld);
        if (ported) {
            super.y = lastY;
            super.x = player.getX();
        }
    }

    @Override
    public void update(float xDiff, float yDiff) {
        width = xDiff;
    }

    @Override
    public void end() {
        width--;
    }
}
