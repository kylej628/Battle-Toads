package playScreen.entities;

import utils.data.Coord;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;

public class EntityHandler {
	
	Array<EntityOld> entities;
	
	public EntityHandler()
	{
		entities = new Array<EntityOld>();
	}
	
	public void addEntity(String passedID, Texture passedSprite, Coord passedCoord)
	{
		entities.add(new EntityOld(passedID, passedSprite, passedCoord, null));
	}
	
	public void update(float delta)
	{
		
	}

}
