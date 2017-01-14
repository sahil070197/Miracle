package gawds.nitkkr.com.miracle.API;

import android.content.Context;

import gawds.nitkkr.com.miracle.Model.AppUserModel;
import gawds.nitkkr.com.miracle.Model.UserModel;

/**
 * Created by Home Laptop on 14-Jan-17.
 */

public class FetchData
{
	public void Login(Context context, String UserName, String Password, iResponseCallback callback)
	{
		if(callback!=null)
			callback.onSuccess(null);
		//if user exists, non null FAILED OBJECT
	}
	public void SignUp(Context context, UserModel model, iResponseCallback callback)
	{
		AppUserModel.setMainUser((AppUserModel)model);
		if(callback!=null)
			callback.onSuccess(null);
	}
}
