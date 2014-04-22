package applicationFiles;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;

public class DesktopGame {
    public static void main (String[] args) {
        new LwjglApplication(new BattleToads(), "Battle Toads", 800, 600, true);
    }
}

