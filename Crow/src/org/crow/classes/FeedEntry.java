package org.crow.classes;

import java.util.ArrayList;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndEntryImpl;

/**
 * @author viksin
 *
 */
public class FeedEntry{
	

	private String feedHashid;
	private String lastModDateOnServer;
	private ArrayList<String> feedImageUrl;
	private SyndEntry feedEntry;
	private String noHtmlContent;
	private String feedGetDateTime;
	private String sourceTitle;
	private String sourceLink;
	/**
	 * @param feedHashid the feedHashid to set
	 */
	public void setFeedHashid(String feedHashid) {
		this.feedHashid = feedHashid;
	}
	/**
	 * @return the feedHashid
	 */
	public String getFeedHashid() {
		return feedHashid;
	}
	/**
	 * @param lastModDateOnServer the lastModDateOnServer to set
	 */
	public void setLastModDateOnServer(String lastModDateOnServer) {
		this.lastModDateOnServer = lastModDateOnServer;
	}
	/**
	 * @return the lastModDateOnServer
	 */
	public String getLastModDateOnServer() {
		return lastModDateOnServer;
	}
	
	
	/**
	 * @param feedEntry the feedEntry to set
	 */
	public void setFeedEntry(SyndEntry feedEntry) {
		this.feedEntry = feedEntry;
	}
	/**
	 * @return the feedEntry
	 */
	public SyndEntry getFeedEntry() {
		return feedEntry;
	}
	/**
	 * @param noHtmlContent the noHtmlContent to set
	 */
	public void setNoHtmlContent(String noHtmlContent) {
		this.noHtmlContent = noHtmlContent;
	}
	/**
	 * @return the noHtmlContent
	 */
	public String getNoHtmlContent() {
		return noHtmlContent;
	}
	/**
	 * @param feedGetDate the feedGetDate to set
	 */
	public void setFeedGetDateTime(String feedGetDateTime) {
		this.feedGetDateTime = feedGetDateTime;
	}
	/**
	 * @return the feedGetDate
	 */
	public String getFeedGetDateTime() {
		return feedGetDateTime;
	}
	/**
	 * @param sourceTitle the sourceTitle to set
	 */
	public void setSourceTitle(String sourceTitle) {
		this.sourceTitle = sourceTitle;
	}
	/**
	 * @return the sourceTitle
	 */
	public String getSourceTitle() {
		return sourceTitle;
	}
	/**
	 * @param sourceLink the sourceLink to set
	 */
	public void setSourceLink(String sourceLink) {
		this.sourceLink = sourceLink;
	}
	/**
	 * @return the sourceLink
	 */
	public String getSourceLink() {
		return sourceLink;
	}
    /**
     * @param feedImageUrl the feedImageUrl to set
     */
    public void setFeedImageUrl(ArrayList<String> feedImageUrl)
    {
        this.feedImageUrl = feedImageUrl;
    }
    /**
     * @return the feedImageUrl
     */
    public ArrayList<String> getFeedImageUrl()
    {
        return feedImageUrl;
    }

}
