/**
 * 
 */
package org.crow.base;

/**
 * @author viksin
 * This class tries to determine the type of a url i.e. if it is feed url or some other type.
 */
import java.util.ArrayList;
public class UrlDetective {

	public void determineUrlType()
	{
		ArrayList<String> urls = new ArrayList<String>();
		GetUrls gUrls = new GetUrls();
		urls=gUrls.getAllUrls();
		//next check if the url is syntactically correct
		//if it is a relative url try to get the domain for the same and then analyze
	}
}
