package gawds.nitkkr.com.miracle.API;


import com.android.volley.NetworkError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONObject;

import gawds.nitkkr.com.miracle.Model.AppUserModel;
import gawds.nitkkr.com.miracle.Model.UserModel;

/**
 * Created by Home Laptop on 14-Jan-17.
 */

public class FetchData
{
	public void Login(String UserName, String Password, ResponseCallback callback)
	{
		if(callback!=null)
			callback.responseSwitch(ResponseStatus.Success,null);
		//if user exists, non null FAILED OBJECT
	}

	public void SignUp(final UserModel model, final ResponseCallback callback)
	{
		String registerUrl="http://localhost:8081/register";
		StringRequest request=new StringRequest(Request.Method.POST, registerUrl, new Response.Listener<String>() {
			@Override
			public void onResponse(String response)
			{
				try
				{
					JSONObject object = new JSONObject(response);
					int token=object.getInt("token");
					if(token!=-1)
					{
						AppUserModel.setMainUser((AppUserModel) model);
						AppUserModel.getMainUser().setToken(String.valueOf(token));
						AppUserModel.getMainUser().saveUser();
						if(callback!=null)
							callback.responseSwitch(ResponseStatus.Success,null);
					}
					else if(callback!=null)
						callback.responseSwitch(ResponseStatus.Failed,null);
				}
				catch (Exception e)
				{
					e.printStackTrace();
					if(callback!=null)
						callback.responseSwitch(ResponseStatus.Failed,null);
				}
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error)
			{
				error.printStackTrace();
				if(error instanceof NetworkError)
					if(callback!=null)
						callback.responseSwitch(ResponseStatus.NoNetwork,null);
				if(error instanceof TimeoutError)
					if(callback!=null)
						callback.responseSwitch(ResponseStatus.Timeout,null);
				if(error instanceof ServerError)
					if(callback!=null)
						callback.responseSwitch(ResponseStatus.ServerError,null);
			}
		});
	}

	public void sendReview(String TeacherID, String Title, String Review, ResponseCallback callback)
	{
		if(callback!=null)
			callback.responseSwitch(ResponseStatus.Success,null);
	}

	public void getSubjectDetails(String SubjectID, ResponseCallback callback)
	{
		if(callback!=null)
			callback.responseSwitch(ResponseStatus.Success,null);
	}

	public void getAttendance(String SubjectID, ResponseCallback callback)
	{
		if(callback!=null)
			callback.responseSwitch(ResponseStatus.Success,null);
	}

	public void getNotes(String SubjectID, ResponseCallback callback)
	{
		if(callback!=null)
			callback.responseSwitch(ResponseStatus.Success,null);
	}

	public void getResult(String SubjectID, ResponseCallback callback)
	{
		if(callback!=null)
			callback.onResponse(ResponseStatus.Success,null);
	}
}
