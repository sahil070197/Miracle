package gawds.nitkkr.com.miracle.UI.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.DigitsAuthButton;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;

import gawds.nitkkr.com.miracle.API.FetchData;
import gawds.nitkkr.com.miracle.API.ResponseCallback;
import gawds.nitkkr.com.miracle.API.ResponseStatus;
import gawds.nitkkr.com.miracle.Helper.ActivityHelper;
import gawds.nitkkr.com.miracle.Model.AppUserModel;
import gawds.nitkkr.com.miracle.Model.UserModel;
import gawds.nitkkr.com.miracle.Model.UserType;
import gawds.nitkkr.com.miracle.R;

public class SignUp extends AppCompatActivity
{
    private UserModel userModel = new UserModel();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        final Spinner spinner=(Spinner) findViewById(R.id.signUpType);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                if(spinner.getSelectedItemPosition()!=0)
                {
                    findViewById(R.id.Student).setVisibility(View.GONE);
                }
                else
                {
                    findViewById(R.id.Student).setVisibility(View.VISIBLE);
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
                pickupDetails();

                if(userModel.getMobileNumber().isEmpty())
                {
                    Toast.makeText(SignUp.this,"Verify Mobile Number",Toast.LENGTH_SHORT).show();
                    return;
                }

                final ProgressDialog dialog= new ProgressDialog(SignUp.this);
                dialog.setIndeterminate(true);
                dialog.setCancelable(false);
                dialog.setMessage("Signing Up");
                dialog.show();

                new FetchData().SignUp(userModel,new ResponseCallback()
                {
                    @Override
                    public void onFailed(Object object)
                    {
                        Toast.makeText(SignUp.this,"Sign Up Failed",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onSuccess(Object object)
                    {
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
                    public void onResponse(ResponseStatus responseStatus, Object object)
                    {
                        dialog.dismiss();
                    }
                });
            }
        });

        DigitsAuthButton digitsButton = (DigitsAuthButton) findViewById(R.id.auth_button);
        digitsButton.setCallback(new AuthCallback()
        {
            @Override
            public void success(DigitsSession session, String phoneNumber)
            {
                findViewById(R.id.auth_button).setVisibility(View.GONE);
                findViewById(R.id.Number).setVisibility(View.VISIBLE);
                (( TextView)findViewById(R.id.Number)).setText(phoneNumber);
                userModel.setMobileNumber(phoneNumber);
                Toast.makeText(SignUp.this,"Mobile Verification Successful",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void failure(DigitsException exception)
            {
                userModel.setMobileNumber("");
                Toast.makeText(SignUp.this,"Mobile Verification Failed",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void pickupDetails()
    {
        userModel.setName((( EditText)findViewById(R.id.name)).getText().toString());
        userModel.setPassword(((EditText)findViewById(R.id.Password)).getEditableText().toString());
        userModel.setEmail(((EditText)findViewById(R.id.email)).getText().toString());
        userModel.setGender(((Spinner)findViewById(R.id.gender)).getSelectedItem().toString());
        userModel.setRollNumber(((EditText)findViewById(R.id.rollNumber)).getText().toString());
        userModel.setUserType(UserType.getUserType(((Spinner)findViewById(R.id.signUpType)).getSelectedItemPosition()));
        userModel.setYear(((Spinner)findViewById(R.id.year)).getSelectedItem().toString());
        userModel.setBranch(((Spinner)findViewById(R.id.branch)).getSelectedItem().toString());
        userModel.setSection(((Spinner)findViewById(R.id.section)).getSelectedItem().toString());
    }

}
