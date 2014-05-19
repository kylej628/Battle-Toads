package playScreen.entities;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader.Element;

import utils.data.Coord;
import utils.data.Script;
import utils.xml.XMLReader;

enum Move{
	LEFT, RIGHT, UP, DOWN, PAUSE, LOOK_RANDOM, MOVE_RANDOM
}

public class ScriptRunner {
	
	private Script SCRIPT;
	private int speed, xBound, yBound;
	private Entity entity;
	private Array<Move> script;
	
	public ScriptRunner(Script script, int scriptSpeed, int xBound, int yBound, Entity scriptedEntity)
	{
		this.SCRIPT = script;
		this.speed = scriptSpeed;
		this.entity = scriptedEntity;
		this.xBound = xBound;
		this.yBound = yBound;
		this.loadScript(SCRIPT);
	}
	
	public ScriptRunner(Script script, int scriptSpeed, Coord bounds, Entity scriptedEntity)
	{
		this.SCRIPT = script;
		this.speed = scriptSpeed;
		this.entity = scriptedEntity;
		this.xBound = bounds.X;
		this.yBound = bounds.Y;
		this.loadScript(SCRIPT);
	}
	
	public void update(float delta)
	{
		
	}
	
	private void loadScript(Script passedScript)
	{
		String name;
		XMLReader xml = new XMLReader("assets/core/Scripts.xml", "Scripts");
		Element element = xml.getElement(name);
		for(int i = 0; i < element.getChildCount(); i++)
		{
			
		}
	}

}
