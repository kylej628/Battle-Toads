package playScreen.entities;

import utils.data.Coord;
import utils.data.EntitySlot;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;

public class Player extends Entity{
	
	public Player(Coord position, Sprite passedSprite, Animation passedAnimation, int passedDirection)
	{
		super(position, passedSprite, passedAnimation, passedDirection);
	}

	public Player(Coord position, Sprite passedSprite, Animation passedAnimation, int passedDirection, Array<EntitySlot> passedSlots) 
	{
		super(position, passedSprite, passedAnimation, passedDirection, passedSlots);
	}

}
