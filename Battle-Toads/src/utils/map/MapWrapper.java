package utils.map;

import playScreen.componentEntity.Entity;
import playScreen.componentEntity.Entity.comp;
import playScreen.componentEntity.component.Movement;
import utils.data.Coord;
import utils.data.Script;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.Array;

public class MapWrapper
{
	//Variables -------//
	TiledMap map;
	public Array<Entity> entities;
	public Array<Portal> portals;
	
	public MapWrapper(String filePath)
	{
		//Loads the map ===========//
		map = new TmxMapLoader().load(filePath);
		
		//Creates an empty array ==//
		entities = new Array<Entity>();
		
		//Creates an empty array ==//
		portals = new Array<Portal>();
	}
	
	public MapWrapper(String filePath, Array<Entity> passedEntities, Array<Portal> passedPortals)
	{
		//Loads the map ===========//
		map = new TmxMapLoader().load(filePath);
				
		//Links the array =========//
		entities = passedEntities;
		
		//Links the array =========//
		portals = passedPortals;
	}
	
	public Array<Entity> getEntities()
	{
		return entities;
	}
	
	public Array<Portal> getPortals()
	{
		return portals;
	}
	
	public Portal getPortal(Coord position)
	{
		for(int i = 0; i < portals.size; i++)
		{
			if(portals.get(i).position.equals(position))
			{
				return portals.get(i);
			}
		}
		return null;
	}
}
