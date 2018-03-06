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
    public void update() {
        y = player.getY() + player.getHeight();
        height = originY - player.getY()- player.getHeight();
        super.update();
    }

    @Override
    public void end(float delta) {
        height -= 512 * delta;
        if (height<=0) {
            dead = true;
        }
    }

    @Override
    public void finish() {
        y -= player.getHeight();
        height += player.getHeight();
    }
}
