/**
 * 
 */
package org.crow.crawler;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


import org.crow.base.FeedParser;
import org.crow.classes.FeedEntry;
import org.crow.data.DBUtils;
import org.crow.data.InsertAndUpdateMongoDb;
import org.crow.data.Query;
import org.crow.utils.Constants;

import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * @author viksin
 *
 */
public class FeedCrawler implements ICrawler {
	
    /* (non-Javadoc)
     * @see org.crow.crawler.ICrawler#crawlSingleUrl(java.net.URL)
     */
    @Override
    public List<FeedEntry> crawlSingleUrl(URL url)
    {
        FeedParser feedParser = new FeedParser();
        List<FeedEntry> feedList = feedParser.parser(url);
        return feedList;
        
    }

    /* (non-Javadoc)
     * @see org.crow.crawler.ICrawler#crawlUrls(java.util.List)
     */
    @Override
    public ConcurrentHashMap<URL, List<FeedEntry>> crawlUrls(List<URL> urls)
    {
        ConcurrentHashMap<URL, List<FeedEntry>> urlFeedHashMap = new ConcurrentHashMap<URL, List<FeedEntry>>();
        for(URL url : urls)
        {    
            List <FeedEntry> feedList = crawlSingleUrl(url);
            urlFeedHashMap.put(url, feedList);
        }
        return urlFeedHashMap;
    }

    /* (non-Javadoc)
     * @see org.crow.crawler.ICrawler#crawlUrls(java.util.ArrayList)
     */
    @Override
    public ConcurrentHashMap<String, List<FeedEntry>> crawlUrls(ArrayList<String> urls)
    {
        ConcurrentHashMap<String, List<FeedEntry>> urlFeedHashMap = new ConcurrentHashMap<String, List<FeedEntry>>();
        for(String str : urls)
        {   URL url = null;
        try {
            url = new URL(str);
        }
        catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            List <FeedEntry> feedList = crawlSingleUrl(url);
            urlFeedHashMap.put(str, feedList);
        }
        return urlFeedHashMap;
    }

}
