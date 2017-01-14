package gawds.nitkkr.com.miracle.Model;

import android.content.SharedPreferences;

import java.io.Serializable;

/**
 * Created by Home Laptop on 14-Jan-17.
 */

public class UserModel extends UserKey implements Serializable
{
	public String getBranch()
	{
		return branch;
	}

	public void setBranch(String branch)
	{
		this.branch = branch;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getMobileNumber()
	{
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber)
	{
		this.mobileNumber = mobileNumber;
	}

	public String getRollNumber()
	{
		return rollNumber;
	}

	public void setRollNumber(String rollNumber)
	{
		this.rollNumber = rollNumber;
	}

	public String getSection()
	{
		return section;
	}

	public void setSection(String section)
	{
		this.section = section;
	}

	public UserType getUserType()
	{
		return userType;
	}

	public void setUserType(UserType userType)
	{
		this.userType = userType;
	}

	public String getYear()
	{
		return year;
	}

	public void setYear(String year)
	{
		this.year = year;
	}

	private UserType userType = UserType.Student;
	private String rollNumber = "";
	private String branch = "";
	private String section  = "";
	private String mobileNumber = "";
	private String email = "";
	private String gender = "";
	private String year = "";
}
