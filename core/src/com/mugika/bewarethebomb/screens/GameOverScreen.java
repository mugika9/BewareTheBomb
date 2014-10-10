package com.mugika.bewarethebomb.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.mugika.bewarethebomb.BTBGame;
import com.mugika.bewarethebomb.stage.Stage;

public class GameOverScreen implements Screen {
	Game mGame;
	ShapeRenderer sr;
	OrthographicCamera cam;
	int VirtualWidth=480;
	int VirtualHeight=800;
	TiledMapRenderer tiledMapRenderer;
    TiledMap tiledMap,CameraMap;
    SpriteBatch sb;
    Stage stage;
    Sprite sp;

    
    public GameOverScreen(Game game) {
    	this.mGame=game;
	}
    
	@Override
	public void render(float delta) {
		handleInput();
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
		Texture texture=new Texture("GameOver.png");
		sp=new Sprite(texture);
        sr=new ShapeRenderer();
		
		initiateCamera();
		
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
	
	private void initiateCamera(){
        cam.setToOrtho(false,480, 800);
      	cam.position.set(240, 400, 0f);
      	cam.update();
	}


	
	private void draw(float delta){
		Gdx.gl.glClearColor(0, 0, 0, 1);
        //Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        cam.update();
        sb.begin();
        sp.draw(sb);
        sb.end();

    	
	}
	private void handleInput(){

		
		if(Gdx.input.isKeyJustPressed(Keys.SPACE)) 
		{
				mGame.setScreen(new MenuScreen((BTBGame) mGame));
		}
	}
}
