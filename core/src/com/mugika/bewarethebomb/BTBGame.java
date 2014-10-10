package com.mugika.bewarethebomb;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mugika.bewarethebomb.screens.MenuScreen;
import com.mugika.bewarethebomb.screens.PlayScreen;

public class BTBGame extends Game{

	MenuScreen menuScreen;
	public static final int MENU=0,INGAME=1,GAMEOVER=2;
	public int gamestate;
	
	
	@Override
	public void create() {
		menuScreen = new MenuScreen(this);
		this.gamestate=MENU;
		setScreen(menuScreen);
	}
	

	
	
	
}
