package utils.map;

import playScreen.entities.EntityHandler;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
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
	
	//Entity Handler ----//
	EntityHandler Entities;
	
	public MapHandler()
	{
		//Creates the array for maps --//
		maps = new Array<TiledMap>();
		
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

}
