/**
 * 
 */
package org.crow.crawler;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;


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
	 * @see org.crow.crawler.ICrawler#feedCrawler()
	 */
	@Override
	public void feedCrawler(String mode) {
		if(mode.equalsIgnoreCase("fing"))
		{
			fingCrawler();
		}
	}
	
	private void fingCrawler()
	{
		//TODO logic of db call should be moved to starting point (e.g. main method)
		String dataColumn="feedurl";
		String sqlQuery="select "+dataColumn+" from fingfeedurls";
		Query query = new Query();
		query.setStatement(sqlQuery);
		query.setSelectColumn(dataColumn);
		DBUtils dbu = new DBUtils();
		ArrayList<String> feedUrls =dbu.getAllUrls(query);
		Crawler crawler = new Crawler();
		crawler.setUrls(feedUrls);
		FeedParser feedParser = new FeedParser();
		InsertAndUpdateMongoDb insert = new InsertAndUpdateMongoDb();
		boolean success=false;
		Mongo m = null;
		try {
			m = new Mongo(Constants.MongoDBServer,Constants.MongoDBServerPort);
		} catch (Exception e) {
			e.printStackTrace();
		}
		while(true){
			for(String s : crawler.getUrls())
			{
				List<FeedEntry> feedList = feedParser.parser(s);
				success=insert.insertFeeds(feedList, "feeds", "fing",m);
				//System.out.println(success);
			}
		}
	}

	/* (non-Javadoc)
	 * @see org.crow.crawler.ICrawler#docCrawler()
	 */
	@Override
	public void docCrawler() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.crow.crawler.ICrawler#generalCrawler()
	 */
	@Override
	public void generalCrawler() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see org.crow.crawler.ICrawler#imageCrawler()
	 */
	@Override
	public void imageCrawler() {
		// TODO Auto-generated method stub
		
	}
}
