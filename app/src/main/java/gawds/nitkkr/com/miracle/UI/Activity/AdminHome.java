package gawds.nitkkr.com.miracle.UI.Activity;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import gawds.nitkkr.com.miracle.Helper.ActionBarNavDrawer;
import gawds.nitkkr.com.miracle.R;

public class AdminHome extends AppCompatActivity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_home);

		ActionBarNavDrawer barNavDrawer=new ActionBarNavDrawer(this);
		barNavDrawer.setLabel(getString(R.string.app_name));
	}

	@Override
	public void onBackPressed()
	{
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START))
		{
			drawer.closeDrawer(GravityCompat.START);
		}
		else
		{
			super.onBackPressed();
		}
	}
}
