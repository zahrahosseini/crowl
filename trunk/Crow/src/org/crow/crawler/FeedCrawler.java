/**
 * 
 */
package org.crow.crawler;

import java.util.ArrayList;


import org.crow.data.DBUtils;
import org.crow.data.Query;

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
		String dataColumn="feedurl";
		String sqlQuery="select "+dataColumn+" from fingfeedurls";
		Query query = new Query();
		query.setStatement(sqlQuery);
		query.setSelectColumn(dataColumn);
		DBUtils dbu = new DBUtils();
		ArrayList<String> feedUrls =dbu.getAllUrls(query);
		Crawler crawler = new Crawler();
		crawler.setUrls(feedUrls);
		for(String s : crawler.getUrls())
		{
			System.out.println(s);
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
