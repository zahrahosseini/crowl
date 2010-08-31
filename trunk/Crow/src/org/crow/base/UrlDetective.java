/**
 * 
 */
package org.crow.base;

/**
 * @author viksin
 * This class tries to determine the type of a url i.e. if it is feed url or some other type.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


import java.net.URLConnection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import sun.net.www.protocol.http.HttpURLConnection;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

//import sun.net.www.http.HttpClient;

public class UrlDetective {
	Thread searchThread;
    public static final String DISALLOW = "Disallow:";

	public void determineUrlType(String url)
	{
		ArrayList<String> urls = new ArrayList<String>();
		GetUrls gUrls = new GetUrls();
		//urls=gUrls.getAllUrls();
		
		//next check if the url is syntactically correct
		//if it is a relative url try to get the domain for the same and then analyze
		//for(String url:urls)
		//{
			try {
				URL passedUrl = new URL(url);
				boolean alreadyConnected=false;
				//DefaultHttpClient httpClient = new DefaultHttpClient();
				//HttpGet pageGet = new HttpGet(feedUrl.toURI());
				//HttpResponse response = httpClient.execute(pageGet);
				analyzeRobotsDotText(passedUrl);
				URLConnection conn = passedUrl.openConnection();
				if(conn instanceof HttpURLConnection)
				{
					HttpURLConnection httpConn = (HttpURLConnection)conn;
					int urlResponseCode = httpConn.getResponseCode();
					//httpConn.getRequestProperties()
					String contentType=httpConn.getContentType();
					if(urlResponseCode<100)
					{
						conn.connect();
					}
					System.out.println("REP CODE  :  "+urlResponseCode+"ct"+contentType);
				}
				for (int i=0; ; i++) {
			        String headerName = conn.getHeaderFieldKey(i);
			        String headerValue = conn.getHeaderField(i);
			        System.out.println(headerName+"  :  "+headerValue);
			        if (headerName == null && headerValue == null) {
			            // No more headers
			            break;
			        }
			        if (headerName == null) {
			            // The header value contains the server's HTTP version
			        }
			    }
				//SyndFeed feed = input.build(new XmlReader(response.getEntity().getContent()));
				//response.getStatusLine();SyndFeedInput input = new SyndFeedInput();
			} catch (Exception e) {				
				e.printStackTrace();
			}
			
		//}
	}
	private void analyzeRobotsDotText(URL url) {
		String strHost = url.getHost();

		String strRobot = "http://" + strHost + "/robots.txt";
		URL urlRobot;
		try { 
		    urlRobot = new URL(strRobot);
		    InputStream urlRobotStream = urlRobot.openStream();
		    BufferedReader br = new BufferedReader(new InputStreamReader(urlRobotStream));
		    
		} catch (Exception e) {
		    //return true;
		}

		
	    }
	
}
