package gawds.nitkkr.com.miracle.Model;

import java.io.Serializable;

/**
 * Created by Home Laptop on 15-Jan-17.
 */

public class SubjectModel implements Serializable
{
	public String getDescription()
	{
		return Description;
	}

	public void setDescription(String description)
	{
		Description = description;
	}

	public String getName()
	{
		return Name;
	}

	public void setName(String name)
	{
		Name = name;
	}

	public String getSubjectID()
	{
		return SubjectID;
	}

	public void setSubjectID(String subjectID)
	{
		SubjectID = subjectID;
	}

	public String getTeacherID()
	{
		return TeacherID;
	}

	public void setTeacherID(String teacherID)
	{
		TeacherID = teacherID;
	}

	public String getTeachername()
	{
		return Teachername;
	}

	public void setTeachername(String teachername)
	{
		Teachername = teachername;
	}

	private String SubjectID = "";
	private String Name = "";
	private String Description = "";
	private String Teachername = "";
	private String TeacherID = "";
}
