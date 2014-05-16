package utils.map;

import playScreen.componentEntity.Entity;
import utils.data.Coord;
import utils.xml.XMLReader;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader.Element;

public class MapWrapper {

	//Actual TmxMap
	TiledMap tiledMap;
	
	//Variables
	private String MAP_NAME;
	
	//XMLReader
	XMLReader reader;
	
	//Arrays - Portals and Entities
	Array<Entity> entities;
	Array<Portal> portals;
	
	public MapWrapper(String filename, XMLReader passedReader)
	{
		//Loads the tiled map
		tiledMap = new TmxMapLoader().load(filename);
		
		//Sets the name via the map
		MAP_NAME = tiledMap.getProperties().get("Map_Name").toString();
		
		//XMLReader
		reader = passedReader;
		
		//Initializes the entity array
		entities = new Array<Entity>();
		
		//Load entities
		Element entities_element;
		entities_element = reader.getElement(MAP_NAME).getChildByName("entities");
		
		//Entity temp information
		
		
		for(int i = 0; i < entities_element.getChildCount(); i++)
		{
			entities_element.getChild(i);
			//entities.add(new Entity(entities_element.getChild(i).getName(),entities_element.getChild(i).getAttribute("name"), new Coord()));
		}
		
		//Initializes the portal array
		portals  = new Array<Portal>();
	}
	
}
