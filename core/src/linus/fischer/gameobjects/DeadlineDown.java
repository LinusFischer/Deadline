package linus.fischer.gameobjects;

import linus.fischer.gameWorld.GameWorld;

public class DeadlineDown extends Deadline {
    public DeadlineDown(Player player, GameWorld gameWorld, float lastX, float lastY, boolean ported) {
        super(player.getX(), lastY+gameWorld.getPlayer1().getHeight(), player.getWidth(), 0, gameWorld);
        if (ported) {
            super.x = lastX;
            super.y = player.getY();
        }
    }

    @Override
    public void update(float xDiff, float yDiff) {
        height = yDiff + gameWorld.getPlayer1().getHeight();
    }

    @Override
    public void end() {
        height = gameWorld.getBounds().getY()- y;
    }
}
