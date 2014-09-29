package com.umad.washdoges.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.umad.washdoges.main;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
	    config.title = "Wash_Doges";
	    config.width = 800;
	    config.height = 480;
		new LwjglApplication(new main(), config);
	}
}
