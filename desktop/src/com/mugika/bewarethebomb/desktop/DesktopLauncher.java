package com.mugika.bewarethebomb.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mugika.bewarethebomb.BTBGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width=480;
		config.height=800;
		new LwjglApplication(new BTBGame(), config);
	}
}
