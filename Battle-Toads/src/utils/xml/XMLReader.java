package utils.xml;

import com.badlogic.gdx.utils.XmlReader;
import com.badlogic.gdx.utils.XmlReader.Element;

public class XMLReader 
{
	public enum ObjectType{
		MAP, ITEM, INTERACTION
	}
	
	
	//Variables -------//
	String DEFAULT = "Blah";
	String[] DEFAULT_ARRAY = {"Blah", "Blah blah"};
	
	XmlReader reader;
	Element ROOT;
	
	public XMLReader(String file, String RootKey)
	{
		reader = new XmlReader();
		ROOT = reader.parse(file);
	}
	
	public String[] getList(String Key)
	{
		return DEFAULT_ARRAY;
	}
	
	public String getData(String Key)
	{
		return DEFAULT;
	}
	
	public Element getElement(ObjectType type, String id)
	{
		Element temp;
		switch (type)
		{
		case MAP: temp = ROOT.getChildByName("maps");
		return temp.getChildByName(id);
		case ITEM: temp = ROOT.getChildByName("items");
		return temp.getChildByName(id);
		case INTERACTION: temp = ROOT.getChildByName("interactions");
		return temp.getChildByName(id);
		
		default: return null;
		}
	}
	
	public Element getElement(String id)
	{
		return ROOT.getChildByNameRecursive(id);
	}
}
