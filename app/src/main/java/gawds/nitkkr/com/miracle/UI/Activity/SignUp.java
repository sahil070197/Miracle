package gawds.nitkkr.com.miracle.UI.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import gawds.nitkkr.com.miracle.R;

public class SignUp extends AppCompatActivity  {
    LinearLayout studentLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        studentLayout=(LinearLayout) findViewById(R.id.Student);
        final Spinner spinner=(Spinner) findViewById(R.id.signUpType);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int pos=spinner.getSelectedItemPosition();
                if(pos!=0)
                {
                    studentLayout.setVisibility(View.GONE);
                }
                else
                {
                    studentLayout.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
