package screens;

import playScreen.GUI.GuiClass;
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
	
	//Tiled Map -----//
	private TiledMap TmxMap;
	
	//Map Renderer --//
	private OrthogonalTiledMapRenderer MapRenderer;
	
	//Drawn Map Grid //
	private MapGrid test;
	public String CurrentMap;
	
	//Sprite Batch --//
	private SpriteBatch batch;
	
	//GUI -----------//
	private GuiClass GUI;
	
	//Mouse position //
	private int MouseX=0, MouseY=0;
	
	public PlayClass(BattleToads GAME)
	{
		
		//Links the game to the main game --//
		this.GAME = GAME;
		
		//Initializes camera ---------------//
		cam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 0);
		cam.update();
		
		//Assigns a map --------------------//
		//MapLoad();
		
		
		//Initializes spriteBatch ----------//
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		batch.enableBlending();
		
		//Initializes the GUI --------------//
		GUI = new GuiClass();
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
		MapRenderer.render();
		test.render(batch);
		GUI.render();
		batch.begin();
		cam.update();
		
		if(Gdx.input.isButtonPressed(0))
		{
			cam.translate((float) -(Gdx.input.getDeltaX()), (float) Gdx.input.getDeltaY(), 0);
			batch.setProjectionMatrix(cam.combined);
			MapRenderer.setView(cam);
		}
		
		GAME.font.setColor(Color.WHITE);
		GAME.font.draw(batch, "Nother test", 10, -10);
		GAME.font.draw(batch, "Cam Position: " + cam.position.x + ", " + cam.position.y + ":", 10, 20);
		GAME.font.draw(batch, "Mouse: " + Gdx.input.getX() + ", " + Gdx.input.getY() + "/n" + "Grid Position: (" + MouseX + ", " + MouseY + ")", 0, 0);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		
	}

	@Override
	public void show() {
		//Unlimit the rendering ------------//
		this.GAME.limitFPS(false);
		
		//Load the proper Map --------------//
		MapLoad();
	}
	
	private void MapLoad()
	{
		TmxMap = new TmxMapLoader().load(CurrentMap);
		MapRenderer = new OrthogonalTiledMapRenderer(TmxMap);
		MapRenderer.setView(cam);
		
		//Initializes a MapGrid ------------//
		test = new MapGrid(TmxMap, cam);
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
