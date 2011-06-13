import org.crow.utils.*;

import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.crow.classes.*;
import org.crow.crawler.FeedCrawler;
import org.crow.crawler.ICrawler;
import org.crow.data.*;
import org.crow.dm.DMUtils;
import org.crow.dm.RemoveStopWords;
import org.crow.httpOps.Robotstxt;
import org.crow.httpOps.UrlDetective;
import org.crow.ml.StanfordNer;
import org.crow.base.*;

import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;

import org.crow.utils.Constants;
import org.crow.utils.ImageThumbs;
import org.crow.utils.FileOps;
/**
 * @author viksin
 *
 */
public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
	    Test test = new Test();
	    //test.fingCrawler();
	    ICrawler crawler = new FeedCrawler();
            
	    ImageThumbs it = new ImageThumbs();
	    try {
	        crawler.crawlSingleUrl(new URL("http://feeds2.feedburner.com/webresourcesdepot"));
	       
        }
        catch (Exception e) {
            e.printStackTrace();
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
                InsertAndUpdateMongoDb insert = new InsertAndUpdateMongoDb();
                boolean success=false;
                ICrawler crawler = new FeedCrawler();
                Mongo m = null;
                try {
                        m = new Mongo(Constants.MongoDBServer,Constants.MongoDBServerPort);
                } catch (Exception e) {
                        e.printStackTrace();
                }
                while(true){
                        for(String s : feedUrls)
                        {
                            URL url=null;
                            try {
                                url = new URL(s);
                            }
                            catch (MalformedURLException e) {
                                e.printStackTrace();
                            }
                                List<FeedEntry> feedList = crawler.crawlSingleUrl(url);
                                success=insert.insertFeeds(feedList, "feeds", "fing",m);
                        }
                }
        }
}
