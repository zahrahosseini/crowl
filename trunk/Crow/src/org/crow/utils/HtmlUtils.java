/**
 * 
 */
package org.crow.utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author viksin
 *
 */
public class HtmlUtils {
	public String removeHtmlTags(String html)
	{
		String nohtml="";
		try 
		{
		        html = html.replaceAll("<br>", " ");
		        html = html.replaceAll("<br />", " ");
	                html = html.replaceAll("<br/>", " ");
			nohtml = html.replaceAll("\\<.*?>", "");
			//nohtml = nohtml.replaceAll("&nbsp;", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nohtml;
	}
	
	public ArrayList<String> findImageUrl(String feedContent)
	{
	        ArrayList<String> imageUrls= new ArrayList<String>();
		String imageUrl="";
		String imageTagRegex="<img.*?>";
		String srcRegex="src=\".*?\"";
		Pattern pTag = Pattern.compile(imageTagRegex);
		Matcher matcher = pTag.matcher(feedContent); 
		while (matcher.find()) {
			Pattern pSrc = Pattern.compile(srcRegex);
			Matcher m = pSrc.matcher(matcher.group()); 
			while (m.find()) {			
				imageUrl = m.group();
				imageUrl = imageUrl.substring(4, imageUrl.length());
				imageUrls.add(imageUrl);
			}
        }
		return imageUrls;
	}

}
