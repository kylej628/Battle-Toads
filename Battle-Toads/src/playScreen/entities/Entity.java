package playScreen.entities;

import utils.data.Coord;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Entity {
	
	//Variables ---------//
	String interactionId;
	Texture sprite;
	Coord position;
	
	public Entity(String passedID, Texture passedSprite, Coord passedPosition)
	{
		this.interactionId = passedID;
		this.sprite = passedSprite;
		this.position = passedPosition;
	}
	
	public void update()
	{
		
	}
	
	public void render(SpriteBatch batch)
	{
		batch.draw(sprite, position.X, position.Y);
	}

}
