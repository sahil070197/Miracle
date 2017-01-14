package gawds.nitkkr.com.miracle.UI.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gawds.nitkkr.com.miracle.API.FetchData;
import gawds.nitkkr.com.miracle.API.ResponseCallback;
import gawds.nitkkr.com.miracle.API.ResponseStatus;
import gawds.nitkkr.com.miracle.Model.AttendanceModel;
import gawds.nitkkr.com.miracle.Model.SubjectModel;
import gawds.nitkkr.com.miracle.R;
import gawds.nitkkr.com.miracle.UI.Activity.AttendancePage;

public class Attendance extends Fragment
{
	private AttendanceModel attendanceModel=new AttendanceModel();
	private SubjectModel model = new SubjectModel();
	private Context context;

	public static Attendance getInstance(Context context, SubjectModel model)
	{
		Attendance attendance=new Attendance();
		attendance.model=model;
		attendance.context=context;
		return attendance;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.fragment_attendance, container, false);
	}

	@Override
	public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
	{
		super.onViewCreated(view, savedInstanceState);
		FetchData();
	}

	private void FetchData()
	{
		new FetchData().getAttendance(model.getSubjectID(), new ResponseCallback()
		{
			@Override
			protected void onSuccess(Object object)
			{
				if(object!=null)
				{
					attendanceModel=(AttendanceModel)object;
					SetUpData();
				}
			}

			@Override
			protected void onResponse(ResponseStatus status, Object object)
			{
				getView().findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);
				if(status!=ResponseStatus.Success)
				{
					getView().findViewById(R.id.None).setVisibility(View.VISIBLE);
				}
			}
		});
	}

	public void SetUpData()
	{
		Integer[] points={1,0,1,1,1,1,1,1,1,0,1,-1,1,1,1};
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(points));

		attendanceModel.setLectures(list);
		attendanceModel.setTotalNumOfLectures(20);

		(( TextView)getView().findViewById(R.id.TotalLectures)).setText("Total Lectures: " + attendanceModel.getTotalNumOfLectures());
		(( TextView)getView().findViewById(R.id.DeliveredLectures)).setText("Delivered Lectures: " + attendanceModel.getDeliveredLectures());
		(( TextView)getView().findViewById(R.id.AttendedLectures)).setText("Attended Lectures: " + attendanceModel.getAttendedLectures());
		(( TextView)getView().findViewById(R.id.MissedLectures)).setText("Missed Lectures: " + attendanceModel.getMissedLectures());
		(( TextView)getView().findViewById(R.id.CancelledLectures)).setText("Cancelled Lectures: " + attendanceModel.getCanceledLectures());

		PieChart pieChart=(PieChart)getView().findViewById(R.id.chart);

		List<PieEntry> entries = new ArrayList<>();
		entries.add(new PieEntry(((float)attendanceModel.getAttendedLectures()/attendanceModel.getTotalNumOfLectures()),"Attended"));
		if (attendanceModel.getCanceledLectures()!=0)
			entries.add(new PieEntry(((float)attendanceModel.getCanceledLectures()/attendanceModel.getTotalNumOfLectures()),"Canceled"));
		entries.add(new PieEntry(((float)attendanceModel.getUndeliveredLectures()/attendanceModel.getTotalNumOfLectures()),"Upcoming"));

		PieDataSet set = new PieDataSet(entries, "Attendance");

		if(attendanceModel.getCanceledLectures()!=0)
		{
			if (attendanceModel.isAttendanceLow())
			{
				set.setColors(new int[]{ AttendanceModel.colorAttendanceNotOK, AttendanceModel.colorCanceled, AttendanceModel.colorUndelivered });
			}
			else
			{
				set.setColors(new int[]{ AttendanceModel.colorAttendanceOK, AttendanceModel.colorCanceled, AttendanceModel.colorUndelivered });
			}
		}
		else
		{
			if (attendanceModel.isAttendanceLow())
			{
				set.setColors(new int[]{ AttendanceModel.colorAttendanceNotOK, AttendanceModel.colorUndelivered });
			}
			else
			{
				set.setColors(new int[]{ AttendanceModel.colorAttendanceOK, AttendanceModel.colorUndelivered });
			}
		}

		PieData data = new PieData(set);
		pieChart.setCenterText("Attendance\n"+ attendanceModel.getAttendedPercentage() + " %");
		pieChart.setData(data);
		if(attendanceModel.isAttendanceLow())
			pieChart.setCenterTextColor(AttendanceModel.colorAttendanceNotOK);
		else pieChart.setCenterTextColor(AttendanceModel.colorText);
		pieChart.setCenterTextSize(13);
		pieChart.setEntryLabelColor(AttendanceModel.colorLabel);
		pieChart.invalidate();
		pieChart.setHoleColor(ContextCompat.getColor(context,R.color.back));

		getView().findViewById(R.id.Expand).setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View view)
			{
				Intent intent=new Intent(context,AttendancePage.class);
				Bundle bundle=new Bundle();
				bundle.putSerializable("Model",attendanceModel);
				bundle.putString("Name",model.getName());
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	}

}
