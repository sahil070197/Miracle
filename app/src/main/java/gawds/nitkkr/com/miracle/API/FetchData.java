package gawds.nitkkr.com.miracle.API;


import gawds.nitkkr.com.miracle.Model.AppUserModel;
import gawds.nitkkr.com.miracle.Model.AttendanceModel;
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

	public void SignUp(UserModel model, ResponseCallback callback)
	{
		AppUserModel.setMainUser((AppUserModel)model);
		if(callback!=null)
			callback.onSuccess(null);
			callback.responseSwitch(ResponseStatus.Success,null);
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
			callback.responseSwitch(ResponseStatus.Success,new AttendanceModel());
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
