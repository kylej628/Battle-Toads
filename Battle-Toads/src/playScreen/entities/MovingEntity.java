package playScreen.entities;

import utils.data.Coord;
import utils.data.EntitySlot;
import utils.data.Movement;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;

public class MovingEntity extends Entity{
	
	Movement Script = Movement.RANDOM;

	public MovingEntity(Coord position, Sprite passedSprite, Animation passedAnimation, int passedDirection) 
	{
		super(position, passedSprite, passedAnimation, passedDirection);
	}
	
	public MovingEntity(Coord position, Sprite passedSprite, Animation passedAnimation, int passedDirection, Movement script) 
	{
		super(position, passedSprite, passedAnimation, passedDirection);
		Script = script;
	}
	
	public MovingEntity(Coord position, Sprite passedSprite, Animation passedAnimation, int passedDirection, Array<EntitySlot> passedSlots)
	{
		super(position, passedSprite, passedAnimation, passedDirection, passedSlots);
	}
	
	public MovingEntity(Coord position, Sprite passedSprite, Animation passedAnimation, int passedDirection, Array<EntitySlot> passedSlots, Movement script)
	{
		super(position, passedSprite, passedAnimation, passedDirection, passedSlots);
		Script = script;
	}


}
