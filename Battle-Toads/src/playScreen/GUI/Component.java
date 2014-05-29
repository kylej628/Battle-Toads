package playScreen.GUI;

import utils.data.Justify;

public class Component {
	
	//Component information
	private String tag;
	private int width;
	private int height;
	private int x, y;
	
	//Component values
	private int maxValue;
	private int currentValue;
	private int minValue;
	
	public Component(GuiClass gui, String tag, int width, int height, int maxValue, int currentValue, int minValue, Justify just)
	{
		this.tag = tag;
		this.width = width;
		this.height = height;
		this.maxValue = maxValue;
		this.currentValue = currentValue;
		this.minValue = minValue;
		
		setPosition(gui, just);
	}
	
	private void setPosition(GuiClass gui, Justify just)
	{
		//Pull width and height information from the GUI class;
		int guiWidth = gui.GUIBacking.getWidth(), guiHeight = gui.getWidth();
		//Pull location information out of GUI class;
		double guiX = gui.
		
	}

}
