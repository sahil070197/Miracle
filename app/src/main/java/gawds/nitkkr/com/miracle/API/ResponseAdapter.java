package gawds.nitkkr.com.miracle.API;

import android.widget.Toast;

import gawds.nitkkr.com.miracle.Src.Miracle;

/**
 * Created by Home Laptop on 14-Jan-17.
 */

public class ResponseAdapter implements iResponseCallback
{
	private int Duration = Toast.LENGTH_SHORT;

	@Override
	public void onSuccess(Object object)
	{
		onResponse(object);
		Toast.makeText(Miracle.getInstance().getApplicationContext(),"Success",Duration).show();
	}

	@Override
	public void onFailed(Object object)
	{
		onResponse(object);
		Toast.makeText(Miracle.getInstance().getApplicationContext(),"Failed, Please Try Again",Duration).show();
	}

	@Override
	public void onTimeOut(Object object)
	{
		onResponse(object);
		Toast.makeText(Miracle.getInstance().getApplicationContext(),"Connection Timed Out",Duration).show();
	}

	@Override
	public void onServerError(Object object)
	{
		onResponse(object);
		Toast.makeText(Miracle.getInstance().getApplicationContext(),"Server Error",Duration).show();
	}

	@Override
	public void onNoNetwork(Object object)
	{
		onResponse(object);
		Toast.makeText(Miracle.getInstance().getApplicationContext(),"No Network Connection",Duration).show();
	}

	public void onResponse(Object object)
	{
	}

	public void onResponseSwitch(ResponseStatus responseStatus, Object object)
	{
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
