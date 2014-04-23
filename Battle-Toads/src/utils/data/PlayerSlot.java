package utils.data;

public class PlayerSlot
{
	private String TAG;
	private String objectId;
	
	/**
	 * non-visible data value holding a slot 'tag' and corresponding objectId
	 */
	PlayerSlot(String tag, String id)
	{
		TAG = tag;
		objectId = id;
	}
	
	PlayerSlot(String tag)
	{
		TAG = tag;
		objectId = "#0001";
	}
	
	public void setObjectId(String id)
	{
		this.objectId = id;
	}
	
	public String getObjectId()
	{
		return this.objectId;
	}
	
	public String getTag()
	{
		return this.TAG;
	}
}
