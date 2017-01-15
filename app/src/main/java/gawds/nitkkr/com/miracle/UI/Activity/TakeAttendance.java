package gawds.nitkkr.com.miracle.UI.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import gawds.nitkkr.com.miracle.R;

public class TakeAttendance extends AppCompatActivity {
    ListView studentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_attendance);
        studentList=(ListView) findViewById(R.id.attendanceList);
        ArrayList<String> objectArray=new ArrayList<>();
        ListAdapter customAdapter= new gawds.nitkkr.com.miracle.Model.ListAdapter(this,R.layout.attendance_list_item,objectArray);
        studentList.setAdapter(customAdapter);
    }
}
