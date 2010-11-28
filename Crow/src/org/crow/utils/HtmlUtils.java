/**
 * 
 */
package org.crow.utils;

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
			nohtml = html.replaceAll("\\<.*?>", "");
			//nohtml = nohtml.replaceAll("&nbsp;", "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nohtml;
	}
	
	public String findImageUrl(String feedContent)
	{
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
				imageUrl= imageUrl.substring(4, imageUrl.length());			
			}
        }
		return imageUrl;
	}

}
