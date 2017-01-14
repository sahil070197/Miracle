package gawds.nitkkr.com.miracle.Helper;

import android.app.Activity;

import gawds.nitkkr.com.miracle.R;

/**
 * Created by Home Laptop on 14-Jan-17.
 */

public class ActivityHelper
{
	public static boolean isDebugMode()
	{
		return true;
	}

	public static void setCreateAnimation(Activity activity)
	{
		activity.overridePendingTransition(R.anim.anim_right_in, R.anim.anim_none);
	}

	public static void setExitAnimation(Activity activity)
	{
		activity.overridePendingTransition(R.anim.anim_none, R.anim.anim_right_out);
	}
}
