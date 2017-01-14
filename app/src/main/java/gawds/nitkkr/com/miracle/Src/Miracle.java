package gawds.nitkkr.com.miracle.Src;

import android.app.Application;

/**
 * Created by Home Laptop on 14-Jan-17.
 */

public class Miracle extends Application
{
	private static Miracle miracle;

	public static Miracle getInstance(){return miracle;}

	public Miracle()
	{
		super();
		miracle =this;
	}
}
