package gawds.nitkkr.com.miracle.Helper;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import gawds.nitkkr.com.miracle.R;


/**
 * Created by Home Laptop on 04-Nov-16.
 */

public class ActionBarSimple
{
	private AppCompatActivity activity;

	public ActionBarSimple(final AppCompatActivity activity)
	{
		this.activity = activity;
	}

	public void setLabel(String label)
	{
		( (TextView) activity.findViewById(R.id.actionbar_title) ).setText(label);
	}
}
