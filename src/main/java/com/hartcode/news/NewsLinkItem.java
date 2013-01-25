package com.hartcode.news;

import java.security.InvalidParameterException;
import com.hartcode.news.poster.data.NewsPosterDAO;
import com.hartcode.news.reader.data.NewsReaderDAO;

public class NewsLinkItem {

	private static final int DEFAULT_START_INDEX = Integer.MIN_VALUE;
	private static final int DEFAULT_FINISH_INDEX = Integer.MIN_VALUE;
	private int m_StartIndex = DEFAULT_START_INDEX;
	private int m_FinishIndex = DEFAULT_FINISH_INDEX;
	private Integer m_LinkID = null;
	private Integer m_NewsID = null;
	private static String TableName = "NewsLinkItem"; 

	private NewsLinkItem()
	{

	}
	public NewsLinkItem(int linkID,int NewsItemID, int start, int finish)
	{
		setLinkID(linkID);
		setNewsID(NewsItemID);
		setStartIndex(start);
		setFinishIndex(finish);
		SQLInsert();
	}

	public LinkItem getLink() {
		LinkItem retval = null;
		if (getLinkID() != null)
		{
			retval = new LinkItem(getLinkID()); 
		}
		return retval;
	}
	private void setStartIndex(int startIndex) {
		if (startIndex < 0)
		{
			throw new InvalidParameterException("Startindex cannot be less than 0.");
		}
		if (getFinishIndex() != DEFAULT_FINISH_INDEX )
		{
			if (startIndex > getFinishIndex())
			{
				throw new InvalidParameterException("Startindex cannot be greater than finishindex.");
			}else if (startIndex == getFinishIndex())
			{
				throw new InvalidParameterException("Startindex cannot be equal to finishindex.");	
			}
		}
		m_StartIndex = startIndex;
	}
	public int getStartIndex() {
		return m_StartIndex;
	}

	private void setFinishIndex(int finishIndex) {
		if (finishIndex < 0)
		{
			throw new InvalidParameterException("Finishindex cannot be less than 0.");
		}
		if (getStartIndex() != DEFAULT_START_INDEX )
		{
			if (finishIndex < getStartIndex())
			{
				throw new InvalidParameterException("Finishindex cannot be less than startindex.");
			}else if (finishIndex == getStartIndex())
			{
				throw new InvalidParameterException("Finishindex cannot be equal to startindex.");	
			}
		}
		m_FinishIndex = finishIndex;
	}
	public int getFinishIndex() {
		return m_FinishIndex;
	}

	private void SQLInsert()
	{
		Integer linkid = getLinkID();
		Integer newsid = getNewsID();
		Integer start = getStartIndex();
		Integer finish = getFinishIndex();


		String sql = "Insert into "+TableName+" (newsitemid,linkid,startindex, finishindex) values";
		sql += "("+newsid.toString()+","+linkid.toString()+","+start.toString()+","+finish.toString()+");";
		try {
			NewsPosterDAO dao = new NewsPosterDAO();
			dao.ExecuteSql(sql);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public static NewsLinkItem[] GetByNewsID(Integer NewsID)
	{
		NewsLinkItem[] retval = null;
		if (NewsID != null)
		{
			String sql = "Select linkid, startindex,finishindex from "+TableName+" where newsitemid = " + NewsID.toString();
			try {
				NewsReaderDAO dao = new NewsReaderDAO();
				Object[][] obj = dao.Select(sql);
				retval = new NewsLinkItem[obj.length];
				for (int row = 0; row < obj.length; row++)
				{
					NewsLinkItem nli = new NewsLinkItem();
					nli.setNewsID(NewsID);
					nli.setLinkID((Integer)obj[row][0]);
					nli.setStartIndex((Integer)obj[row][1]);
					nli.setFinishIndex((Integer)obj[row][2]);
					retval[row] = nli;
				}
			}catch(Exception e)
			{

			}
		}
		return retval;
	}
	public static NewsLinkItem CreateNonPersistant(Integer NewsID,Integer LinkID, Integer start,Integer finish)
	{
		NewsLinkItem retval = null;
		NewsLinkItem nli = new NewsLinkItem();
		nli.setNewsID(NewsID);
		nli.setLinkID(LinkID);
		nli.setStartIndex(start);
		nli.setFinishIndex(finish);
		retval = nli;
		return retval;
	}
	
	private void setNewsID(Integer newsID) {
		m_NewsID = newsID;
	}
	public Integer getNewsID() {
		return m_NewsID;
	}
	private void setLinkID(Integer linkID) {
		m_LinkID = linkID;
	}
	public Integer getLinkID() {
		return m_LinkID;
	}

}
