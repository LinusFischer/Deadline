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
    public void update(float xDiff, float yDiff) {
        height = yDiff;
    }

    @Override
    public void end() {
        height--;
    }
}
