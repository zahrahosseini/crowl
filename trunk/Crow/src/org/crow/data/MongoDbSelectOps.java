/**
 * 
 */
package org.crow.data;

import java.net.UnknownHostException;
import java.util.ArrayList;


import org.crow.utils.Constants;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;


/**
 * @author viksin
 *
 */
public class MongoDbSelectOps {

	public ArrayList<String> getMongoDbData(Query query){
	Mongo m = null;
	ArrayList<String> feedList = new ArrayList<String>(); 
	try {
		m = new Mongo(Constants.MongoDBServer , Constants.MongoDBServerPort);
		DB db = m.getDB(query.getMongoDB());
		DBCollection items = db.getCollection(query.getMongoCollection());       
        DBCursor cur = items.find().sort(new BasicDBObject("getdate",-1)).limit(500);
        while(cur.hasNext()) {
        	feedList.add(cur.next().toString());
        }
        cur.close();
        //db.requestDone();
	} catch (Exception e) {

		e.printStackTrace();
	}	
	return feedList;
	}
}
