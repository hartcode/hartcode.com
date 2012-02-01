package com.hartcode.news;

import java.security.InvalidParameterException;

import com.hartcode.news.poster.data.NewsPosterDAO;
import com.hartcode.news.reader.data.NewsReaderDAO;

public class NewsImageItem {
	private static final int DEFAULT_LOCATION_INDEX = Integer.MIN_VALUE;
	private int m_LocationIndex = DEFAULT_LOCATION_INDEX;
	private Integer m_ImageID =null;
	private Integer m_NewsID =null;
	private static String TableName = "NewsImageItem";
	private NewsImageItem()
	{

	}
	public NewsImageItem(int newsid, int imageid, int location)
	{
		setNewsID(newsid);
		setImageID(imageid);
		setLocationIndex(location);
		SQLInsert();
	}
	private void setLocationIndex(int locationIndex) {
		if (locationIndex < 0)
		{
			throw new InvalidParameterException("locationIndex cannot be less than 0.");
		}
		m_LocationIndex = locationIndex;
	}
	public int getLocationIndex() {
		return m_LocationIndex;
	}
	
	public ImageItem getImage() {
		ImageItem retval = null;
		if (getImageID() != null)
		{
			retval = new ImageItem(getImageID());
		}
		return retval;
	}
	private void SQLInsert()
	{
		Integer imageid = getImageID();
		Integer newsid = getNewsID();
		Integer location = getLocationIndex();
		


		String sql = "Insert into "+TableName+" (newsitemid,imageid,location) values";
		sql += "("+newsid.toString()+","+imageid.toString()+","+location.toString()+");";
		try {
			NewsPosterDAO dao = new NewsPosterDAO();
			dao.ExecuteSql(sql);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static NewsImageItem[] GetByNewsID(Integer NewsID)
	{
		NewsImageItem[] retval = null;
		if (NewsID != null)
		{
			String sql = "Select linkID, location from "+TableName+" where newsitemid = " + NewsID.toString();
			try {
				NewsReaderDAO dao = new NewsReaderDAO();
				Object[][] obj = dao.Select(sql);
				retval = new NewsImageItem[obj.length];
				for (int row = 0; row < obj.length; row++)
				{
					NewsImageItem nii = new NewsImageItem();
					nii.setNewsID(NewsID);
					nii.setImageID((Integer)obj[row][0]);
					nii.setLocationIndex((Integer)obj[row][1]);
					retval[row] = nii;
				}
			}catch(Exception e)
			{

			}
		}
		return retval;
	}
	private void setNewsID(Integer newsID) {
		m_NewsID = newsID;
	}
	public Integer getNewsID() {
		return m_NewsID;
	}
	private void setImageID(Integer imageID) {
		m_ImageID = imageID;
	}
	public Integer getImageID() {
		return m_ImageID;
	}

	public static NewsImageItem CreateNonPersistant(Integer NewsID,Integer ImageID, Integer location)
	{
		NewsImageItem retval = null;
		NewsImageItem nli = new NewsImageItem();
		nli.setNewsID(NewsID);
		nli.setImageID(ImageID);
		nli.setLocationIndex(location);
		retval = nli;
		return retval;
	}
}
