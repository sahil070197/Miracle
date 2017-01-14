package gawds.nitkkr.com.miracle.Model;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.Serializable;

import gawds.nitkkr.com.miracle.Miracle;

/**
 * Created by Home Laptop on 14-Jan-17.
 */

public class AppUserModel extends UserModel implements Serializable
{
	private boolean isLogin = false;

	public boolean isLogin()
	{
		return isLogin;
	}

	public void saveUser()
	{
		SharedPreferences.Editor editor = Miracle.getInstance().getSharedPreferences("AppUser", Context.MODE_PRIVATE).edit();
		editor.putString("Token",getToken());
		editor.putString("Name",getName());
		editor.putString("UserID",getUserID());
		editor.putString("Year",getYear());
		editor.putString("Gender",getGender());
		editor.putString("Email",getEmail());
		editor.putString("Mobile",getMobileNumber());
		editor.putString("Section",getSection());
		editor.putString("Branch", getBranch());
		editor.putString("Roll",getRollNumber());
		editor.putInt("UserType",getUserType().Value());
		editor.putBoolean("Login",isLogin());
		editor.apply();
	}

	public void loadUser()
	{
		SharedPreferences preferences=Miracle.getInstance().getApplicationContext().getSharedPreferences("AppUser",Context.MODE_PRIVATE);
		setToken(preferences.getString("Token",""));
		setName(preferences.getString("Name",""));
		setUserID(preferences.getString("UserID",""));
		setYear(preferences.getString("Year",""));
		setGender(preferences.getString("Gender","Male"));
		setEmail(preferences.getString("Email",""));
		setMobileNumber(preferences.getString("Mobile",""));
		setSection(preferences.getString("Section",""));
		setBranch(preferences.getString("Branch",""));
		setRollNumber(preferences.getString("Roll",""));
		setUserType(UserType.getUserType(preferences.getInt("UserType",1)));
	}
}
