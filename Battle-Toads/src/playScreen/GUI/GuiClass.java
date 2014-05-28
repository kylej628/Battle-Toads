package playScreen.GUI;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import utils.map.TacoClass;

public class GuiClass implements TacoClass{
	
	SpriteBatch batch;
	private OrthographicCamera Guicam;
	BitmapFont font;
	Texture GUIBacking;
	
	public GuiClass()
	{
		init();
	}

	@Override
	public void init()
	{
		batch = new SpriteBatch();
		batch.enableBlending();
		Guicam = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());	
		Guicam.position.set(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2, 0);
		Guicam.update();
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		batch.setProjectionMatrix(Guicam.combined);
		Guicam.update();
		GUIBacking = new Texture(Gdx.files.internal("assets/play/GUI Resources/Sample.png"));
	}

	@Override
	public void update()
	{
		
	}

	@Override
	public void render()
	{
		batch.begin();
		batch.draw(GUIBacking, 0, 0);
		//font.draw(batch, "This is a test", 20, 20);
		batch.end();
	}

	@Override
	public void dispose()
	{
		font.dispose();
		batch.dispose();
	}

	
}
