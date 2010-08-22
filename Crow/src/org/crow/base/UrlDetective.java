/**
 * 
 */
package org.crow.base;

/**
 * @author viksin
 * This class tries to determine the type of a url i.e. if it is feed url or some other type.
 */
import java.io.IOException;
import java.io.InputStream;
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
				analyzeRobotDotText(passedUrl);
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
	private boolean analyzeRobotDotText(URL url) {
		String strHost = url.getHost();

		// form URL of the robots.txt file
		String strRobot = "http://" + strHost + "/robots.txt";
		URL urlRobot;
		try { 
		    urlRobot = new URL(strRobot);
		} catch (MalformedURLException e) {
		    // something weird is happening, so don't trust it
		    return false;
		}

		String strCommands;
		try {
		    InputStream urlRobotStream = urlRobot.openStream();

		    // read in entire file
		    byte b[] = new byte[1000];
		    int numRead = urlRobotStream.read(b);
		    strCommands = new String(b, 0, numRead);
		    while (numRead != -1) {
			if (Thread.currentThread() != searchThread)
			    break;
			numRead = urlRobotStream.read(b);
			if (numRead != -1) {
			    String newCommands = new String(b, 0, numRead);
			    strCommands += newCommands;
			}
		    }
		    urlRobotStream.close();
		} catch (IOException e) {
		    // if there is no robots.txt file, it is OK to search
		    return true;
		}

		// assume that this robots.txt refers to us and 
		// search for "Disallow:" commands.
		String strURL = strRobot;
		int index = 0;
		while ((index = strCommands.indexOf(DISALLOW, index)) != -1) {
		    index += DISALLOW.length();
		    String strPath = strCommands.substring(index);
		    StringTokenizer st = new StringTokenizer(strPath);

		    if (!st.hasMoreTokens())
			break;
		    
		    String strBadPath = st.nextToken();

		    // if the URL starts with a disallowed path, it is not safe
		    if (strURL.indexOf(strBadPath) == 0)
			return false;
		}

		return true;
	    }
	
}
