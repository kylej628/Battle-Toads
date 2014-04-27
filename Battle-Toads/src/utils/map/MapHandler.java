package utils.map;

import playScreen.entities.EntityHandler;
import utils.xml.XMLReader;
import utils.xml.XMLReader.ObjectType;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

/*-------------------------------------------------*
 *=================MAP HANDLER=====================*
 *-------------------------------------------------*
 * This class operates and maintains all of the maps
 * for the game. This class will house the rendering
 * of the maps as well as the map grids required for
 * the map to be functional. Anything to do with the
 * map will be handled through here.
 */

/*
 * mID LOOKUP:
 * 01: SPAWN
 * 02: WILDERNESS
 * 03: 
 */
public class MapHandler {
	
	//Variables ---------//
	Array<TiledMap> maps;
	Array<Element> xmlMaps;
	MapGrid GRID;
	private OrthogonalTiledMapRenderer renderer;
	
	private int CURRENT_MAP;
	
	//Entity Handler ----//
	EntityHandler Entities;
	
	//XML Reader --------//
	XMLReader xml;
	
	public MapHandler(XMLReader XML)
	{
		//Creates the array for maps --//
		maps = new Array<TiledMap>();
		
		//Defaults the current map to the first one in the array
		CURRENT_MAP = 0;
		
		//Creates the renderer and assigns it a default map
		renderer = new OrthogonalTiledMapRenderer(maps.get(CURRENT_MAP));
		
		//Creates the entity handler --//
		Entities = new EntityHandler();
		
		//Ties the passed XML Reader to the class!
		xml = XML;
		xmlMaps = xml.getList("maps");
	}
	
	/**
	 * Adds a map to the map array.
	 * @param FileName
	 */
	private void internalLoad(String FileName)
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
	
	public void loadMap2(String name)
	{
		boolean temp = false;
		Element workingElement;
		for(int i = 0; i < maps.size; i++)
		{
			if(maps.get(i).getProperties().get("name").equals(name))
			{
				temp = true;
				CURRENT_MAP = i;
			}
		}
		if(!temp)
		{
			workingElement = xml.getElement(ObjectType.MAP, name);
			this.internalLoad(workingElement.getAttribute("IFP"));
			
		}
	}

}
