package com.hartcode.news;
import java.security.NoSuchAlgorithmException;
import java.util.*;

import com.hartcode.crypto.hash.SHA512;
import com.hartcode.exceptions.NullArgumentException;

public class NewsItem {
	private static final int MAX_TITLE_LENGTH = 50;
	private static final int MAX_TEXT_LENGTH = 10000;
	private static final int HASH_LENGTH = 128;
	private String m_Title;
	private String m_Text;
	private Date m_postdate;
	private String m_hash;
	public NewsItem()
	{
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		if (title == null)
		{
			throw new NullArgumentException("title");
		}
		if (title.length() > MAX_TITLE_LENGTH)
		{
			title = title.substring(0,MAX_TITLE_LENGTH);
		}
		m_Title = title;
		UpdateHash();
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		String title =m_Title;
		if (title == null)
		{
			title = "";
		}
		assert(title!= null);
		return title;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		if (text == null)
		{
			throw new NullArgumentException("text");
		}
		if (text.length() > MAX_TEXT_LENGTH)
		{
			text = text.substring(0,MAX_TEXT_LENGTH);
		}
		m_Text = text;
		UpdateHash();
	}
	/**
	 * @return the text
	 */
	public String getText() {
		String text =m_Text;
		if (text == null)
		{
			text = "";
		}
		assert(text!= null);
		return text;
	}
	/**
	 * @param postdate the postdate to set
	 */
	public void setPostdate(Date postdate) {
		if (postdate == null)
		{
			throw new NullArgumentException("postdate");
		}
		m_postdate = postdate;
	}
	/**
	 * @return the postdate
	 */
	public Date getPostdate() {
		Date postdate = m_postdate;
		if (postdate == null)
		{
			postdate = new Date();
		}
		assert(postdate!=null);
		return postdate;
	}

	public void setHash(String hash) {
		if (hash == null)
		{
			throw new NullArgumentException("hash");
		}
		if (hash.length() != HASH_LENGTH)
		{
			throw new IllegalArgumentException("The hash must be exactly " + String.valueOf(HASH_LENGTH) + " chars long.");
		}
		m_hash = hash;
	}
	/**
	 * @return the hash
	 */
	public String getHash() {
		if (m_hash == null)
		{
			UpdateHash();
		}
		assert(m_hash!= null);
		return m_hash;
	}
	
	protected void UpdateHash()
	{
		String title = getTitle();
		String text = getText();
		try {
			String hash = SHA512.HashIt(title+text);
			setHash(hash);
		} catch (NullArgumentException e) {
			
		} catch (NoSuchAlgorithmException e) {
			
		}
		
		
	}
	
	
}
