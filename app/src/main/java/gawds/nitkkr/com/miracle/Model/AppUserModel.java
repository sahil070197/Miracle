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
		//editor.putString("UserType",getUserType());
	}
}
