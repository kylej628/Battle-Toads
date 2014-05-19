package playScreen.entities;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.XmlReader.Element;

import utils.data.Coord;
import utils.data.Script;
import utils.xml.XMLReader;

public class ScriptRunner {
	
	private String SCRIPT;
	private int speed, xBound, yBound;
	private Entity entity;
	private Array<Script> script;
	
	public ScriptRunner(String scriptName, int scriptSpeed, int xBound, int yBound, Entity scriptedEntity)
	{
		this.SCRIPT = scriptName;
		this.speed = scriptSpeed;
		this.entity = scriptedEntity;
		this.xBound = xBound;
		this.yBound = yBound;
		this.loadScript(SCRIPT);
	}
	
	public ScriptRunner(String scriptName, int scriptSpeed, Coord bounds, Entity scriptedEntity)
	{
		this.SCRIPT = scriptName;
		this.speed = scriptSpeed;
		this.entity = scriptedEntity;
		this.xBound = bounds.X;
		this.yBound = bounds.Y;
		this.loadScript(SCRIPT);
	}
	
	public void update(float delta)
	{
		
	}
	
	private void loadScript(String script)
	{
		XMLReader xml = new XMLReader("assets/core/Scripts.xml", "Scripts");
		Element element = xml.getElement(script);
		for(int i = 0; i < element.getChildCount(); i++)
		{
			
		}
	}

}
