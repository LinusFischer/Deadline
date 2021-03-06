package linus.fischer.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import linus.fischer.game.DeadlineGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		if (System.getProperty("os.name").startsWith("Windows")) {
			config.x = LwjglApplicationConfiguration.getDesktopDisplayMode().width/2-4;
			config.y = 0;
			config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width / 2;
			config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height - 66;
		} else {
			config.x = LwjglApplicationConfiguration.getDesktopDisplayMode().width / 2;
			config.width = LwjglApplicationConfiguration.getDesktopDisplayMode().width / 2;
			config.height = LwjglApplicationConfiguration.getDesktopDisplayMode().height;
		}
		new LwjglApplication(new DeadlineGame(), config);
	}
}
