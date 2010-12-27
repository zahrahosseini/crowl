import org.crow.utils.*;
import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.crow.classes.*;
import org.crow.crawler.FeedCrawler;
import org.crow.crawler.ICrawler;
import org.crow.data.*;
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
		/*BufferedReader reader = new BufferedReader(
	            new StringReader(
	                
	                "User-agent: Mediapartners-Google\n" +
	                "Disallow: \n" +

	                "User-agent: *\n" +
	                "Disallow: /search\n" +

	                "Sitemap: http://www.vikasing.com/feeds/posts/default?orderby=updated\n"

	                
	            ));*/
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
		//Base62Converter bc = new Base62Converter();
		//bc.convertTo62Base(4545454545l);
		//bc.converter(62, 4545454545l);
		//FeedParser fp = new FeedParser();
		//fp.parser("http://news.google.com/news?pz=1&cf=all&ned=us&hl=en&topic=t&output=rss");
		//fp.parser("http://www.engadget.com/rss.xml");
		//GenUtils gu = new GenUtils();
		//System.out.println(gu.generateSHAHashId("vikash"));
		String text = "Salman Khan has once again proved to be a timeless work of art. Every time the critics slam him and the producers start"+ 
		"keeping a safe distance from him, he turns around and presents us with a movie which has all of us cheering from the grandstands."+		
		"Dabangg, the biggest hit of 2010 was Salman’s movie all the way. He was all-pervading and everyone else in the film had only a secondary"+ 
		"role to play. The whistles from the stands, the gasps from theyoung and not so young women were all evidence of his everlasting charisma and"+ 
		"of his ability to draw the crowds. Dabangg once again showed us that you cannot write-off Salman Khan. Salman Khan just never seems to grow old."+ 
		"We forget the fact that this year he became 45 years old and in another five years the man is going to hit the venerable age of 50, when all"+ 
		"young chicks should be calling him “uncle “. But with each successive film he looks better than before, and at no point have we felt that he is"+ 
		"getting even slightly older. It may be due to the fact that he is physically very fit and has one of the best physiques in town. He has always been"+
		"a major advocate of a fit body and it was at his advice that Hrithik Roshan spent a lot of time and effort developing an excellent body. He also has"+
		"a face which never seems to grow old. Some fortunate human beings are blessed with features which just always look handsome. In 2004 he was voted as"+
		"the seventh best looking man in the world, and even today his chocolate boy looks combined with a body-builder’s physique make him into one of the best"+
		"looking guys in Bollywood. Compare the Prem of Maine Pyaar Kiya to the Chulbul Pandey of Dabangg and you realise that this guy is only getting better-looking"+
		"through the years. There are many who believe that the secret behind Salman Khan’s eternal youth is his single status. He has been linked with many beautiful women,"+
		"but none of them have managed to make him walk down the aisle. His charisma and magnetism are due to the fact that he is still ‘available’. He does not have a family to worry" +
		" about, and his ever-changing girlfriends keep him on his toes. We are not too sure about what is the real reason why Salman Khan continues to tug at our heart-strings. After"+
		"all great bodies and handsome faces are available in large measures in Bollywood. There have been single stars that did not succeed and married stars who are at the peak of"+
		"their careers. Maybe it is just a combination of many factors. He takes care of his looks, he continues to act in films which draw the crowds and despite all the controversies"+
		"and tangles he seems to be getting embroiled in, he still remains one of our favourite Khans. We hope that whichever fountain of eternal youth he derives his magic from, will" +
		" remain a part of his life for many more years.";
		//RemoveStopWords rsw = new RemoveStopWords();
		//System.out.println(rsw.removeStopwords(text));
		//StanfordNer sn = new StanfordNer();
		//sn.identifyNE(text);
		ICrawler crawler = new FeedCrawler();
		crawler.feedCrawler("fing");
		
	}
private static void mongodbTest()
{
	try {
		Mongo m = new Mongo("192.168.1.3",27017);
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

        coll.insert(doc);/**/
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
