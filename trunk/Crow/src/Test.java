import org.crow.utils.*;
import java.net.*;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import org.crow.classes.*;
import org.crow.data.*;
import org.crow.httpOps.Robotstxt;
import org.crow.httpOps.UrlDetective;
import org.crow.base.*;

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
		UrlDetective ud = new UrlDetective();
		ud.determineUrlType("http://www.foxcentral.net/foxcentral.wsdl");
		
		//sFeedUrl fu = new FeedUrl();
		//fu.setHeaders(headers);

	}

	
	

}
