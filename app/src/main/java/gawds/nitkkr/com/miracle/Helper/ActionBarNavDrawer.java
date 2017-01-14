package gawds.nitkkr.com.miracle.Helper;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import gawds.nitkkr.com.miracle.R;

/**
 * Created by Home Laptop on 03-Nov-16.
 */

public class ActionBarNavDrawer
{
	private NavigationView navigationView = null;
	private AppCompatActivity activity;
	private int ID = -1;

	private void NavigationItemSelected()
	{
		int id = ID;
		ID = -1;
	}

	public ActionBarNavDrawer(final AppCompatActivity activity)
	{
		this.activity = activity;

		navigationView = (NavigationView) activity.findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
		{
			@Override
			public boolean onNavigationItemSelected(@NonNull MenuItem item)
			{
				ID = item.getItemId();
				DrawerLayout drawer = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
				drawer.closeDrawer(GravityCompat.START);
				return true;
			}
		});

		navigationView.setCheckedItem(0);

		activity.findViewById(R.id.actionbar_navButton).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				DrawerLayout drawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
				navigationView.setCheckedItem(0);
				drawerLayout.openDrawer(GravityCompat.START);
			}
		});
	}

	public boolean onBackPressed()
	{
		DrawerLayout drawer = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START))
		{
			drawer.closeDrawer(GravityCompat.START);
			return true;
		}
		return false;
	}

	public void setLabel(String label)
	{
		( (TextView) activity.findViewById(R.id.actionbar_title) ).setText(label);
	}
}
