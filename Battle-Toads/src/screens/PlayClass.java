package screens;

import handlers.HandlerWrapper;
import playScreen.GUI.GuiClass;
import utils.data.Property;
import utils.map.MapGrid;
import applicationFiles.BattleToads;
import applicationFiles.DebuggableScreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class PlayClass implements DebuggableScreen{
	
	//Main game -----//
	public BattleToads GAME;
	
	//Camera --------//
	private OrthographicCamera cam;
	
	float xCorOffset, yCorOffset;
	float xTrueCam, yTrueCam;
	
	
	//Sprite Batch --//
	private SpriteBatch batch;
	private SpriteBatch debug;
	
	//GUI -----------//
	private GuiClass GUI;
	
	//Mouse position //
	private int MouseX=0, MouseY=0;
	
	//Handlers
	HandlerWrapper handlers;
	
	public PlayClass(BattleToads GAME)
	{
		
		//Links the game to the main game --//
		this.GAME = GAME;
		
		//Initializes camera ---------------//
		
		cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.translate(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
		cam.update();
		xCorOffset = Gdx.graphics.getWidth()/2;
		yCorOffset = Gdx.graphics.getHeight()/2;
		xTrueCam = cam.position.x - xCorOffset;
		yTrueCam = cam.position.y - yCorOffset;
		
		//Assigns a map --------------------//
		//MapLoad();
		
		
		//Initializes spriteBatch ----------//
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		batch.enableBlending();
		
		debug = new SpriteBatch();
		debug.enableBlending();
		
		//Initializes the GUI --------------//
		GUI = new GuiClass();
		
		handlers = new HandlerWrapper(cam);
		
		//Loads information for map movement
	}

	double tempX = 0;
	double tempY = 0;
	@Override
	public void render(float delta) {
		//Mouse update ---------//
		//--Pulls the position to temp doubles
		tempX = (Gdx.input.getX() + cam.position.x - Gdx.graphics.getWidth()/2) / 32;
		tempY = (Gdx.graphics.getHeight() - Gdx.input.getY() + cam.position.y - Gdx.graphics.getHeight()/2)/32;
		//--If temps are bigger than 0, assign
		if(tempX < 0 || tempY < 0)
		{MouseX = -1; MouseY = -1;}
		else
		{MouseX = (int) tempX; MouseY = (int) tempY;}
		
		//Render section -------//
		handlers.render(batch);
		GUI.render();
		batch.begin();
		cam.update();
		
		if(Gdx.input.isButtonPressed(0))
		{

			float destinationX, destinationY;
			xTrueCam = cam.position.x - xCorOffset;
			yTrueCam = cam.position.y - yCorOffset;
			
			float temp1 = -Gdx.input.getDeltaX();
			float temp2 = Gdx.input.getDeltaY();
			
			destinationX = (float) (xTrueCam + temp1);
			destinationY = (float) (yTrueCam + temp2);
			
			if(destinationX < 0 && cam.position.x > 0)
				destinationX = 0;
			if(destinationY < 0 && cam.position.y > 0)
				destinationY = 0;
			
			cam.position.set((destinationX - xCorOffset), (destinationY - yCorOffset), 0f);
			
			batch.setProjectionMatrix(cam.combined);
		}
		
		batch.end();
		debug.begin();
		GAME.font.setColor(Color.WHITE);
		//GAME.font.draw(debug, "Nother test", 10, -10);
		GAME.font.draw(debug, "Cam Position: " + cam.position.x + ", " + cam.position.y + ":", 10, 20);
		GAME.font.draw(debug, "Mouse: " + Gdx.input.getX() + ", " + Gdx.input.getY() + "/n" + "Grid Position: (" + MouseX + ", " + MouseY + ")", 0, 0);
		debug.end();
		
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		//Unlimit the rendering ------------//
		this.GAME.limitFPS(false);
	}
	
	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

	@Override
	public void debug() {
		// TODO Auto-generated method stub
		
	}

}
