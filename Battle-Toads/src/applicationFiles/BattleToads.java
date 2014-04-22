package applicationFiles;

import screens.*;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class BattleToads extends Game{
	
	public MenuClass menu;
	public PlayClass play;
	public OptionsClass options;
	public HowToClass howto;
	public GameConfigureClass configure;	
	public BitmapFont font;
	
	boolean ESCAPEOverride = false;
	boolean Debugging = false;
	boolean LimitFPS = false;
	float FPSLimit = 30; // default, will be changed;
	
	FPSLogger log;

	@Override
	public void create() 
	{
		log = new FPSLogger();
		font = new BitmapFont();
		menu = new MenuClass(this);
		play = new PlayClass(this);
		options = new OptionsClass(this);
		howto = new HowToClass(this);
		configure = new GameConfigureClass(this);
		this.setScreen(menu);
	}
	
	public void render()
	{
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();
        this.update();
        log.log();
        if(Debugging)
        	((DebuggableScreen) this.getScreen()).debug();
	}
	
	private void update()
	{
		//FPS LIMITER || attempts to put the thread to sleep so it can limit FPS
		if(LimitFPS)
		{
			try 
			{
				Thread.sleep((long) (1000 / FPSLimit - Gdx.graphics.getDeltaTime()));
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		//ESCAPE CATCH || monitors the escape key to exit app. If override is invoked, it won't exit
		if(Gdx.input.isKeyPressed(Keys.ESCAPE) && !ESCAPEOverride)
		{
			Gdx.app.exit();
		}
		//DEBUGGING || monitors the F11 key to turn on and off debugging.
		if(Gdx.input.isKeyPressed(Keys.F11))
		{
			this.Debugging ^= true;
		}
	}
	
	public void toggleESCOverride()
	{
		this.ESCAPEOverride ^= true;
	}
	
	public void limitFPS(float FPS)
	{
		this.FPSLimit = FPS;
		this.LimitFPS = true;
	}
	
	public void limitFPS(boolean limit)
	{
		this.LimitFPS = limit;
	}
}
