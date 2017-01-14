package gawds.nitkkr.com.miracle.UI.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import gawds.nitkkr.com.miracle.API.FetchData;
import gawds.nitkkr.com.miracle.API.ResponseAdapter;
import gawds.nitkkr.com.miracle.Helper.ActivityHelper;
import gawds.nitkkr.com.miracle.Model.AppUserModel;
import gawds.nitkkr.com.miracle.R;

public class SignUp extends AppCompatActivity  {
    LinearLayout studentLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        studentLayout=(LinearLayout) findViewById(R.id.Student);
        final Spinner spinner=(Spinner) findViewById(R.id.signUpType);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
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

        findViewById(R.id.Register).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final ProgressDialog dialog= new ProgressDialog(SignUp.this);
                dialog.setIndeterminate(true);
                dialog.setCancelable(false);
                dialog.setMessage("Signing Up");
                dialog.show();

                new FetchData().SignUp(SignUp.this,null,new ResponseAdapter()
                {
                    @Override
                    public void onFailed(Object object)
                    {
                        onResponse(object);
                        Toast.makeText(SignUp.this,"Sign Up Failed",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(Object object)
                    {
                        onResponse(object);
                        Toast.makeText(SignUp.this,"Sign Up Successful",Toast.LENGTH_SHORT).show();
                        Intent intent = null;
                        switch (AppUserModel.getMainUser().getUserType())
                        {
                            case Student: intent=new Intent(SignUp.this, StudentHome.class);break;
                            case Admin: intent=new Intent(SignUp.this, AdminHome.class);break;
                            case Teacher: intent=new Intent(SignUp.this, TeacherHome.class);break;
                        }
                        startActivity(intent);
                        ActivityHelper.setExitAnimation(SignUp.this);
                        finish();
                    }

                    @Override
                    public void onResponse(Object object)
                    {
                        dialog.dismiss();
                    }
                });
            }
        });
    }
}
