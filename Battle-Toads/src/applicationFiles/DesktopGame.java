package applicationFiles;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopGame {
    public static void main (String[] args) {
    	LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
    	config.resizable = false;
    	config.width = 800;
    	config.height = 600;
    	config.title = "Battle Toads";
    	config.useGL20 = true;
        new LwjglApplication(new BattleToads(), config);
    }
}

