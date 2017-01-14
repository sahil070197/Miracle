package gawds.nitkkr.com.miracle.API;

/**
 * Created by Home Laptop on 14-Jan-17.
 */

public interface iResponseCallback
{
	void onSuccess(Object object);
	void onFailed(Object object);
	void onTimeOut(Object object);
	void onServerError(Object object);
	void onNoNetwork(Object object);
	void onResponse(Object object);
}
