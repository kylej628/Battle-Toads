package playScreen.entities;

import utils.data.Coord;
import utils.data.EntitySlot;
import utils.data.Movement;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class MovingEntity extends Entity{
	
	Movement Script = Movement.RANDOM;

	public MovingEntity(String passedID, String passedName, Coord position, Texture[] passedSprite, Animation passedAnimation, int passedDirection) 
	{
		super(passedID, passedName, position, passedSprite, passedAnimation, passedDirection);
	}
	
	public MovingEntity(String passedID, String passedName, Coord position, Texture[] passedSprite, Animation passedAnimation, int passedDirection, Movement script) 
	{
		super(passedID, passedName, position, passedSprite, passedAnimation, passedDirection);
		Script = script;
	}
	
	public MovingEntity(String passedID, String passedName, Coord position, Texture[] passedSprite, Animation passedAnimation, int passedDirection, Array<EntitySlot> passedSlots)
	{
		super(passedID, passedName, position, passedSprite, passedAnimation, passedDirection, passedSlots);
	}
	
	public MovingEntity(String passedID, String passedName, Coord position, Texture[] passedSprite, Animation passedAnimation, int passedDirection, Array<EntitySlot> passedSlots, Movement script)
	{
		super(passedID, passedName, position, passedSprite, passedAnimation, passedDirection, passedSlots);
		Script = script;
	}

	public void update()
	{
		
	}
	
	public void render(SpriteBatch batch)
	{
		//Updates internally --//
		this.update();
		//Renders -------------//
		super.render(batch);
		
	}
}
