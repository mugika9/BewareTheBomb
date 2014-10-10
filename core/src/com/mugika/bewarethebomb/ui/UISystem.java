package com.mugika.bewarethebomb.ui;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.mugika.uibuilder.UIItem;
import com.mugika.uibuilder.UIStage;

public class UISystem {
	private UIStage mstage;
	private String dir;
	private  Stage stage;
	private ArrayList<UIItem> items;
	private ArrayList<Actor> actors;
	
	public UISystem(UIStage uistage, String dir){
		this.mstage=uistage;
		this.dir=dir;
		 
	    stage = new Stage(new StretchViewport(480, 800));
		Gdx.input.setInputProcessor(stage);;
		items=new ArrayList<UIItem>();
		actors=new ArrayList<Actor>();
		for (int i =0 ; i< mstage.getItems().size();i++){
			UIItem item=(UIItem) mstage.getItems().get(i);
			items.add(item);
			
			Texture texture = new Texture(Gdx.files.internal(dir+item.getSrc()));

	        Image actor = new Image(texture);
	        actor.setPosition(item.getPosX(), 
	        		(mstage.getHeight()+mstage.getTranslateX()-item.getPosY())-item.getHeight()-mstage.getTranslateY());
	        actor.setBounds(actor.getX(), actor.getY(), actor.getWidth(), actor.getHeight());
	        
	        actors.add(actor);
	        stage.addActor(actor);
		}
	}


	public void setListener(InputListener listener,String tag){
		for (int i=0 ; i<items.size();i++){
			if (items.get(i).getId().equals(tag)){
				Actor actor=actors.get(i);
				actors.get(i).addListener(listener);
			}
		}
	}
	public void resize (int width, int height) {
	    stage.getViewport().update(width, height, true);
	}

	public void render (float delta) {
	    stage.act(delta);
	    stage.draw();
	}

	public void dispose() {
	    stage.dispose();
	}
}
