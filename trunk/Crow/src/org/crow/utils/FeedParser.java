/**
 * 
 */
package org.crow.utils;

/**
 * @author viksin
 * This class uses ROME library to parse the feeds.	
 */
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.crow.classes.FeedEntry;
import org.crow.classes.HttpHeaders;
import org.crow.data.*;
import org.crow.httpOps.HttpHeadersAnalysis;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;


public class FeedParser {

	public ArrayList<FeedEntry> parser(String url) {

		SyndFeedInput input = new SyndFeedInput();
		HtmlUtils htmlUtils = new HtmlUtils();
		HttpHeadersAnalysis hha = new HttpHeadersAnalysis();
		InsertAndUpdateOpsInterface dsfmd = new InsertAndUpdateMongoDb();
		GenUtils genUtils = new GenUtils();
		List<FeedEntry> feedList = new ArrayList<FeedEntry>();// ;Collections.synchronizedList(new ArrayList<FeedEntry>());
		try {
			URL feedUrl = new URL(url);
			SyndFeed feed = input.build(new XmlReader(feedUrl));
			List<SyndEntry> feedEntries = feed.getEntries();
			for (SyndEntry se : feedEntries) {
				HttpHeaders httpHeaders = hha.getHttpHeaders(new URL(se.getLink().toString()));
				FeedEntry fe = new FeedEntry();
				fe.setFeedEntry(se);
				fe.setNoHtmlContent(htmlUtils.removeHtmlTags(se.getDescription().getValue()));
				fe.setFeedImageUrl(htmlUtils.findImageUrl(se.getDescription().getValue()));
				fe.setLastModDateOnServer(httpHeaders.getLastModified());
				fe.setFeedGetDateTime(genUtils.getCurrentDateTime("yyyy-MM-dd HH:mm:ss"));
				feedList.add(fe);
			}
			dsfmd.insertFeeds(feedList);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("ERROR: " + ex.getMessage());
		}
		return (ArrayList<FeedEntry>) feedList;
	}

}
