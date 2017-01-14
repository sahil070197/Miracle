package gawds.nitkkr.com.miracle.UI.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.digits.sdk.android.Digits;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterCore;

import gawds.nitkkr.com.miracle.Helper.ActivityHelper;
import gawds.nitkkr.com.miracle.Home;
import gawds.nitkkr.com.miracle.Model.AppUserModel;
import gawds.nitkkr.com.miracle.R;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class Splash extends AppCompatActivity {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "GK8W5w9NzYXR9B738hKeD99gE";
    private static final String TWITTER_SECRET = "pAJtRwd9vyib7KkAKqyYNLnfLKUdakfk0oPnOKi4WbbGjCvTWK";


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Crashlytics(), new TwitterCore(authConfig), new Digits.Builder().build());
        setContentView(R.layout.activity_splash);

        if(!ActivityHelper.isDebugMode())
            Fabric.with(this, new Crashlytics());

        AppUserModel.setMainUser(new AppUserModel().loadUser());

        if(AppUserModel.getMainUser().isLoggedIn())
        {
            Crashlytics.setUserName(AppUserModel.getMainUser().getName());
            Crashlytics.setUserEmail(AppUserModel.getMainUser().getEmail());
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run()
            {
                Intent intent;
                if(!AppUserModel.getMainUser().isLoggedIn())
                    intent = new Intent(Splash.this,Login.class);
                else intent = new Intent(Splash.this, Home.class);
                startActivity(intent);
                ActivityHelper.setExitAnimation(Splash.this);
                Splash.this.finish();
            }
        },getResources().getInteger(R.integer.waitTime));
    }
}
