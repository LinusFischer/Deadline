package linus.fischer.gameobjects;

public class DeadlineLeft extends Deadline {
    private float originX;
    private float originY;

    DeadlineLeft(Player player, float lastX, float lastY, boolean ported) {
        super(player,lastX+player.getWidth(), player.getY(), 0, player.getHeight());
        if (ported) {
            super.y = lastY;
            super.x = player.getX();
        }
        originX = x;
        originY = y;
    }

    @Override
    public void update() {
        x = player.getX() + player.getWidth();
        width = originX - player.getX() - player.getWidth();
        super.update();
    }

    @Override
    public void end(float delta) {
        width -= 512 * 5 * delta;
        if (width<=0) {
            dead = true;
        }
    }

    @Override
    public void finish() {
        x -= player.getWidth();
        width += player.getWidth();
    }
}
