package gawds.nitkkr.com.miracle.UI.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import gawds.nitkkr.com.miracle.API.FetchData;
import gawds.nitkkr.com.miracle.API.ResponseAdapter;
import gawds.nitkkr.com.miracle.Helper.ActionBarSimple;
import gawds.nitkkr.com.miracle.Helper.ActivityHelper;
import gawds.nitkkr.com.miracle.Model.AppUserModel;
import gawds.nitkkr.com.miracle.R;

public class Login extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActivityHelper.setCreateAnimation(this);

        ActionBarSimple barSimple =new ActionBarSimple(this);
        barSimple.setLabel("Login");

        findViewById(R.id.SignUp).setOnClickListener(SignUp);
        findViewById(R.id.Login).setOnClickListener(Login);
    }

    private View.OnClickListener SignUp = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            Intent intent=new Intent(Login.this,SignUp.class);
            startActivity(intent);
            ActivityHelper.setExitAnimation(Login.this);
            finish();
        }
    };

    private View.OnClickListener Login = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            String UserName = (( TextView)findViewById(R.id.UserName)).getText().toString().trim();
            String  Password = ((TextView)findViewById(R.id.Password)).getEditableText().toString().trim();
            if(UserName.isEmpty())
            {
                Toast.makeText(Login.this,"User Name Cannot Be Empty",Toast.LENGTH_SHORT).show();
                return;
            }
            if(Password.isEmpty())
            {
                Toast.makeText(Login.this,"Password Cannot Be Empty",Toast.LENGTH_SHORT).show();
                return;
            }
            new FetchData().Login(Login.this,UserName,Password,new ResponseAdapter()
            {
                @Override
                public void onFailed(Object object)
                {
                    if(object==null)
                        super.onFailed(object);
                    else
                    {
                        Toast.makeText(Login.this,"No Account Exists\nPlease Sign Up",Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onSuccess(Object object)
                {
                    Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                    Intent intent = null;
                    switch (AppUserModel.getMainUser().getUserType())
                    {
                        case Student: intent=new Intent(Login.this, StudentHome.class);break;
                        case Admin: intent=new Intent(Login.this, AdminHome.class);break;
                        case Teacher: intent=new Intent(Login.this, TeacherHome.class);break;
                    }
                    startActivity(intent);
                    ActivityHelper.setExitAnimation(Login.this);
                    finish();
                }
            });
        }
    };

}
