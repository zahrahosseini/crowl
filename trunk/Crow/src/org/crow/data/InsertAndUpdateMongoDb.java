/**
 * 
 */
package org.crow.data;

import java.util.List;

import org.crow.classes.FeedEntry;

import com.sun.syndication.feed.synd.SyndFeed;

/**
 * @author viksin
 *
 */
public class InsertAndUpdateMongoDb implements InsertAndUpdateOpsInterface {

	@Override
	public boolean multiInsert() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean singleInsert() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateDB() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.crow.data.InsertAndUpdateOpsInterface#insertFeeds(com.sun.syndication.feed.synd.SyndFeed)
	 */
	@Override
	public boolean insertFeeds(List<FeedEntry> feedList) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
