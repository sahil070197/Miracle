package gawds.nitkkr.com.miracle.API;

import android.widget.Toast;

import gawds.nitkkr.com.miracle.Src.Miracle;

/**
 * Created by Home Laptop on 14-Jan-17.
 */

public class ResponseCallback
{
	private int Duration = Toast.LENGTH_SHORT;

	protected void onSuccess(Object object)
	{
		Toast.makeText(Miracle.getInstance().getApplicationContext(),"Success",Duration).show();
	}

	protected void onFailed(Object object)
	{
		Toast.makeText(Miracle.getInstance().getApplicationContext(),"Failed, Please Try Again",Duration).show();
	}

	protected void onTimeOut(Object object)
	{
		Toast.makeText(Miracle.getInstance().getApplicationContext(),"Connection Timed Out",Duration).show();
	}

	protected void onServerError(Object object)
	{
		Toast.makeText(Miracle.getInstance().getApplicationContext(),"Server Error",Duration).show();
	}

	protected void onNoNetwork(Object object)
	{
		Toast.makeText(Miracle.getInstance().getApplicationContext(),"No Network Connection",Duration).show();
	}

	protected void onResponse(ResponseStatus status, Object object)
	{
	}

	public void responseSwitch(ResponseStatus responseStatus, Object object)
	{
		onResponse(responseStatus, object);
		switch (responseStatus)
		{
			case Success: onSuccess(object);break;
			case Failed: onFailed(object);break;
			case Timeout: onTimeOut(object);break;
			case ServerError: onServerError(object);break;
			case NoNetwork: onNoNetwork(object);break;
		}
	}

	public void setDuration(int duration)
	{
		this.Duration=duration;
	}
}
