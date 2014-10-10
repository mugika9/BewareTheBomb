package com.mugika.bewarethebomb.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mugika.bewarethebomb.BTBGame;
import com.mugika.bewarethebomb.stage.Stage;

public class PlayScreen implements Screen{
	Game mGame;
	ShapeRenderer sr;
	OrthographicCamera cam;
	int VirtualWidth=480;
	int VirtualHeight=800;
	TiledMapRenderer tiledMapRenderer;
    TiledMap tiledMap,CameraMap;
    SpriteBatch sb;
    Stage stage;
	
	public PlayScreen(Game game) {
		this.mGame=game;
	}
	
	@Override
	public void render(float delta) {
		handleInput();
		stage.update(delta);
		draw(delta);
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		cam = new OrthographicCamera();
		cam.zoom = 1f;
		sb= new SpriteBatch();
		
		
		

        

        sr=new ShapeRenderer();
        
		
		initiateCamera();
		sb.setProjectionMatrix(cam.combined);
		sr.setProjectionMatrix(cam.combined);
		this.stage=new Stage();
		
	}
	
	private void initiateCamera(){
        cam.setToOrtho(false,480, 800);
      	cam.position.set(240, 400, 0f);
      	cam.update();
		
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
	
	private void draw(float delta){
		Gdx.gl.glClearColor(0, 0, 0, 1);
        //Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cam.update();
        sr.setProjectionMatrix(cam.combined);
        
        stage.draw(sr);

    	
	}
	
	
	private void handleInput(){
		if (stage.getCurrentCursor()>=stage.getDataLength()){
			return;
		}
		
		if(Gdx.input.isKeyJustPressed(Keys.SPACE)) 
		{
			if (!stage.animating){
				stage.animating=true;
			}
		}
		if(Gdx.input.isKeyJustPressed(Keys.J)) 
		{
			if (!stage.animating ){
				if (stage.getCurrentBombPosition()!=0)
					stage.animating=true;
				else
					goToGameOverScreen();
			}
		}
		if(Gdx.input.isKeyJustPressed(Keys.K) ) 
		{
			if (!stage.animating ){
				if (stage.getCurrentBombPosition()!=1 )
					stage.animating=true;
				else
					goToGameOverScreen();
			}
			
		}
		if(Gdx.input.isKeyJustPressed(Keys.L) ) 
		{
			if (!stage.animating ){
				if (stage.getCurrentBombPosition()!=2)
					stage.animating=true;
				else
					goToGameOverScreen();
			}
			
		}
		
			

	}


	private void goToGameOverScreen() {
		((BTBGame)mGame).gamestate=BTBGame.GAMEOVER;
	
		this.mGame.setScreen(new GameOverScreen(mGame));
	}


}
