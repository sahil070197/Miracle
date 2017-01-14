package gawds.nitkkr.com.miracle.Model;

import java.io.Serializable;

/**
 * Created by Home Laptop on 14-Jan-17.
 */

public enum UserType implements Serializable
{
	Student(1),
	Teacher(2),
	Admin(3);

	private int Value;

	public int Value(){return Value;}

	public static UserType getUserType(int Value)
	{
		switch (Value)
		{
			case 2: return Teacher;
			case 3: return Admin;
			default:return Student;
		}
	}

	UserType(int value)
	{
		this.Value = value;
	}
}
