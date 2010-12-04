/**
 * 
 */
package org.crow.data;

import java.util.List;

import org.crow.classes.FeedEntry;


/**
 * @author viksin
 *
 */
public interface InsertAndUpdateOpsInterface {
	public boolean singleInsert();
	public boolean multiInsert();
	public boolean updateDB();
	public boolean insertFeeds(List<FeedEntry> feedList);
}
