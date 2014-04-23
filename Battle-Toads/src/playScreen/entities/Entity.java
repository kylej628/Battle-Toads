package playScreen.entities;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.utils.Array;

import utils.data.Coord;
import utils.data.EntitySlot;
import utils.data.EntitySlot.SlotType;

public class Entity {
	
	//Variables
	Coord position;
	Sprite sprite;
	Animation animatedSprite;
	int direction;
	Array<EntitySlot> slots;
	
	public Entity(Coord position, Sprite passedSprite, Animation passedAnimation, int passedDirection)
	{
		this.position.set(position);
		sprite = passedSprite;
		animatedSprite = passedAnimation;
		direction = passedDirection;
		slots = new Array<EntitySlot>();
		/*Since no slotTags were passed, defaults assumed*/
		slots.add(new EntitySlot(SlotType.ARMOR, "Head"));		//Head slot (armor)
		slots.add(new EntitySlot(SlotType.ARMOR, "Chest"));		//Chest slot (armor)
		slots.add(new EntitySlot(SlotType.ARMOR, "Arms"));		//Arms slot (armor)
		slots.add(new EntitySlot(SlotType.ARMOR, "Legs"));		//Legs slot (armor)
		slots.add(new EntitySlot(SlotType.ARMOR, "Feet"));		//Feet slot (armor)
		slots.add(new EntitySlot(SlotType.WEAPON, "Right"));	//Right hand slot (weapon)
		slots.add(new EntitySlot(SlotType.WEAPON, "Left:"));	//Left hand slot (weapon)
	}
	
	public Entity(Coord position, Sprite passedSprite, Animation passedAnimation, int passedDirection, Array<EntitySlot> passedSlots)
	{
		this.position.set(position);
		sprite = passedSprite;
		animatedSprite = passedAnimation;
		direction = passedDirection;
		slots = new Array<EntitySlot>(passedSlots);
	}
	
}
