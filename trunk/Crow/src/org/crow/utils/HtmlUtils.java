/**
 * 
 */
package org.crow.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.crow.httpOps.Robotstxt;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import de.l3s.boilerpipe.BoilerpipeProcessingException;
import de.l3s.boilerpipe.extractors.ArticleExtractor;

/**
 * @author viksin
 *
 */
public class HtmlUtils {
	public String removeHtmlTags(String html)
	{
		String nohtml=null;
		try 
		{
		        html = html.replaceAll("<br>", " ");
		        html = html.replaceAll("<br />", " ");
	                html = html.replaceAll("<br/>", " ");
			nohtml = html.replaceAll("\\<(.|\n)*?>", "");
			//nohtml = nohtml.replaceAll("&nbsp;", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nohtml;
	}
	
	public ArrayList<String> findImageUrl(String feedContent)
	{
	        ArrayList<String> imageUrls= new ArrayList<String>();
		String imageUrl=null;
		String imageTagRegex="<img.*?>";
		String srcRegex="src=\".*?\"";
		Pattern pTag = Pattern.compile(imageTagRegex);
		Matcher matcher = pTag.matcher(feedContent); 
		while (matcher.find()) 
		{
			Pattern pSrc = Pattern.compile(srcRegex);
			Matcher m = pSrc.matcher(matcher.group()); 
			while (m.find()) 
			{			
				imageUrl = m.group();
				imageUrl = imageUrl.substring(4, imageUrl.length());
				imageUrl=imageUrl.replaceAll("\"", "");
				imageUrls.add(imageUrl);
			}
                }
		return imageUrls;
	}
	
	public String getCompleteContentFromURL(String urlStr) throws MalformedURLException, BoilerpipeProcessingException
	{
	    URL url = new URL(urlStr);
	    // NOTE: Use ArticleExtractor unless DefaultExtractor gives better results for you
	    String text = ArticleExtractor.INSTANCE.getText(url);
            return text;
	}
	
	public List<String> getURLsFromHTML(String URL) throws IOException{
	    List<String> urlList = new ArrayList<String>();
	    Document doc = Jsoup.connect(URL).get();
	        Elements links = doc.select("a[href]");
	        for (Element link : links) {
	            urlList.add(link.attr("abs:href"));
	        }
            return urlList; 
	  }
	public List<String> getURLsFromHTML(Document doc) throws IOException{
            List<String> urlList = new ArrayList<String>();
                Elements links = doc.select("a[href]");
                for (Element link : links) {
                    urlList.add(link.attr("abs:href"));
                }
            return urlList; 
          }
}
