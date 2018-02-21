package linus.fischer.gameobjects;

import linus.fischer.gameWorld.GameWorld;

public class DeadlineLeft extends Deadline {
    public DeadlineLeft(Player player, GameWorld gameWorld, float lastX, float lastY, boolean ported) {
        super(lastX+player.getWidth(), player.getY(), 0, player.getHeight(), gameWorld);
        if (ported) {
            super.y = lastY;
            super.x = player.getX();
        }
    }

    @Override
    public void update(float xDiff, float yDiff) {
        width = xDiff + gameWorld.getPlayer1().getWidth();
    }

    @Override
    public void end() {
        width = gameWorld.getBounds().getX() - x;
    }
}
