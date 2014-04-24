package playScreen.entities;

import utils.data.Coord;
import utils.data.EntitySlot;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class EntityHandler {
	
	Array<Entity> Stationaries;
	Array<MovingEntity> Movables;
	
	public EntityHandler()
	{
		Stationaries = new Array<Entity>();
		Movables = new Array<MovingEntity>();
	}
	
	public void addStationaryEntity(String passedID, String passedName, Coord passedCoord, Texture[] passedSprite, Animation passedAnimation, int passedDirection)
	{
		Stationaries.add(new Entity(passedID, passedName, passedCoord, passedSprite, passedAnimation, passedDirection));
	}
	
	public void addStationaryEntity(String passedID, String passedName, Coord passedCoord, Texture[] passedSprite, Animation passedAnimation, int passedDirection, Array<EntitySlot> passedSlots)
	{
		Stationaries.add(new Entity(passedID, passedName, passedCoord, passedSprite, passedAnimation, passedDirection, passedSlots));
	}
	
	public void addMovableEntity(String passedID, String passedName, Coord position, Texture[] passedSprite, Animation passedAnimation, int passedDirection)
	{
		Movables.add( new MovingEntity(passedID, passedName, position, passedSprite, passedAnimation, passedDirection));
	}
	
	public void addMovableEntity(String passedID, String passedName, Coord position, Texture[] passedSprite, Animation passedAnimation, int passedDirection, Array<EntitySlot> passedSlots)
	{
		Movables.add( new MovingEntity(passedID, passedName, position, passedSprite, passedAnimation, passedDirection, passedSlots));
	}
	
	public void update(float delta, SpriteBatch batch)
	{	
		//Update and render the stationary entities
		for(int h = 0; h < Stationaries.size; h++)
		{
			Stationaries.get(h).update(delta);
		}
		for(int i = 0; i < Stationaries.size; i++)
		{
			Stationaries.get(i).render(batch);
		}
		
		//Update and render the moving entities
		for(int j = 0; j < Movables.size; j++)
		{
			Movables.get(j).update(delta);
		}
		for(int k = 0; k < Movables.size; k++)
		{
			Movables.get(k).render(batch);
		}
		
	}

}
