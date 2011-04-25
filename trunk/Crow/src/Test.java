import org.crow.utils.*;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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
		ICrawler crawler = new FeedCrawler();
		crawler.feedCrawler("fing");

	}
}
