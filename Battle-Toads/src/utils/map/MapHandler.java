package utils.map;

import playScreen.entities.EntityHandler;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;

/*-------------------------------------------------*
 *=================MAP HANDLER=====================*
 *-------------------------------------------------*
 * This class operates and maintains all of the maps
 * for the game. This class will house the rendering
 * of the maps as well as the map grids required for
 * the map to be functional. Anything to do with the
 * map will be handled through here.
 */
public class MapHandler {
	
	//Variables ---------//
	Array<TiledMap> maps;
	MapGrid GRID;
	private OrthogonalTiledMapRenderer renderer;
	
	private int CURRENT_MAP;
	
	//Entity Handler ----//
	EntityHandler Entities;
	
	public MapHandler()
	{
		//Creates the array for maps --//
		maps = new Array<TiledMap>();
		
		//Defaults the current map to the first one in the array
		CURRENT_MAP = 0;
		
		//Creates the renderer and assigns it a default map
		renderer = new OrthogonalTiledMapRenderer(maps.get(CURRENT_MAP));
		
		//Creates the entity handler --//
		Entities = new EntityHandler();
	}
	
	/**
	 * Adds a map to the map array.
	 * @param FileName
	 */
	public void loadMap(String FileName)
	{
		this.maps.add(new TmxMapLoader().load(FileName));
	}
	
	/**
	 * returns the map that is specified by the MapName given.
	 * @param MapName
	 * @return
	 */
	public TiledMap getMap(String MapName)
	{
		for(int i = 0; i < maps.size; i++)
		{
			if(MapName.equalsIgnoreCase((String) maps.get(i).getProperties().get("Name")))
			{
				return maps.get(i);
			}
		}
		return null;
	}
	
	public void setMap(String MapName)
	{
		for(int i = 0; i < maps.size; i++)
		{
			if(MapName.equalsIgnoreCase((String) maps.get(i).getProperties().get("Name")))
			{
				renderer.setMap(maps.get(i));
			}
		}
	}
	
	public void render(SpriteBatch batch)
	{
		renderer.render();
	}

}
