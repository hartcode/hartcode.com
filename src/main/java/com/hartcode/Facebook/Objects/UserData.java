package com.hartcode.Facebook.Objects;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class UserData {

	public UserData() {}
	
	
	@SerializedName("id")
	public String ID;
	@SerializedName("first_name")
	public String First_Name;
	@SerializedName("last_name")
	public String Last_Name;
	@SerializedName("email")
	public String Email;
	@SerializedName("gender")
	public String Gender;
	@SerializedName("timezone")
	public Integer timezone;
	@SerializedName("verified")
	public Boolean Verified;
	@SerializedName("updated_time")
	public String Updatedtime;
	@SerializedName("locale")
	public String locale;
	public Date updated = null;
	
	public char getGender()
	{
		char retval = 'u';
		if (Gender != null)
		{
			retval = Gender.charAt(0);
		}
		return retval;
	}
	
	public Date getUpdatedTime()
	{
		if (updated == null)
		{
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
			if (Updatedtime != null && Updatedtime.length()>19)
			{
				Updatedtime = Updatedtime.substring(0,19);
			}
			try {
				updated = sdf.parse(Updatedtime);
			} catch (Exception e1) {
				updated = null;
			}
		}
		return updated;
	}
 }
