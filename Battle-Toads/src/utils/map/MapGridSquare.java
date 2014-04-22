package utils.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.maps.tiled.TiledMapTile;

/**
 * Square to be used with MapGrid.java
 * contains information about the TMX square
 * below. Will need the TMX map linked to it
 * in order to grab the information from it.
 * @author Kyle
 *
 */
public class MapGridSquare {
	
	private TiledMapTile TILE;
	private int xPos, yPos, size, ID;
	private SpriteBatch sb;
	//Debugging - Will be removed
	ShapeRenderer renderer;
	
	
	public MapGridSquare(int xPos, int yPos, int size, TiledMapTile tile)
	{
		this.TILE = tile;
		if(tile != null)
			this.ID = TILE.getId();
		this.xPos = xPos;
		this.yPos = yPos;
		this.size = size;
		//this.sb = batch;
		
		//Debugging - Will be removed
		renderer = new ShapeRenderer();
		renderer.setColor(0, 0, 1.0f, 1);
	}
	
	public void render()
	{
		//debugging rectangle
		renderer.begin(ShapeType.Line);
		renderer.rect(xPos, yPos, size, size);
		renderer.end();
	}
	
	public void dispose()
	{
		renderer.dispose();
		sb.dispose();
	}

}
