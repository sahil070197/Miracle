package gawds.nitkkr.com.miracle.UI.Activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.List;

import gawds.nitkkr.com.miracle.Helper.ActionBarBack;
import gawds.nitkkr.com.miracle.Helper.ActivityHelper;
import gawds.nitkkr.com.miracle.Model.AttendanceModel;
import gawds.nitkkr.com.miracle.R;

public class AttendancePage extends AppCompatActivity
{
	private AttendanceModel attendanceModel=new AttendanceModel();
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_attendance);
		ActivityHelper.setCreateAnimation(this);

		ActionBarBack barBack=new ActionBarBack(this);
		barBack.setLabel(getIntent().getExtras().getString("Name"));
		attendanceModel=(AttendanceModel)getIntent().getExtras().getSerializable("Model");

		SetUpDataChart1();
		SetUpDataChart2();
		SetUpDataChart3();
	}
	void SetUpDataChart1()
	{
		PieChart pieChart=(PieChart)findViewById(R.id.Attended);

		List<PieEntry> entries = new ArrayList<>();
		entries.add(new PieEntry(((float)attendanceModel.getAttendedLectures()/attendanceModel.getTotalNumOfLectures()),"Attended"));
		entries.add(new PieEntry(((float)attendanceModel.getUndeliveredLectures()/attendanceModel.getTotalNumOfLectures()),"Upcoming"));

		PieDataSet set = new PieDataSet(entries, "Attendance");

			if (attendanceModel.isAttendanceLow())
			{
				set.setColors(new int[]{ AttendanceModel.colorAttendanceNotOK, AttendanceModel.colorUndelivered });
			}
			else
			{
				set.setColors(new int[]{ AttendanceModel.colorAttendanceOK, AttendanceModel.colorUndelivered });
			}

		PieData data = new PieData(set);
		pieChart.setCenterText("My Attendance\n"+ attendanceModel.getAttendedPercentage() + " %");
		pieChart.setData(data);
		if(attendanceModel.isAttendanceLow())
			pieChart.setCenterTextColor(AttendanceModel.colorAttendanceNotOK);
		else pieChart.setCenterTextColor(AttendanceModel.colorText);

		pieChart.setCenterTextSize(13);
		pieChart.setEntryLabelColor(AttendanceModel.colorLabel);
		pieChart.invalidate();
		pieChart.setHoleColor(ContextCompat.getColor(getApplicationContext(),R.color.back));
	}
	void SetUpDataChart2()
	{
		PieChart pieChart=(PieChart)findViewById(R.id.Held);

		List<PieEntry> entries = new ArrayList<>();
		entries.add(new PieEntry(((float)attendanceModel.getDeliveredLectures()/attendanceModel.getTotalNumOfLectures()),"Delivered"));
		entries.add(new PieEntry(((float)attendanceModel.getUndeliveredLectures()/attendanceModel.getTotalNumOfLectures()),"Upcoming"));

		PieDataSet set = new PieDataSet(entries, "Lectures");

		set.setColors(new int[]{ AttendanceModel.colorOther, AttendanceModel.colorUndelivered });

		PieData data = new PieData(set);
		pieChart.setCenterText("Lectures");
		pieChart.setData(data);

		pieChart.setCenterTextColor(AttendanceModel.colorText);

		pieChart.setCenterTextSize(13);
		pieChart.setEntryLabelColor(AttendanceModel.colorLabel);
		pieChart.invalidate();
		pieChart.setHoleColor(ContextCompat.getColor(getApplicationContext(),R.color.back));
	}
	void SetUpDataChart3()
	{
		BarChart lineChart=(BarChart) findViewById(R.id.DayChart);

		List<BarEntry> entries = new ArrayList<>();
		ArrayList<Integer> points=attendanceModel.getLectures();
		for(int x=0;x<points.size();x++)
		{
			if(points.get(x)==1)
				entries.add(new BarEntry(x*0.8f,20,"Lecture "+(x+1)));
			else
			if(points.get(x)==0)
				entries.add(new BarEntry(x*0.8f,0,"Lecture "+(x+1)));
			else
			if(points.get(x)==-1)
				entries.add(new BarEntry(x*0.8f,-20,"Lecture "+(x+1)));
		}
		for(int x=points.size();x<attendanceModel.getTotalNumOfLectures();x++)
			entries.add(new BarEntry(x*0.8f,0,"Lecture "+(x+1)));

		BarDataSet set = new BarDataSet(entries, "My Lectures");

		set.setColors(new int[]{ ContextCompat.getColor(this,R.color.c), ContextCompat.getColor(this,R.color.d)});

		BarData data = new BarData(set);
		data.setBarWidth(0.4f); // set custom bar width
		lineChart.setData(data);
		lineChart.setFitBars(true); // make the x-axis fit exactly all bars
		lineChart.invalidate();
	}

}
