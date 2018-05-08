package linus.fischer.gameobjects;

public class DeadlineUp extends Deadline {
   DeadlineUp(Player player, float lastX, float lastY, boolean ported) {
        super(player, player.getX(), lastY, player.getWidth(), 0);
        if (ported) {
            super.x = lastX;
            super.y = player.getY();
        }
    }

    @Override
    public void update() {
        height = player.getY() - y;
        super.update();
    }

    @Override
    public void end(float delta) {
        y += 512 * 5 * delta;
        height -= 512 * 5 * delta;
        if (height<=0) {
            dead = true;
        }
    }

    @Override
    public void finish() {
        height += player.getHeight();
    }
}
