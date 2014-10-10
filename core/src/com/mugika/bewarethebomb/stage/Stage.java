package com.mugika.bewarethebomb.stage;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Stage {
	public int[] data;
	private Sprite [][] sprites;
	private int cursor;
	private float offset;
	public static final int DEFAULT_WIDTH=3,DEFAULT_HEIGHT=50;
	public static final int INSCREEN_WIDTH=3,INSCREEN_HEIGHT=6;
	public static final int TILE_HEIGHT=160,TILE_WIDTH=160;
	final float SCROLL_SPEED=1200f;
	public boolean animating;
	
	public Stage(){
		this.data=new int[DEFAULT_HEIGHT];
		this.sprites=new Sprite[INSCREEN_HEIGHT][INSCREEN_WIDTH];
		this.cursor=0;
		this.animating=false;
		initStage();
	}
	
	
	private void initStage(){
		for (int i=0 ;i <data.length;i++){
			for (int j=0;j<DEFAULT_WIDTH;j++){
				Random rn=new Random();
				data[i]=rn.nextInt(DEFAULT_WIDTH);
			}
		}
	}
	
	public void update(float delta){
		if (this.animating){
			offset=offset+SCROLL_SPEED*delta;
			if (offset>=TILE_HEIGHT){
				offset=0f;
				cursor+=1;
				animating=false;
			}
		}
	}
	
	public void draw(ShapeRenderer sr){
		sr.setColor(new Color(1, 1, 1, 1));
		sr.begin(ShapeType.Filled);
		for (int i=cursor;i< Math.min(this.data.length,cursor+INSCREEN_HEIGHT);i++){
			for (int j=0;j<DEFAULT_WIDTH;j++){
				if (data[i]==j)
					sr.rect(j*TILE_WIDTH, (i-cursor)*TILE_HEIGHT-offset, TILE_WIDTH, TILE_HEIGHT);
			}
		}
		sr.end();
		sr.begin(ShapeType.Line);
		for (int i=cursor;i< Math.min(this.data.length,cursor+INSCREEN_HEIGHT);i++){
			for (int j=0;j<DEFAULT_WIDTH;j++){
				if (data[i]!=j)
					sr.rect(j*TILE_WIDTH, (i-cursor)*TILE_HEIGHT-offset, TILE_WIDTH, TILE_HEIGHT);
			}
		}
		sr.end();
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		sr.begin(ShapeType.Filled);
		float alpha=(cursor>4)? 1f:cursor*0.25f;
		sr.setColor(new Color(1, 0, 0, alpha));
		sr.rect(0, 0, TILE_WIDTH*3, TILE_HEIGHT*3);
		sr.end();
	    Gdx.gl.glDisable(GL20.GL_BLEND);

		
		
		
	}
	
	public int getCurrentCursor(){
		return cursor;
	}
	
	public int getCurrentBombPosition(){
		if (cursor<data.length){
			return data[cursor];
		}
		else
			return -1;
	}
	
	public void draw(SpriteBatch batch){
		
	}


	public int getDataLength() {
		return data.length;
	}


}
