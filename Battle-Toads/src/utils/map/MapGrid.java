package utils.map;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class MapGrid {
	
	//Debugging -------------//
	private ShapeRenderer ShapeR;
	
	//Variables ------------//
	TiledMap tmx;
	MapProperties props;
	MapGridSquare[][] squares;
	OrthographicCamera cam;
	
	//Basic Variables -----//
	protected int WIDTH, HEIGHT;
	
	
	/**
	 * creates a grid based off of the tiled map
	 * - used for manipulation and board setup
	 * @param passedTmx - TiledMap
	 */
	public MapGrid(TiledMap passedTmx, OrthographicCamera PassedCam)
	{
		//Pull the TMX map and info ------------//
		this.tmx = passedTmx;
		props = tmx.getProperties();
		int WIDTH = props.get("width", Integer.class);
		System.out.println("Width: " + WIDTH);
		int HEIGHT = props.get("height", Integer.class);
		System.out.println("Height: " + HEIGHT);
		int tilePixelWidth = props.get("tilewidth", Integer.class);
		System.out.println("PixelWidth: " + tilePixelWidth);
		int tilePixelHeight = props.get("tileheight", Integer.class);
		System.out.println("PixelHeight: " + tilePixelHeight);
		
		//Link the camera to this camera -------//
		this.cam = PassedCam;
		
		squares = new MapGridSquare[WIDTH][HEIGHT];
		for(int i = 0; i < WIDTH; i++)
		{
			for(int j = 0; j < HEIGHT; j++)
			{
				squares[i][j] = new MapGridSquare(i * tilePixelWidth, j * tilePixelHeight, tilePixelWidth, null);
			}
		}
	}
	
	/**
	 * Used if anything needs to change on the map, special events / tile changes
	 */
	public void update()
	{
		
	}
	
	/**
	 * At this point there is no need for a spriteBatch but I'm putting it
	 * in there for future thinking!
	 * @param SB
	 */
	public void render(SpriteBatch SB)
	{
		for(int i = 0; i < this.WIDTH; i++)
		{
			for(int j = 0; j < this.HEIGHT; j++)
			{
				squares[i][j].render();
			}
		}
	}

}
