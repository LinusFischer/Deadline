package linus.fischer.gameobjects;

public class DeadlineRight extends Deadline {
    DeadlineRight(Player player, float lastX, float lastY, boolean ported) {
        super(player, lastX, player.getY(), 0, player.getHeight());
        if (ported) {
            super.y = lastY;
            super.x = player.getX();
        }
    }

    @Override
    public void update() {
        width = player.getX() - x;
        super.update();
    }

    @Override
    public void end(float delta) {
        x += 512 * 5 * delta;
        width -= 512 * 5 * delta;
        if (width<=0) {
            dead = true;
        }
    }

    @Override
    public void finish() {
        width += player.getWidth();
    }
}
