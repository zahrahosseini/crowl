import org.crow.utils.*;
import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.crow.classes.*;
import org.crow.data.*;
import org.crow.httpOps.Robotstxt;
import org.crow.httpOps.UrlDetective;
import org.crow.base.*;

import com.mongodb.Mongo;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.MongoException;
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
//		String imgUrl ="http://www.zeenews.com/Img/2010/5/2/01-AP10050119038.jpg";
//		ImageThumbs it = new ImageThumbs();
//		FileOps fo = new FileOps();
//		fo.downloadFile(imgUrl);
//		try {
//			it.createThumbnail(Constants.TempImageDir+"/img.jpg", "C:/thumb.jpg", 120, 100);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		//fo.deleteFile();
		//SelectOps so = new SelectOps();
		//Map<String,String> k= so.getCategorizedData();
		BufferedReader reader = new BufferedReader(
	            new StringReader(
	                
	                "User-agent: Mediapartners-Google\n" +
	                "Disallow: \n" +

	                "User-agent: *\n" +
	                "Disallow: /search\n" +

	                "Sitemap: http://www.vikasing.com/feeds/posts/default?orderby=updated\n"

	                
	            ));
	        //Robotstxt(reader); 
		//Robotstxt rt = new Robotstxt(reader);
		//rt.getAllowedPaths();
		//rt.getDisallowedPaths();
		//rt.isCrawlingAllowed();news?pz=1&cf=all&ned=us&hl=en&topic=h&num=3&output=rss
		//UrlDetective ud = new UrlDetective();
		//ud.determineUrlType("http://www.foxcentral.net/foxcentral.wsdl");
		//mongodbTest();
		//sFeedUrl fu = new FeedUrl();
		//fu.setHeaders(headers);

	}
private static void mongodbTest()
{
	try {
		Mongo m = new Mongo("192.168.1.4",27017);
		DB db = m.getDB( "test" );
		Set<String> colls = db.getCollectionNames();

		for (String s : colls) {
		    System.out.println(s);
		}
		DBCollection coll = db.getCollection("foo");
        BasicDBObject doc = new BasicDBObject();

        doc.put("name", "MongoDB");
        doc.put("type", "database");
        doc.put("count", 1);

        BasicDBObject info = new BasicDBObject();

        info.put("x", 203);
        info.put("y", 102);

        doc.put("info", info);

        coll.insert(doc);
        DBCursor cur = coll.find();

        while(cur.hasNext()) {
            System.out.println(cur.next());
        }


		
		
	} catch (UnknownHostException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MongoException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	

}
