package gawds.nitkkr.com.miracle.UI.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gawds.nitkkr.com.miracle.Helper.ActionBarBack;
import gawds.nitkkr.com.miracle.Helper.ActivityHelper;
import gawds.nitkkr.com.miracle.Model.AttendanceModel;
import gawds.nitkkr.com.miracle.R;

public class AttendancePage extends AppCompatActivity
{
	private AttendanceModel model=new AttendanceModel();
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_attendance);
		ActivityHelper.setCreateAnimation(this);

		ActionBarBack barBack=new ActionBarBack(this);
		barBack.setLabel(getIntent().getExtras().getString("Name"));
		model=(AttendanceModel)getIntent().getExtras().getSerializable("Model");
	}
}
