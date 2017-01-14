package gawds.nitkkr.com.miracle.Model;

import android.support.v4.content.ContextCompat;

import java.io.Serializable;
import java.util.ArrayList;

import gawds.nitkkr.com.miracle.R;
import gawds.nitkkr.com.miracle.Src.Miracle;

/**
 * Created by Home Laptop on 15-Jan-17.
 */

public class AttendanceModel implements Serializable
{
	public static final int colorText= ContextCompat.getColor(Miracle.getInstance().getApplicationContext(), R.color.a);
	public static final int colorAttendanceOK= ContextCompat.getColor(Miracle.getInstance().getApplicationContext(), R.color.b);
	public static final int colorAttendanceNotOK= ContextCompat.getColor(Miracle.getInstance().getApplicationContext(), R.color.c);
	public static final int colorCanceled= ContextCompat.getColor(Miracle.getInstance().getApplicationContext(), R.color.d);
	public static final int colorOther= ContextCompat.getColor(Miracle.getInstance().getApplicationContext(), R.color.b);
	public static final int colorUndelivered= ContextCompat.getColor(Miracle.getInstance().getApplicationContext(), R.color.e);
	public static final int colorLabel= ContextCompat.getColor(Miracle.getInstance().getApplicationContext(), R.color.TextColor);


	public ArrayList<Integer> getLectures()
	{
		return lectures;
	}

	public void setLectures(ArrayList<Integer> lectures)
	{
		this.lectures = lectures;
	}

	public int getTotalNumOfLectures()
	{
		return totalNumOfLectures;
	}

	public void setTotalNumOfLectures(int totalNumOfLectures)
	{
		this.totalNumOfLectures = totalNumOfLectures;
	}

	private int totalNumOfLectures = 0;
	private ArrayList<Integer> lectures = new ArrayList<>();

	public int getAttendedLectures()
	{
		if(lectures!=null)
		{
			int Count=0;
			for(Integer key : lectures)
			{
				if(key==1)
					++Count;
			}
			return Count;
		}
		else return 0;
	}

	public int currentLectureCount(){return lectures.size();}

	public int getMissedLectures()
	{
		return currentLectureCount()-getAttendedLectures() - getCanceledLectures();
	}

	public boolean isAttendanceLow()
	{
		return ((float)getAttendedLectures()/currentLectureCount())<0.75f;
	}

	public int getDeliveredLectures()
	{
		return currentLectureCount()-getCanceledLectures();
	}

	public int getUndeliveredLectures()
	{
		return totalNumOfLectures- currentLectureCount();
	}

	public int getCanceledLectures()
	{
		if(lectures!=null)
		{
			int Count=0;
			for(Integer key : lectures)
			{
				if(key==-1)
					++Count;
			}
			return Count;
		}
		else return 0;
	}

	public String getAttendedPercentage()
	{
		float m=(float)getAttendedLectures()/currentLectureCount();
		m*=100;
		return String.format("%.2f", m);
	}

}
