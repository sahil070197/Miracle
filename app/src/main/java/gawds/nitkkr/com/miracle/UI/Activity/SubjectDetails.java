package gawds.nitkkr.com.miracle.UI.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import gawds.nitkkr.com.miracle.R;

public class SubjectDetails extends AppCompatActivity {
    TextView actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subject_details);
        // Change action Bar title
        actionBar=(TextView) findViewById(R.id.actionbar_title);
        actionBar.setText(""/*Subject Name here*/);
    }
}
