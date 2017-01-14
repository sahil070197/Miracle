package gawds.nitkkr.com.miracle.Model;

import java.io.Serializable;

/**
 * Created by Home Laptop on 14-Jan-17.
 */

public class UserKey implements Serializable
{
	public String getName()
	{
		return Name;
	}

	public void setName(String name)
	{
		Name = name;
	}

	public String getToken()
	{
		return Token;
	}

	public void setToken(String token)
	{
		Token = token;
	}

	public String getUserID()
	{
		return UserID;
	}

	public void setUserID(String userID)
	{
		UserID = userID;
	}

	private String Token = "";
	private String Name = "";
	private String UserID = "";

}
