package com.mugika.bewarethebomb.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.utils.Json;
import com.mugika.bewarethebomb.BTBGame;
import com.mugika.bewarethebomb.ui.UISystem;
import com.mugika.uibuilder.UIStage;

public class MenuScreen implements Screen{
	BTBGame game;
	UISystem uisystem;
	
	public MenuScreen(BTBGame game) {
		this.game=game;
	}
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
        //Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        uisystem.render(delta);
        
		
	}

	@Override
	public void resize(int width, int height) {
		uisystem.resize(width, height);
	}

	@Override
	public void show() {
		FileHandle file = Gdx.files.internal("UIresources/uilayout.json");
		String text = file.readString();
		Json json = new Json();
		Object uistage = json.fromJson(Object.class, text);
		UIStage us=(UIStage)uistage;
		uisystem=new UISystem(us,"UIresources/");
		uisystem.setListener(new InputListener(){
			public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
		        System.out.println("down");
		        game.setScreen(new PlayScreen(game));
		        uisystem.dispose();
		        return true;
		    }

		    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
		        System.out.println("up");
		    }
		}, "playButton");
		System.out.println(json.prettyPrint(us));
		
	}

	private UISystem UISystem(UIStage us, String string) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

}
