package com.hartcode.news.reader.data;
import java.util.Date;


public class App {
	protected Integer m_ID = -1;
	private String m_ASIN = null;
	private String  m_IconUrl = null;
	protected String m_Title = null;
	private Double m_StarsOutOfFive = -1.0;
	private Date m_EffectiveDate = null;
	private Date m_TermDate = null;
	
	public Integer getID()
	{
		return m_ID;
	}
	public void setID(Integer value)
	{
		m_ID = value;
	}
	public String getTitle()
	{
		return m_Title;
	}
	public void setTitle(String value)
	{
		m_Title = value;
	}
	public String getASIN() {
		return m_ASIN;
	}
	public void setASIN(String m_ASIN) {
		this.m_ASIN = m_ASIN;
	}
	public String getIconUrl() {
		return m_IconUrl;
	}
	public void setIconUrl(String icon) {
		m_IconUrl = icon;
	}
	public Double getStarsOutOfFive() {
		return m_StarsOutOfFive;
	}
	public void setStarsOutOfFive(Double starsOutOfFive) {
		m_StarsOutOfFive = starsOutOfFive;
	}
	/**
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate() {
		return m_EffectiveDate;
	}
	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		m_EffectiveDate = effectiveDate;
	}
	/**
	 * @return the termDate
	 */
	public Date getTermDate() {
		return m_TermDate;
	}
	/**
	 * @param termDate the termDate to set
	 */
	public void setTermDate(Date termDate) {
		m_TermDate = termDate;
	}
}
