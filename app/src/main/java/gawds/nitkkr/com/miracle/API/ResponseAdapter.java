package gawds.nitkkr.com.miracle.API;

import android.widget.Toast;

import gawds.nitkkr.com.miracle.Miracle;

/**
 * Created by Home Laptop on 14-Jan-17.
 */

public class ResponseAdapter implements iResponseCallback
{
	@Override
	public void onSuccess(Object object)
	{
		Toast.makeText(Miracle.getInstance().getApplicationContext(),"Success",Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onFailed(Object object)
	{
		Toast.makeText(Miracle.getInstance().getApplicationContext(),"Failed, Please Try Again",Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onTimeOut(Object object)
	{
		Toast.makeText(Miracle.getInstance().getApplicationContext(),"Connection Timed Out",Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onServerError(Object object)
	{
		Toast.makeText(Miracle.getInstance().getApplicationContext(),"Server Error",Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onNoNetwork(Object object)
	{
		Toast.makeText(Miracle.getInstance().getApplicationContext(),"No Network Connection",Toast.LENGTH_SHORT).show();
	}

	public void onResponse(ResponseStatus responseStatus, Object object)
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

}
